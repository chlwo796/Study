package javaHigh12;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BoardDeleteEx {

	public static void main(String[] args) {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "system", "1234");
			System.out.println("���� ����");

			String sql = "delete from boards where bwriter=?";
			PreparedStatement pstmt = conn.prepareStatement(sql); // ����� ������ sql����ִ´�.
			pstmt.setString(1, "����ȯ");

			int rows = pstmt.executeUpdate(); // �����ͺ��̽��� insert���� ����
			System.out.println("Boards ������ �� �� : " + rows);
			
			sql = "delete from users where username=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "�ѿ���");
			
			rows = pstmt.executeUpdate();
			System.out.println("Users ������ �� �� : " + rows);
			
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