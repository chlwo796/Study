package javaChap20.example05;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserSelectExample {
	public static void main(String[] args) throws FileNotFoundException {
		Connection conn = null;
		try {
			// JDBC Driver�� �޸𸮷� �ε�, DriverManager ���
			Class.forName("oracle.jdbc.OracleDriver");

			// DB�� ����

			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "java", "oracle");
			System.out.println("���� ����");

			// DB�۾�
			String sql = "select userid, username, userpassword, userage, useremail from users where userid=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, "winter");
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				// �Ű������� ���� ������ ������ ���� ���������� �ſ� �����ϴ�..(�÷���)
//				String userId = rs.getString("userid");
//				String userName = rs.getString("username");
//				String userPassword = rs.getString("userpassword");
//				int userAge = rs.getInt("userage");
//				String userEmail = rs.getString("useremail");
//				printUser(userId, userName, userPassword, userAge, userEmail);

				User user = new User();
				user.setUserId(rs.getString("userId"));
				user.setUserName(rs.getString("username"));
				user.setUserPassword(rs.getString("userpassword"));
				user.setUserAge(rs.getInt("userage"));
				user.setUserEmail(rs.getString("useremail"));

				printUser2(user);

			} else {
				System.out.println("����� ���̵� �������� �ʽ��ϴ�.");
			}

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

	public static void printUser(String userId, String userName, String userPassword, int userAge, String userEmail) {
		// �Ű������� ���� ������ ������ ���� ���������� �ſ� �����ϴ�..
		System.out.println("userId: " + userId);
		System.out.println("userName: " + userName);
		System.out.println("userPassword: " + userPassword);
		System.out.println("userEmail: " + userEmail);
		System.out.println("userAge: " + userAge);
	}

	public static void printUser2(User user) {
		System.out.println("userId: " + user.getUserId());
		System.out.println("userName: " + user.getUserName());
		System.out.println("userPassword: " + user.getUserPassword());
		System.out.println("userEmail: " + user.getUserEmail());
		System.out.println("userAge: " + user.getUserAge());
		// toString() ���� �����ϰ�
		System.out.println(user);
	}
}