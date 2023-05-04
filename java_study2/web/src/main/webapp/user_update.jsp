<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.web.common.DBCon"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	String uiNum = request.getParameter("uiNum");
	Connection con = DBCon.getCon();
	String sql = "SELECT UI_NUM, UI_NAME, UI_ID, UI_PWD, UI_DATE FROM USER_INFO WHERE UI_NUM=?";
	PreparedStatement pstmt = con.prepareStatement(sql);
	pstmt.setString(1, uiNum); // 실제 db에서 데이터타입은 int, String -> int로 자동처리
	ResultSet rs = pstmt.executeQuery();
	if (rs.next()) {
	%>
	<form method="POST" action="/user_update_ok.jsp">
		<input type="hidden" name="uiNum" value="<%=rs.getString("UI_NUM")%>"><br>
		이름 : <input type="text" name="uiName"
			value="<%=rs.getString("UI_NAME")%>"><br> 아이디 : <input
			type="text" name="uiId" value="<%=rs.getString("UI_ID")%>"><br>
		비밀번호 : <input type="text" name="uiPwd"
			value="<%=rs.getString("UI_PWD")%>"><br>
		<button>수정완료</button>
	</form>
	<%
	}
	%>
</body>
</html>