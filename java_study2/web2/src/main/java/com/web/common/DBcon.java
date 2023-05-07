package com.web.common;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBcon {

	public static Connection getCon() {

		Connection con = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			String url = "jdbc:mysql://localhost/nothing";
			String id = "root";
			String pw = "1234";

			con = DriverManager.getConnection(url, id, pw);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
}