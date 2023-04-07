package javaHigh12;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsersUpdateEx {

	public static void main(String[] args) {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "system", "1234");
			System.out.println("���� ����");

			String sql = "update users set username=?, userpassword=? where userid=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);	// ����� ������ sql����ִ´�.
			pstmt.setString(1, "�ѿ���");
			pstmt.setString(2, "123456");
			pstmt.setString(3, "winter1");
			
			int rows = pstmt.executeUpdate();	// �����ͺ��̽��� insert���� ����
			System.out.println("����� �� �� : " + rows);
			
			pstmt.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} // jdbc driver ���
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