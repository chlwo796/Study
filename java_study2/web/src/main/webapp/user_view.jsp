<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
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
	<%
	String uiNum = request.getParameter("ui_Num");
	Connection con = DBCon.getCon();
	String sql = "SELECT UI_NUM, UI_NAME, UI_ID, UI_PWD, UI_DATE FROM USER_INFO WHERE UI_NUM=?";
	PreparedStatement pstmt = con.prepareStatement(sql);
	pstmt.setString(1, uiNum); // 실제 db에서 데이터타입은 int, String -> int로 자동처리
	ResultSet rs = pstmt.executeQuery();
	if (rs.next()) {
		out.println("번호 : " + rs.getInt("UI_NUM") + "<br>");
		out.println("이름 : " + rs.getString("UI_NAME") + "<br>");
		out.println("아이디 : " + rs.getString("UI_ID") + "<br>");
		out.println("비밀번호 : " + rs.getString("UI_PWD") + "<br>");
		out.println("등록일 : " + rs.getDate("UI_DATE") + "<br>");
	}
	%>

	<button
		onclick="location.href='/user_update.jsp?uiNum=<%=rs.getInt("UI_NUM")%>'">수정
	</button>
	<button onclick="location.href='/user_delete.jsp?uiNum=<%=rs.getInt("UI_NUM")%>'">삭제</button>
</body>
</html>