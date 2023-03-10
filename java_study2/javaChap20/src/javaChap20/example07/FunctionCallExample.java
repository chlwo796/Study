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
			// JDBC Driver�� �޸𸮷� �ε�, DriverManager ���
			Class.forName("oracle.jdbc.OracleDriver");

			// DB�� ����

			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "java", "oracle");
			System.out.println("���� ����");

			String sql = "{? = call user_login(?, ?)}";
			CallableStatement cstmt = conn.prepareCall(sql);

			cstmt.registerOutParameter(1, Types.INTEGER);
			cstmt.setString(2, "winter");
			cstmt.setString(3, "12345");

			cstmt.execute();
			int result = cstmt.getInt(1);
			switch (result) {
			case 0:
				System.out.println("�α��μ���");
				break;
			case 1:
				System.out.println("��й�ȣ����");
				break;
			case 2:
				System.out.println("���������ʴ¾��̵�");
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
			System.out.println("���� ����");
		}
	}
}