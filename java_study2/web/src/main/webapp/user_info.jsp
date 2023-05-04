<%@page import="java.sql.PreparedStatement"%>
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
String searchUiName = request.getParameter("uiName");
String searchUiId = request.getParameter("uiId");
Connection con;
Class.forName("com.mysql.cj.jdbc.Driver"); // jdbc 드라이버 연결

String url = "jdbc:mysql://localhost/nothing";
String id = "root";
String pw = "1234";

con = DriverManager.getConnection(url, id, pw);

String sql = "SELECT UI_NUM, UI_NAME, UI_ID, UI_PWD, UI_DATE FROM USER_INFO";
// 사용자가 검색시 바뀌는 쿼리문은 db에 영향받지 않아야한다.
if (searchUiName != null) {
	// 검색데이터가 있을 경우에만 sql문에 where절 추가
	// PreparedStatement 타입변경 후 바인딩과정 searchUiName -> ?
	sql += " WHERE UI_NAME LIKE CONCAT('%', ?, '%')";
	if (searchUiId != null) {
		sql += " AND UI_ID LIKE CONCAT('%', ?, '%')";
	}
} else if (searchUiId != null) {
	sql += " WHERE UI_ID LIKE CONCAT('%', ?, '%')";
}
PreparedStatement pstmt = con.prepareStatement(sql);
// 실행시에는 쿼리문이 들어가지 않는다. preparedStatement 타입
if (searchUiName != null) {
	pstmt.setString(1, searchUiName);
	if (searchUiId != null) {
		pstmt.setString(2, searchUiId);
	}
} else if (searchUiId != null) {
	pstmt.setString(1, searchUiId);
}

ResultSet rs = pstmt.executeQuery();
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
	<%-- form태그 안에 input과 button까지 모두 포함 --%>
	<form>
		<input type="text" name="uiName" placeholder="검색할 이름을 작성해주세요.">
		<input type="text" name="uiId" placeholder="검색할 아이디를 작성해주세요.">
		<button>검색</button>
	</form>
	<table id="user_info" border="1">
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>비밀번호</th>
			<th>날짜</th>
		</tr>
		<%
		while (rs.next()) {
			int ui_Num = rs.getInt("UI_NUM");
			out.println("<tr onclick=\"location.href='/user_view.jsp?ui_Num=" + ui_Num + "'\">");
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

		<tr>
			<%-- html에서 on은 이벤트발생 --%>
			<%-- 이벤트에 한해서만 on + click 소문자, 국제표준 --%>
			<%-- onclick 의 ""는 스트링 처리가 되지 않는다. 스크립트영역, js문법을 사용한다.--%>
			<th colspan="4">
				<button type="button" onclick="location.href = '/user_insert.jsp'">유저등록</button>
			</th>
		</tr>
	</table>
	<%-- 링크 / 앞에는 http:localhost가 생략되어있다. --%>
	<a href="/user_insert.jsp">유저등록</a>
	<br>
	<p></p>


</body>
<%-- 
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
--%>
</html>