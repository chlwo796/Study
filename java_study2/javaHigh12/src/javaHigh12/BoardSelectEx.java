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
			System.out.println("연결 성공");

			String sql = "select bno, btitle, bcontent, bwriter, bdate, bfilename, bfiledata from boards";
			PreparedStatement pstmt = conn.prepareStatement(sql); // 연결된 곳으로 sql문장넣는다.
			ResultSet rs = pstmt.executeQuery(); // sql문 실행 후, ResultSet을 통해 데이터 읽기

			while (rs.next()) { // ResultSet의 데이터 행이 1개 존재한다면 true
				Board board = new Board();
				board.setBno(rs.getInt("bno")); // 컬럼 이름을 이용하거나
				board.setBtitle(rs.getString("btitle")); // 컬럼 순번을 이용할 수 있다.
				board.setBcontent(rs.getString("bcontent"));
				board.setBwriter(rs.getString("bwriter"));
				board.setBdate(rs.getDate("bdate"));
				board.setBfilename(rs.getString("bfilename"));
				board.setBfiledata(rs.getBlob("bfiledata"));

				System.out.println(board); // 객체 데이터출력

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
			rs.close(); // ResultSet 닫기

			pstmt.close(); // pPreparedStatement 닫기
		} catch (Exception e) {
			e.printStackTrace();
		} // jdbc driver 등록
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