package javaHigh12;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BoardsInsertEx {

	public static void main(String[] args) {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "system", "1234");
			System.out.println("���� ����");
			String sql = "insert into boards (bno, btitle, bcontent, bwriter, bdate, bfilename, bfiledata) values (seq_bno.nextval, ?, ?, ?, sysdate, ?, ?)";
			PreparedStatement pstmt = conn.prepareStatement(sql, new String[] {"bno"});
			pstmt.setString(1,"�̰� ����");
			pstmt.setString(2, "�̰� ���� ����");
			pstmt.setString(3, "winter");
			pstmt.setString(4, "2.jpg");
			pstmt.setBlob(5, new FileInputStream("src/javaHigh12/2.jpg"));
			
			int rows = pstmt.executeUpdate();	// �����ͺ��̽� insert�� ����
			System.out.println("����� �� �� : " + rows);
			if(rows == 1) {
				ResultSet rs = pstmt.getGeneratedKeys();	// new String[] {"bno"} �� ����� �÷���
				if(rs.next()) {
					int bno = rs.getInt(1);	// insert �� ������ �������ѹ��� ������(Ȯ�ο�)
					System.out.println("����� bno : " + bno);
				}
				rs.close();
			}
		} catch (Exception e) {
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