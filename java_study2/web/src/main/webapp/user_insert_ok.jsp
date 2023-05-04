<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.web.common.DBCon"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
String uiId = request.getParameter("uiId");
String uiPw = request.getParameter("uiPw");
String uiName = request.getParameter("uiName");

Connection con = DBCon.getCon();

String sql = "INSERT INTO USER_INFO (UI_ID, UI_PWD, UI_NAME) VALUES (?, ?, ?)";
PreparedStatement pstmt = con.prepareStatement(sql);
pstmt.setString(1, uiId);
pstmt.setString(2, uiPw);
pstmt.setString(3, uiName);

int rows = pstmt.executeUpdate();

if (rows == 1) {
	out.println("<p>");
	out.println("저장성공");
	out.println("</p>");
}
pstmt.close();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href = "/user_info.jsp">메인으로이동</a>
</body>
</html>