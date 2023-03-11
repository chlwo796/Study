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
			// JDBC Driver 등록
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
		System.out.println("[게시물 목록]");
		System.out.println("-----------------------------------------------------------------------");
		System.out.printf("%-6s%-12s%-16s%-40s\n", "no", "writer", "date", "title");
		System.out.println("-----------------------------------------------------------------------");
		System.out.printf("%-6s%-12s%-16s%-40s \n", "1", "winter", "2023.03.11", "게시판에 오신 것을 환영합니다.");
		System.out.printf("%-6s%-12s%-16s%-40s \n", "2", "winter", "2023.03.11", "올 겨울은 많이 춥습니다.");
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
		System.out.println("메인 메뉴: 1.Create | 2.Read | 3.Clear | 4.Exit");
		System.out.print("메뉴 선택: ");
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
		System.out.println("게시판 종료");
		System.exit(0);
	}

	private void clear() {
		System.out.println("[게시물 전체 삭제]");
		System.out.println("-------------------------------------------------------------------");
		System.out.println("보조 메뉴: 1.Ok | 2.Cancel");
		System.out.print("메뉴 선택: ");
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
		System.out.println("[게시물 읽기]");
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
				System.out.println("번호: " + board.getBno());
				System.out.println("제목: " + board.getBtitle());
				System.out.println("내용: " + board.getBcontent());
				System.out.println("작성자: " + board.getBwriter());
				System.out.println("날짜: " + board.getBdate());
				// 보조메뉴 추가
				System.out.println("-------------------------------------------------------------------");
				System.out.println("보조 메뉴: 1.Update | 2.Delete | 3.List");
				System.out.print("메뉴 선택: ");
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

		// 게시물 목록 출력
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

		System.out.println("[수정 내용 입력]");
		System.out.print("제목: ");
		board.setBtitle(sc.nextLine());
		System.out.print("내용: ");
		board.setBcontent(sc.nextLine());
		System.out.print("작성자: ");
		board.setBwriter(sc.nextLine());

		// 보조 메뉴 출력
		System.out.println("-----------------------------------------------------------------------");
		System.out.println("보조 메뉴: 1.Ok | 2.Cancel");
		System.out.print("메뉴 선택: ");
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
		// 입력 받기
		Board board = new Board();
		System.out.println("[새 게시물 입력]");
		System.out.print("제목: ");
		board.setBtitle(sc.nextLine());
		System.out.print("내용: ");
		board.setBcontent(sc.nextLine());
		System.out.print("작성자: ");
		board.setBwriter(sc.nextLine());

		// 보조 메뉴 출력
		System.out.println("-----------------------------------------------------------------------");
		System.out.println("보조 메뉴: 1.Ok | 2.Cancel");
		System.out.print("메뉴 선택: ");
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