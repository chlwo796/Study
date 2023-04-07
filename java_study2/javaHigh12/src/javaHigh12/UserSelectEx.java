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
			System.out.println("연결 성공");

			String sql = "select * from users where userid=?";
			PreparedStatement pstmt = conn.prepareStatement(sql); // 연결된 곳으로 sql문장넣는다.
			pstmt.setString(1, "winter");	// userid="winter"인 컬럼의 데이터
			ResultSet rs = pstmt.executeQuery(); // sql문 실행 후, ResultSet을 통해 데이터 읽기

			if (rs.next()) { // ResultSet의 데이터 행이 1개 존재한다면 true
				User user = new User();
				user.setUserId(rs.getString("userid")); // 컬럼 이름을 이용하거나
				user.setUserName(rs.getString(2)); // 컬럼 순번을 이용할 수 있다.
				user.setUserPassword(rs.getString(3));
				user.setUserAge(rs.getInt(4));
				user.setUserEmail(rs.getString(5));

				System.out.println(user); // 객체 데이터출력
			} else {
				System.out.println("사용자 아이디가 없습니다.");
			}
			rs.close(); // ResultSet 닫기

			pstmt.close(); // pPreparedStatement 닫기
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} // jdbc driver 등록
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