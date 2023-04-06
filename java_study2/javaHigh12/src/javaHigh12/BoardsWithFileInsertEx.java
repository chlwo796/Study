package javaHigh12;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BoardsWithFileInsertEx {

	public static void main(String[] args) {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "system", "1234");
			System.out.println("���� ����");

			String sql = "insert into boards (bno, btitle, bcontent, bwriter) values (?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);	// ����� ������ sql����ִ´�.
			pstmt.setInt(1, 1001);
			pstmt.setString(2, "�ȳ��ϼ���.");
			pstmt.setString(3, "�ݰ����ϴ�.");
			pstmt.setString(4, "����ȯ");

			int rows = pstmt.executeUpdate();	// �����ͺ��̽��� insert���� ����
			System.out.println("����� �� �� : " + rows);
			
			pstmt.close();
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