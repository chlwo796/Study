package javaChap20.example03;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BoardUpdateExample {
	public static void main(String[] args) throws FileNotFoundException {
		Connection conn = null;
		try {
			// JDBC Driver를 메모리로 로딩, DriverManager 등록
			Class.forName("oracle.jdbc.OracleDriver");

			// DB와 연결

			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "java", "oracle");
			System.out.println("연결 성공");

			// DB작업
			String sql = new StringBuilder()
					// 각 문 끝에는 " "공백을 넣어주는 것이 좋다(실수방지)
					.append("update boards set ")
					//.append("btitle=?, ")
					//.append("bcontent=?, ")
					.append("bfilename=?, ")
					.append("bfiledata=? ")
					.append("where bno=?").toString();
			PreparedStatement pstmt = conn.prepareStatement(sql, new String[] { "bno", "btitle" });

//			pstmt.setString(1, "소나기가");
//			pstmt.setString(2, "소나기가 엄청내려여");
			pstmt.setString(1, "rain");
			pstmt.setBlob(2, new FileInputStream("src/javaChap20/example03/3.jpg"));
			pstmt.setInt(3, 1);

			int rows = pstmt.executeUpdate();
			System.out.println("수정된 행 수 : " + rows);

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