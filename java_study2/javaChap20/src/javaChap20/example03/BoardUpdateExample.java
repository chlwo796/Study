package javaChap20.example03;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BoardUpdateExample {
	public static void main(String[] args) throws FileNotFoundException {
		Connection conn = null;
		try {
			// JDBC Driver�� �޸𸮷� �ε�, DriverManager ���
			Class.forName("oracle.jdbc.OracleDriver");

			// DB�� ����

			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "java", "oracle");
			System.out.println("���� ����");

			// DB�۾�
			String sql = new StringBuilder()
					// �� �� ������ " "������ �־��ִ� ���� ����(�Ǽ�����)
					.append("update boards set ")
					//.append("btitle=?, ")
					//.append("bcontent=?, ")
					.append("bfilename=?, ")
					.append("bfiledata=? ")
					.append("where bno=?").toString();
			PreparedStatement pstmt = conn.prepareStatement(sql, new String[] { "bno", "btitle" });

//			pstmt.setString(1, "�ҳ��Ⱑ");
//			pstmt.setString(2, "�ҳ��Ⱑ ��û������");
			pstmt.setString(1, "rain");
			pstmt.setBlob(2, new FileInputStream("src/javaChap20/example03/3.jpg"));
			pstmt.setInt(3, 1);

			int rows = pstmt.executeUpdate();
			System.out.println("������ �� �� : " + rows);

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
			System.out.println("���� ����");
		}
	}
}