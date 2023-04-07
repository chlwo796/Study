package javaHigh12;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BoardSelectEx {

	public static void main(String[] args) {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "system", "1234");
			System.out.println("���� ����");

			String sql = "select bno, btitle, bcontent, bwriter, bdate, bfilename, bfiledata from boards";
			PreparedStatement pstmt = conn.prepareStatement(sql); // ����� ������ sql����ִ´�.
			ResultSet rs = pstmt.executeQuery(); // sql�� ���� ��, ResultSet�� ���� ������ �б�

			while (rs.next()) { // ResultSet�� ������ ���� 1�� �����Ѵٸ� true
				Board board = new Board();
				board.setBno(rs.getInt("bno")); // �÷� �̸��� �̿��ϰų�
				board.setBtitle(rs.getString("btitle")); // �÷� ������ �̿��� �� �ִ�.
				board.setBcontent(rs.getString("bcontent"));
				board.setBwriter(rs.getString("bwriter"));
				board.setBdate(rs.getDate("bdate"));
				board.setBfilename(rs.getString("bfilename"));
				board.setBfiledata(rs.getBlob("bfiledata"));

				System.out.println(board); // ��ü ���������

				Blob blob = board.getBfiledata();

				if (blob != null) {
					InputStream is = blob.getBinaryStream();
					OutputStream os = new FileOutputStream("c:/JHC/" + board.getBfilename());
					is.transferTo(os);
					os.flush();
					os.close();
					is.close();
				}
			}
			rs.close(); // ResultSet �ݱ�

			pstmt.close(); // pPreparedStatement �ݱ�
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