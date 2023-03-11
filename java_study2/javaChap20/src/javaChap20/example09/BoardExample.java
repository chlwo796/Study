package javaChap20.example09;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import javaChap20.example06.Board;

public class BoardExample {
	// Field
	private Scanner sc = new Scanner(System.in);
	private Connection conn = null;

	// Constructor
	public BoardExample() {
		try {
			// JDBC Driver ���
			Class.forName("oracle.jdbc.OracleDriver");

			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/orcl", "java", "oracle");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			exit();
		}
	}

	// Method
	public void list() {
		System.out.println();
		System.out.println("[�Խù� ���]");
		System.out.println("-----------------------------------------------------------------------");
		System.out.printf("%-6s%-12s%-16s%-40s\n", "no", "writer", "date", "title");
		System.out.println("-----------------------------------------------------------------------");
		System.out.printf("%-6s%-12s%-16s%-40s \n", "1", "winter", "2023.03.11", "�Խ��ǿ� ���� ���� ȯ���մϴ�.");
		System.out.printf("%-6s%-12s%-16s%-40s \n", "2", "winter", "2023.03.11", "�� �ܿ��� ���� ����ϴ�.");
		try {
			String sql = "select bno, btitle, bcontent, bwriter, bdate, bfilename, bfiledata from boards order by bno desc";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Board board = new Board();
				board.setBno(rs.getInt("bno"));
				board.setBtitle(rs.getString("btitle"));
				board.setBcontent(rs.getString("bcontent"));
				board.setBwriter(rs.getString("bwriter"));
				board.setBdate(rs.getDate("bdate"));
				System.out.printf("%-6s%-12s%-16s%-40s \n", board.getBno(), board.getBwriter(), board.getBdate(),
						board.getBtitle());
			}
			rs.close();
			pstmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
			exit();
		}
		mainMenu();
	}

	public void mainMenu() {
		System.out.println();
		System.out.println("-----------------------------------------------------------------------");
		System.out.println("���� �޴�: 1.Create | 2.Read | 3.Clear | 4.Exit");
		System.out.print("�޴� ����: ");
		System.out.println();
		String menuNo = sc.nextLine();

		switch (menuNo) {
		case "1":
			create();
			break;
		case "2":
			read();
			break;
		case "3":
			clear();
			break;
		case "4":
			exit();
			break;
		}
	}

	private void exit() {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
			}
		}
		System.out.println("�Խ��� ����");
		System.exit(0);
	}

	private void clear() {
		System.out.println("[�Խù� ��ü ����]");
		System.out.println("-------------------------------------------------------------------");
		System.out.println("���� �޴�: 1.Ok | 2.Cancel");
		System.out.print("�޴� ����: ");
		String menuNo = sc.nextLine();
		if (menuNo.equals("1")) {
			try {
				String sql = "truncate table boards";

				PreparedStatement pstmt = conn.prepareStatement(sql);

				pstmt.executeUpdate();
				pstmt.close();

			} catch (SQLException e) {
				e.printStackTrace();
				exit();
			}
		}
		list();
	}

	private void read() {
		System.out.println("[�Խù� �б�]");
		System.out.print("bno: ");
		int bno = Integer.parseInt(sc.nextLine());
		try {
			String sql = "select bno, btitle, bcontent, bwriter, bdate from boards where bno=?";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				Board board = new Board();
				board.setBno(rs.getInt("bno"));
				board.setBtitle(rs.getString("btitle"));
				board.setBcontent(rs.getString("bcontent"));
				board.setBwriter(rs.getString("bwriter"));
				board.setBdate(rs.getDate("bdate"));
				System.out.println("#############");
				System.out.println("��ȣ: " + board.getBno());
				System.out.println("����: " + board.getBtitle());
				System.out.println("����: " + board.getBcontent());
				System.out.println("�ۼ���: " + board.getBwriter());
				System.out.println("��¥: " + board.getBdate());
				// �����޴� �߰�
				System.out.println("-------------------------------------------------------------------");
				System.out.println("���� �޴�: 1.Update | 2.Delete | 3.List");
				System.out.print("�޴� ����: ");
				String menuNo = sc.nextLine();
				System.out.println();

				if (menuNo.equals("1")) {
					update(board);
				} else if (menuNo.equals("2")) {
					delete(board);
				}
			}
			rs.close();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
			exit();
		}

		// �Խù� ��� ���
		list();
	}

	private void delete(Board board) {
		try {
			String sql = "delete from boards where bno=?";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, board.getBno());
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			exit();
		}
		list();
	}

	private void update(Board board) {

		System.out.println("[���� ���� �Է�]");
		System.out.print("����: ");
		board.setBtitle(sc.nextLine());
		System.out.print("����: ");
		board.setBcontent(sc.nextLine());
		System.out.print("�ۼ���: ");
		board.setBwriter(sc.nextLine());

		// ���� �޴� ���
		System.out.println("-----------------------------------------------------------------------");
		System.out.println("���� �޴�: 1.Ok | 2.Cancel");
		System.out.print("�޴� ����: ");
		String menuNo = sc.nextLine();
		if (menuNo.equals("1")) {
			try {
				String sql = "update boards set btitle, bcontent, bwriter where bno=?";

				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, board.getBtitle());
				pstmt.setString(2, board.getBcontent());
				pstmt.setString(3, board.getBwriter());
				pstmt.setInt(4, board.getBno());
				pstmt.executeUpdate();
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				exit();
			}
		}
		list();
	}

	private void create() {
		// �Է� �ޱ�
		Board board = new Board();
		System.out.println("[�� �Խù� �Է�]");
		System.out.print("����: ");
		board.setBtitle(sc.nextLine());
		System.out.print("����: ");
		board.setBcontent(sc.nextLine());
		System.out.print("�ۼ���: ");
		board.setBwriter(sc.nextLine());

		// ���� �޴� ���
		System.out.println("-----------------------------------------------------------------------");
		System.out.println("���� �޴�: 1.Ok | 2.Cancel");
		System.out.print("�޴� ����: ");
		String menuNo = sc.nextLine();
		if (menuNo.equals("1")) {
			try {
				String sql = "insert into boards (bno, btitle, bcontent, bwriter, bdate) values (SEQ_BNO.NEXTVAL, ?, ?, ?, SYSDATE)";

				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, board.getBtitle());
				pstmt.setString(2, board.getBcontent());
				pstmt.setString(3, board.getBwriter());
				pstmt.executeUpdate();
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
				exit();
			}
		}
		list();
	}

	public static void main(String[] args) {
		BoardExample boardExample = new BoardExample();
		boardExample.list();
	}
}