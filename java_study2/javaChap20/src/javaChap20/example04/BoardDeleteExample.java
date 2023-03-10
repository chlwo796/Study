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
			// JDBC Driver�� �޸𸮷� �ε�, DriverManager ���
			Class.forName("oracle.jdbc.OracleDriver");

			// DB�� ����

			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "java", "oracle");
			System.out.println("���� ����");

			// DB�۾�
			String sql = "delete from boards where bwriter=? ";
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, "winter");
			int rows = pstmt.executeUpdate();
			System.out.println("������ �� �� : " + rows);

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
			System.out.println("���� ����");
		}
	}
}