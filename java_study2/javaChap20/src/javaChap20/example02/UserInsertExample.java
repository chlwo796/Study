package javaChap20.example02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserInsertExample {
	public static void main(String[] args) {
		Connection conn = null;
		try {
			// JDBC Driver를 메모리로 로딩, DriverManager 등록
			Class.forName("oracle.jdbc.OracleDriver");

			// DB와 연결

			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "java", "oracle");
			System.out.println("연결 성공");

			// DB작업
			String sql = "insert into users (userid, username, userpassword, userage, useremail) values (?, ?, ?, ?, ?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, "fail2");
			pstmt.setString(2, "최재환");
			pstmt.setString(3, "123456");
			pstmt.setInt(4, 30);
			pstmt.setString(5, "chlwo796@naver.com");

			int rows = pstmt.executeUpdate();
			System.out.println(rows);
			
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