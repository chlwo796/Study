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
</body>
<script>
	
<%request.setCharacterEncoding("UTF-8");
String uiId = request.getParameter("uiId");
String uiPw = request.getParameter("uiPwd");
String uiName = request.getParameter("uiName");
String uiNum = request.getParameter("uiNum");

Connection con = DBCon.getCon();

String sql = "UPDATE USER_INFO SET UI_ID = ?, UI_PWD = ?, UI_NAME = ? WHERE UI_NUM = ?";
PreparedStatement pstmt = con.prepareStatement(sql);
pstmt.setString(1, uiId);
pstmt.setString(2, uiPw);
pstmt.setString(3, uiName);
pstmt.setString(4, uiNum);

int rows = pstmt.executeUpdate();

if (rows == 1) {%>
	alert('유저가 정상적으로 수정되었습니다.');
	location.href = '/user_info.jsp';
<%} else {%>
	alert('유저가 정상적으로 수정되지않았습니다.');
	location.href = '/user_info.jsp';
<%}%>
	
<%pstmt.close();%>
	
</script>
</html>

