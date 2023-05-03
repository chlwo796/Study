<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 지시자 : 해당 페이지에 대한 설명서 -->
<%
String str = "1";
out.println(str);
%>
<!-- 표현식 -->
<%=str%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	안녕하숑~
	<%

%>

	<table border="1">
		<%
		for (int i = 2; i <= 9; i++) {
			out.print("<th>" + i + "단" + "</th>");
			for (int j = 1; j <= 9; j++) {
				out.print("<tr>");
				out.print("<td>" + i + " * " + j + " = " + (i * j) + "</td>");
				out.print("</tr>");
			}
		}
		%>
	</table>

	<table border="1">
		<tr>
			<%
			for (int i = 1; i <= 9; i++) {
			%>
			<th><%=i%>단</th>
			<%
			}
			%>
		</tr>
		<%
			for (int i = 1; i <= 9; i++) {
				out.print("<tr>");
				for (int j = 1; j <= 9; j++) {
					out.print("<td>" + j + " * " + i + " = " + (i * j) + "</td>");

				}
				out.print("</tr>");
			}
			%>

	</table>
</body>
</html>