package javaChap20.example02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BoardWithFileInsertExample {
	public static void main(String[] args) {
		Connection conn = null;
		try {
			// JDBC Driver�� �޸𸮷� �ε�, DriverManager ���
			Class.forName("oracle.jdbc.OracleDriver");

			// DB�� ����

			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "java", "oracle");
			System.out.println("���� ����");

			// DB�۾�
			String sql = "insert into boards (bno, btitle, bcontent, bwriter, bdate, bfilename, bfiledata) values (seq_bno.nextval, ?, ?, ?, sysdate, ?, ?)";
			PreparedStatement pstmt = conn.prepareStatement(sql, new String[] { "bno", "btitle" });

			pstmt.setString(1, "�ҳ���");
			pstmt.setString(2, "��");
			pstmt.setString(3, "falling");
			pstmt.setString(4, "8.jpg");

//			pstmt.setBlob(5, null);	// �����Ͽ���, setBlob()�޼ҵ��� �����ε��� ����. InputStream Ÿ������, BlobŸ������ ������־���Ѵ�.
//			Blob blob = null;	// �̸� �ذ��ϱ� ���� BlobŸ���� ���� ���� �� ����
			try {
				pstmt.setBlob(5, new FileInputStream("src/javaChap20/example02/8.jpg"));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int rows = pstmt.executeUpdate();
			System.out.println(rows);

			if (rows == 1) {
				ResultSet rs = pstmt.getGeneratedKeys();
				if (rs.next()) {
					// rs�� �����Ͱ� ������
					int bno = rs.getInt(1);
					System.out.println("����� bno : " + bno);
					String btitle = rs.getString(2);
					System.out.println("����� btitle : " + btitle);
				}
				rs.close();
			}

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