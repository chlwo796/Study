package javaChap20.example02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BoardWithFileInsertExample {
	public static void main(String[] args) {
		Connection conn = null;
		try {
			// JDBC Driver를 메모리로 로딩, DriverManager 등록
			Class.forName("oracle.jdbc.OracleDriver");

			// DB와 연결

			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "java", "oracle");
			System.out.println("연결 성공");

			// DB작업
			String sql = "insert into boards (bno, btitle, bcontent, bwriter, bdate, bfilename, bfiledata) values (seq_bno.nextval, ?, ?, ?, sysdate, ?, ?)";
			PreparedStatement pstmt = conn.prepareStatement(sql, new String[] { "bno", "btitle" });

			pstmt.setString(1, "소나기");
			pstmt.setString(2, "눈");
			pstmt.setString(3, "falling");
			pstmt.setString(4, "8.jpg");

//			pstmt.setBlob(5, null);	// 컴파일오류, setBlob()메소드의 오버로딩과 관련. InputStream 타입인지, Blob타입인지 명시해주어야한다.
//			Blob blob = null;	// 이를 해결하기 위한 Blob타입의 변수 선언 후 대입
			try {
				pstmt.setBlob(5, new FileInputStream("src/javaChap20/example02/8.jpg"));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int rows = pstmt.executeUpdate();
			System.out.println(rows);

			if (rows == 1) {
				ResultSet rs = pstmt.getGeneratedKeys();
				if (rs.next()) {
					// rs에 데이터가 없으면
					int bno = rs.getInt(1);
					System.out.println("저장된 bno : " + bno);
					String btitle = rs.getString(2);
					System.out.println("저장된 btitle : " + btitle);
				}
				rs.close();
			}

			pstmt.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
			}
			System.out.println("연결 끊기");
		}
	}
}