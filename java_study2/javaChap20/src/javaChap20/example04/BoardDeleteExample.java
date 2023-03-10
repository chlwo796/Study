package javaChap20.example04;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BoardDeleteExample {
	public static void main(String[] args) throws FileNotFoundException {
		Connection conn = null;
		try {
			// JDBC Driver를 메모리로 로딩, DriverManager 등록
			Class.forName("oracle.jdbc.OracleDriver");

			// DB와 연결

			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "java", "oracle");
			System.out.println("연결 성공");

			// DB작업
			String sql = "delete from boards where bwriter=? ";
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, "winter");
			int rows = pstmt.executeUpdate();
			System.out.println("삭제된 행 수 : " + rows);

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