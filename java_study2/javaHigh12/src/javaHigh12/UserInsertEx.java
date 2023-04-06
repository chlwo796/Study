package javaHigh12;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserInsertEx {

	public static void main(String[] args) {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "system", "1234");
			System.out.println("���� ����");

			String sql = "insert into users (userid, username, userpassword, userage, useremail) values (?,?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);	// ����� ������ sql����ִ´�.
			pstmt.setString(1, "winter1");
			pstmt.setString(2, "�Ѱܿ�1");
			pstmt.setString(3, "123451");
			pstmt.setInt(4, 35);
			pstmt.setString(5, "winter1@mycompany.com");

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