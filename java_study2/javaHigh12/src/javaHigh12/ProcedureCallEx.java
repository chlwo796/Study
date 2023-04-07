package javaHigh12;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

// ���ν����� ȣ���ϴ� �ڹ����α׷�
public class ProcedureCallEx {

	public static void main(String[] args) {
		Connection conn = null;

		try {
			Class.forName("oracle.jdbc.OracleDriver");// 1. ����Ŭ ����̹��� �ڹٷ� �ε��Ѵ�

			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "system", "1234");// 2
			System.out.println("���� ����");

			String sql = "{ call user_create( ?,?,?,?,?,? ) }";
			CallableStatement cstmt = conn.prepareCall(sql);

			cstmt.setString(1, "summer"); // DB�� ���ν����� ������ ���Ե� a_userid in users.userid%type,
			cstmt.setString(2, "�ѿ���"); // a_username in users.username%type,
			cstmt.setString(3, "12345");
			cstmt.setInt(4, 26);
			cstmt.setString(5, "summer@naver.com");
			cstmt.registerOutParameter(6, Types.INTEGER); // ���ν����� ��� ���� �ڷ� a_rows out pls_integer

			cstmt.execute();

			int rows = cstmt.getInt(6);
			System.out.println("����� �� �� : " + rows); // ���� ����� ��� 1�� ����Ѵ�.
			cstmt.close(); // �ڿ� �ݳ�

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