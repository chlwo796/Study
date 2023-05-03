package com.web.common;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBCon {

	public static Connection getCon() {
		Connection con = null; // 커넥션 준비
		try {
			// 예외처리는 자바에서는 해줘야한다.
			Class.forName("com.mysql.cj.jdbc.Driver");

			String url = "jdbc:mysql://localhost/nothing"; // 전화번호
			String id = "root"; // 아이디
			String pw = "1234"; // 비밀번호

			con = DriverManager.getConnection(url, id, pw);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
}