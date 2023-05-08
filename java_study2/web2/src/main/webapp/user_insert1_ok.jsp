<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.web.common.DBcon"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
String uiId = request.getParameter("uiId");
String uiName = request.getParameter("uiName");
String uiEmail = request.getParameter("uiEmail");
String uiAddress = request.getParameter("uiAddress");
String uiPwd = request.getParameter("uiPwd");
String uiBirth = request.getParameter("uiBirth");
String uiTrans = request.getParameter("uiTrans");

System.out.println();
Connection con = DBcon.getCon();
String sql = "INSERT INTO USER_INFO2 (UI_ID, UI_NAME, UI_EMAIL, UI_ADDRESS, UI_PWD, UI_BIRTH, UI_TRANS) VALUES (?, ?, ?, ?, ?, ?, ?)";
PreparedStatement pstmt = con.prepareStatement(sql);
pstmt.setString(1, uiId);
pstmt.setString(2, uiName);
pstmt.setString(3, uiEmail);
pstmt.setString(4, uiAddress);
pstmt.setString(5, uiPwd);
pstmt.setString(6, uiBirth);
pstmt.setString(7, uiTrans);

pstmt.executeUpdate();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입완료페이지</title>
</head>
<body>
	<h2>회원가입 완료페이지</h2>
	<button type="button" onclick="location.href = 'user_info1.jsp'">메인으로
		이동</button>
	<h2>
		이름 :
		<%=uiName%></h2>
</body>
</html>