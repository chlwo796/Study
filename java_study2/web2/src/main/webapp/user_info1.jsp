<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.web.common.DBcon"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
Connection con = DBcon.getCon();
String sql = "SELECT UI_NUM, UI_ID, UI_NAME, UI_EMAIL, UI_ADDRESS, UI_PWD, UI_BIRTH, UI_TRANS, CREDAT, CRETIM, OUTDAT, ACTIVE, UI_LVL, UI_DUTIES FROM USER_INFO2";
PreparedStatement pstmt = con.prepareStatement(sql);
ResultSet rs = pstmt.executeQuery();
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p align="center" style = "font-weight: bolder;">JH컴퍼니 고용현황</p>
	<table border="1">
		<tr bgcolor="orange">
			<th>번호</th>
			<th>아이디</th>
			<th>이름</th>
			<th>이메일</th>
			<th>주소</th>
			<th>비밀번호</th>
			<th>생일</th>
			<th>성별</th>
			<th>가입날짜</th>
			<th>가입시간</th>
			<th>활성화</th>
			<th>레벨</th>
			<th>부서</th>
		</tr>
		<%
		while (rs.next()) {
			String uiNum = rs.getString("UI_NUM");
			String uiId = rs.getString("UI_ID");
			String uiName = rs.getString("UI_NAME");
			String uiEmail = rs.getString("UI_EMAIL");
			String uiAddress = rs.getString("UI_ADDRESS");
			String uiPwd = rs.getString("UI_PWD");
			String uiBirth = rs.getString("UI_BIRTH");
			String uiTrans = rs.getString("UI_TRANS");
			String credat = rs.getString("CREDAT");
			String cretim = rs.getString("CRETIM");
			String active = rs.getString("ACTIVE");
			String uiLvl = rs.getString("UI_LVL");
			String uiDuties = rs.getString("UI_DUTIES");
			out.println("<tr>");
			out.println("<td>" + uiNum + "</td>");
			out.println("<td>" + uiId + "</td>");
			out.println("<td>" + uiName + "</td>");
			out.println("<td>" + uiEmail + "</td>");
			out.println("<td>" + uiAddress + "</td>");
			out.println("<td>" + uiPwd + "</td>");
			out.println("<td>" + uiBirth + "</td>");
			out.println("<td>" + uiTrans + "</td>");
			out.println("<td>" + credat + "</td>");
			out.println("<td>" + cretim + "</td>");
			out.println("<td>" + active + "</td>");
			out.println("<td>" + uiLvl + "</td>");
			out.println("<td>" + uiDuties + "</td>");
			out.println("</tr>");
		}
		pstmt.close();
		%>
	</table>
	<br>
	<button type="button" onclick="location.href = '/user_insert1.jsp'">신규등록</button>
</body>
</html>
