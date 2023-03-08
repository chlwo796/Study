package javaChap20.example01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionExample {
	public static void main(String[] args) {
//		Connection conn = null;
//		try {
//			// JDBC Driver를 메모리로 로딩, DriverManager 등록
//			Class.forName("oracle.jdbc.OracleDriver");
//
//			// DB와 연결
//
//			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "java", "oracle");
//			System.out.println("연결 성공");
//
//			// DB작업
//
//			System.out.println("연결 끊기");
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			try {
//				if (conn != null) {
//					conn.close();
//				}
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		// 자동 리소스 기능
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "java",
					"oracle")) {
				System.out.println("연결 성공");
				// DB작업
			} catch (SQLException e) {

			}
			System.out.println("연결 끊기");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}