package javaChap20.example08;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionExample {
	public static void main(String[] args) {
		Connection conn = null;
		try {
			// JDBC Driver�� �޸𸮷� �ε�, DriverManager ���
			Class.forName("oracle.jdbc.OracleDriver");

			// DB�� ����

			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "java", "oracle");
			System.out.println("���� ����");
			// �ڵ�Ŀ�� ����
			conn.setAutoCommit(false);
			String sql1 = "update accounts set balance=balance-? where ano=?";
			PreparedStatement pstmt1 = conn.prepareStatement(sql1);

			pstmt1.setInt(1, 10000);
			pstmt1.setString(2, "111-111-1111");
			int rows1 = pstmt1.executeUpdate();
			if (rows1 == 0) {
				throw new Exception("��ݵ��� �ʾҽ��ϴ�.");
			}
			pstmt1.close();

			String sql2 = "update accounts set balance=balance+? where ano=?";
			PreparedStatement pstmt2 = conn.prepareStatement(sql2);

			pstmt2.setInt(1, 10000);
			pstmt2.setString(2, "222-222-2222");
			int rows2 = pstmt2.executeUpdate();
			if (rows2 == 0) {
				throw new Exception("�Աݵ��� �ʾҽ��ϴ�.");
			}
			pstmt2.close();

			conn.commit();
			System.out.println("������ü ����");

		} catch (Exception e) {
			// Ʈ����� ó���� ���ܹ߻� �� ó���� ����
			try {
				conn.rollback();
			} catch (SQLException e1) {
			}
			System.out.println("������ü ����");
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					// �ڵ�Ŀ�Ա�� ��. ���Ŀ� Ŀ�ؼ�Ǯ ����� ��.
					conn.setAutoCommit(true);
					conn.close();
				} catch (SQLException e) {
				}
				System.out.println("���� ����");
			}
		}
	}
}