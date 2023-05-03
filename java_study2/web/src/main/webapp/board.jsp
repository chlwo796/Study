<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
Connection con; // 커넥션 준비
Class.forName("com.mysql.cj.jdbc.Driver"); // 유심장착

String url = "jdbc:mysql://localhost/nothing"; // 전화번호
String id = "root"; // 아이디
String pw = "1234"; // 비밀번호

con = DriverManager.getConnection(url, id, pw);

Statement stmt = con.createStatement();

ResultSet rs = stmt.executeQuery("SELECT BI_NUM, BI_TITLE, BI_CONTENT, BI_WRITER, BI_CNT, BI_DATE FROM BOARD_INFO;");
// 커서포인터는 기본적으로 기본행 하나 아래에 존재한다.(데이터존재x)
int biNum = 0;
String biTitle = null;
String biWriter = null;
int biCnt = 0;
while (rs.next()) {
	biNum = rs.getInt("BI_NUM");
	biTitle = rs.getString("BI_TITLE");
	biWriter = rs.getString("BI_WRITER");
	biCnt = rs.getInt("BI_CNT");
}
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1" id='testTable'>
		<tr class="title">
			<th id="number">번호</th>
			<th>제목</th>
			<th>내용</th>
			<th>조회수</th>
		</tr>
		<%
		rs = stmt.executeQuery("SELECT BI_NUM, BI_TITLE, BI_CONTENT, BI_WRITER, BI_CNT, BI_DATE FROM BOARD_INFO;");
		while (rs.next()) {
			biNum = rs.getInt("BI_NUM");
			biTitle = rs.getString("BI_TITLE");
			biWriter = rs.getString("BI_WRITER");
			biCnt = rs.getInt("BI_CNT");
			out.println("<tr>");
			out.println("<td>" + biNum + "</td>");
			out.println("<td>" + biTitle + "</td>");
			out.println("<td>" + biWriter + "</td>");
			out.println("<td>" + biCnt + "</td>");
			out.println("</tr>");
		}
		%>

	</table>
</body>

<script type="text/javascript">
	const number = document.getElementById('number');
	number.addEventListener('click', function() {
		confirm(number.innerText + "클릭하셨습니다.");
	});
</script>
</html>