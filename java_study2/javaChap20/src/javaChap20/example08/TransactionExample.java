package javaChap20.example08;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionExample {
	public static void main(String[] args) {
		Connection conn = null;
		try {
			// JDBC Driver를 메모리로 로딩, DriverManager 등록
			Class.forName("oracle.jdbc.OracleDriver");

			// DB와 연결

			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "java", "oracle");
			System.out.println("연결 성공");
			// 자동커밋 해제
			conn.setAutoCommit(false);
			String sql1 = "update accounts set balance=balance-? where ano=?";
			PreparedStatement pstmt1 = conn.prepareStatement(sql1);

			pstmt1.setInt(1, 10000);
			pstmt1.setString(2, "111-111-1111");
			int rows1 = pstmt1.executeUpdate();
			if (rows1 == 0) {
				throw new Exception("출금되지 않았습니다.");
			}
			pstmt1.close();

			String sql2 = "update accounts set balance=balance+? where ano=?";
			PreparedStatement pstmt2 = conn.prepareStatement(sql2);

			pstmt2.setInt(1, 10000);
			pstmt2.setString(2, "222-222-2222");
			int rows2 = pstmt2.executeUpdate();
			if (rows2 == 0) {
				throw new Exception("입금되지 않았습니다.");
			}
			pstmt2.close();

			conn.commit();
			System.out.println("계좌이체 성공");

		} catch (Exception e) {
			// 트랜잭션 처리중 예외발생 시 처리할 내용
			try {
				conn.rollback();
			} catch (SQLException e1) {
			}
			System.out.println("계좌이체 실패");
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					// 자동커밋기능 켬. 추후에 커넥션풀 사용할 때.
					conn.setAutoCommit(true);
					conn.close();
				} catch (SQLException e) {
				}
				System.out.println("연결 끊기");
			}
		}
	}
}