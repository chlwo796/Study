<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
List<Map<String, String>> list = new ArrayList<>();

for (int i = 1; i <= 10; i++) {
	Map<String, String> board = new HashMap<>();
	board.put("bi_num", "" + i);
	board.put("bi_title", "게시글" + i);
	board.put("bi_writer", "글쓴이" + i);
	list.add(board);
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	for (Map<String, String> map : list) {
		out.println(map.get("bi_num"));
		out.println(map.get("bi_title"));
		out.println(map.get("bi_writer"));
		out.println("<br>");
	}
	%>
</body>
</html>