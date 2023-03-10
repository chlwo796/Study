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
			// JDBC Driver를 메모리로 로딩, DriverManager 등록
			Class.forName("oracle.jdbc.OracleDriver");

			// DB와 연결

			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "java", "oracle");
			System.out.println("연결 성공");

			// DB작업
			String sql = "select userid, username, userpassword, userage, useremail from users where userid=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, "winter");
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				// 매개변수를 직접 받으니 데이터 양이 많아질수록 매우 불편하다..(컬럼양)
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
				System.out.println("사용자 아이디가 존재하지 않습니다.");
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
			System.out.println("연결 끊기");
		}
	}

	public static void printUser(String userId, String userName, String userPassword, int userAge, String userEmail) {
		// 매개변수를 직접 받으니 데이터 양이 많아질수록 매우 불편하다..
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
		// toString() 으로 간편하게
		System.out.println(user);
	}
}