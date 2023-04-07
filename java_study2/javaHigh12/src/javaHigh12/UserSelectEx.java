package javaHigh12;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserSelectEx {

	public static void main(String[] args) {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "system", "1234");
			System.out.println("���� ����");

			String sql = "select * from users where userid=?";
			PreparedStatement pstmt = conn.prepareStatement(sql); // ����� ������ sql����ִ´�.
			pstmt.setString(1, "winter");	// userid="winter"�� �÷��� ������
			ResultSet rs = pstmt.executeQuery(); // sql�� ���� ��, ResultSet�� ���� ������ �б�

			if (rs.next()) { // ResultSet�� ������ ���� 1�� �����Ѵٸ� true
				User user = new User();
				user.setUserId(rs.getString("userid")); // �÷� �̸��� �̿��ϰų�
				user.setUserName(rs.getString(2)); // �÷� ������ �̿��� �� �ִ�.
				user.setUserPassword(rs.getString(3));
				user.setUserAge(rs.getInt(4));
				user.setUserEmail(rs.getString(5));

				System.out.println(user); // ��ü ���������
			} else {
				System.out.println("����� ���̵� �����ϴ�.");
			}
			rs.close(); // ResultSet �ݱ�

			pstmt.close(); // pPreparedStatement �ݱ�
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