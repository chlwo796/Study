package javaChap20.example07;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class FunctionCallExample {
	public static void main(String[] args) {
		Connection conn = null;
		try {
			// JDBC Driver를 메모리로 로딩, DriverManager 등록
			Class.forName("oracle.jdbc.OracleDriver");

			// DB와 연결

			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "java", "oracle");
			System.out.println("연결 성공");

			String sql = "{? = call user_login(?, ?)}";
			CallableStatement cstmt = conn.prepareCall(sql);

			cstmt.registerOutParameter(1, Types.INTEGER);
			cstmt.setString(2, "winter");
			cstmt.setString(3, "12345");

			cstmt.execute();
			int result = cstmt.getInt(1);
			switch (result) {
			case 0:
				System.out.println("로그인성공");
				break;
			case 1:
				System.out.println("비밀번호오류");
				break;
			case 2:
				System.out.println("존재하지않는아이디");
				break;
			}
			cstmt.close();
		} catch (Exception e) {
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
}