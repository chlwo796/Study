package javaHigh12;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionEx {

	public static void main(String[] args) {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "system", "1234");
			System.out.println("연결 성공");
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}// jdbc driver 등록
		finally {
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
	}
}