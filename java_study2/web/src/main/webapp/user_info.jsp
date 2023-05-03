<%@page import="java.util.Date"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>


<%
// jsp에서는 이미 예외처리 및 기본적인 변수처리가 되어있어서 생략이 가능한 부분이 있다.
Connection con;
Class.forName("com.mysql.cj.jdbc.Driver"); // jdbc 드라이버 연결

String url = "jdbc:mysql://localhost/nothing";
String id = "root";
String pw = "1234";

con = DriverManager.getConnection(url, id, pw);

Statement stmt = con.createStatement();

ResultSet rs = stmt.executeQuery("SELECT UI_NUM, UI_NAME, UI_ID, UI_PWD, UI_DATE FROM USER_INFO;");
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table id="user_info">
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>비밀번호</th>
			<th>날짜</th>
		</tr>
		<%
		while (rs.next()) {
			out.println("<tr>");
			int ui_Num = rs.getInt("UI_NUM");
			out.println("<td>" + ui_Num + "</td>");
			String ui_Name = rs.getString("UI_NAME");
			out.println("<td>" + ui_Name + "</td>");
			String ui_Id = rs.getString("UI_ID");
			out.println("<td>" + ui_Id + "</td>");
			Date ui_Date = rs.getDate("UI_DATE");
			out.println("<td>" + ui_Date + "</td>");
			out.println("</tr>");
		}
		%>
	</table>
	<br>
	<p></p>
</body>

<script type="text/javascript">
	function tableClick() {
		const table = document.getElementById("user_info");
		const rowList = table.rows;

		for (i = 1; i < rowList.length; i++) { // int i = thead 제외
			let row = rowList[i];
			let str = "";

			row.onclick = function() {
				return function() {

					let number = this.cells[0].innerHTML;
					let name = this.cells[1].innerHTML;
					let id = this.cells[2].innerHTML;
					let date = this.cells[3].innerHTML;

					str = "번호: " + number + " 이름 : " + name + " id : " + id
							+ " date : " + date;
					document.querySelector('p').innerText = str;
				};
			}(row);

		}
	}

	window.onload = tableClick();
</script>
</html>