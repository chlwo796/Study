package javaHigh12;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BoardsInsertEx {

	public static void main(String[] args) {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "system", "1234");
			System.out.println("연결 성공");
			String sql = "insert into boards (bno, btitle, bcontent, bwriter, bdate, bfilename, bfiledata) values (seq_bno.nextval, ?, ?, ?, sysdate, ?, ?)";
			PreparedStatement pstmt = conn.prepareStatement(sql, new String[] {"bno"});
			pstmt.setString(1,"이게 뭐야");
			pstmt.setString(2, "이게 무슨 사진");
			pstmt.setString(3, "winter");
			pstmt.setString(4, "2.jpg");
			pstmt.setBlob(5, new FileInputStream("src/javaHigh12/2.jpg"));
			
			int rows = pstmt.executeUpdate();	// 데이터베이스 insert문 실행
			System.out.println("저장된 행 수 : " + rows);
			if(rows == 1) {
				ResultSet rs = pstmt.getGeneratedKeys();	// new String[] {"bno"} 에 기술된 컬럼값
				if(rs.next()) {
					int bno = rs.getInt(1);	// insert 후 생성된 시퀀스넘버를 가져옴(확인용)
					System.out.println("저장된 bno : " + bno);
				}
				rs.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} // jdbc driver 등록
		finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
	}
}