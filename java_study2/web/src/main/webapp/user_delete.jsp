<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.web.common.DBCon"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="/user_info.jsp">메인으로이동</a>
</body>
<script>
	
<%request.setCharacterEncoding("UTF-8");
String uiNum = request.getParameter("uiNum");

Connection con = DBCon.getCon();

String sql = "DELETE FROM USER_INFO WHERE UI_NUM = ?";
PreparedStatement pstmt = con.prepareStatement(sql);

pstmt.setString(1, uiNum);

int rows = pstmt.executeUpdate();

if (rows == 1) {%>
	alert('유저가 정상적으로 삭제되었습니다.');
	location.href = '/user_info.jsp';
<%} else {%>
	alert('유저가 정상적으로 삭제되지않았습니다.');
	location.href = '/user_info.jsp';
<%}%>
	
<%pstmt.close();%>
	
</script>
</html>