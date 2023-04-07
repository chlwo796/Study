package javaHigh12;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

// 프로시저를 호출하는 자바프로그램
public class ProcedureCallEx {

	public static void main(String[] args) {
		Connection conn = null;

		try {
			Class.forName("oracle.jdbc.OracleDriver");// 1. 오라클 드라이버를 자바로 로딩한다

			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "system", "1234");// 2
			System.out.println("연결 성공");

			String sql = "{ call user_create( ?,?,?,?,?,? ) }";
			CallableStatement cstmt = conn.prepareCall(sql);

			cstmt.setString(1, "summer"); // DB의 프로시저의 변수로 삽입됨 a_userid in users.userid%type,
			cstmt.setString(2, "한여름"); // a_username in users.username%type,
			cstmt.setString(3, "12345");
			cstmt.setInt(4, 26);
			cstmt.setString(5, "summer@naver.com");
			cstmt.registerOutParameter(6, Types.INTEGER); // 프로시저의 결과 담을 자료 a_rows out pls_integer

			cstmt.execute();

			int rows = cstmt.getInt(6);
			System.out.println("저장된 행 수 : " + rows); // 지금 저장된 행수 1을 출력한다.
			cstmt.close(); // 자원 반납

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

}