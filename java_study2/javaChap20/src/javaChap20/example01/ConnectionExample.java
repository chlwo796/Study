package javaChap20.example01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionExample {
	public static void main(String[] args) {
//		Connection conn = null;
//		try {
//			// JDBC Driver�� �޸𸮷� �ε�, DriverManager ���
//			Class.forName("oracle.jdbc.OracleDriver");
//
//			// DB�� ����
//
//			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "java", "oracle");
//			System.out.println("���� ����");
//
//			// DB�۾�
//
//			System.out.println("���� ����");
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
		// �ڵ� ���ҽ� ���
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "java",
					"oracle")) {
				System.out.println("���� ����");
				// DB�۾�
			} catch (SQLException e) {

			}
			System.out.println("���� ����");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}