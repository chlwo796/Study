<%@page import="java.util.Date"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.web.common.DBCon"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
Connection con = DBCon.getCon();

Statement stmt = con.createStatement();
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table id="gameTable">
		<tr>
			<th>번호</th>
			<th>게임이름</th>
			<th>게임회사</th>
			<th>게임가격</th>
			<th>출시일</th>
			<th>다운로드회수</th>
			<th>DM이름</th>
			<th>유저수</th>
			<th>수출여부</th>
		</tr>
		<%
		String sql = "SELECT GI_NUM, GI_NAME, GI_COMPANY, GI_PRICE, GI_RELEASEDATE, GI_DOWNLOADCNT, GI_DMNAME, GI_USERCNT, GI_EXPORTCHK FROM GAME_INFO;";
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {

			int gi_num = rs.getInt("GI_NUM");
			String gi_name = rs.getString("GI_NAME");
			String gi_company = rs.getString("GI_COMPANY");
			int gi_price = rs.getInt("GI_PRICE");
			Date gi_releaseDate = rs.getDate("GI_RELEASEDATE");
			int gi_downloadCnt = rs.getInt("GI_DOWNLOADCNT");
			String gi_dmName = rs.getString("GI_DMNAME");
			int gi_userCnt = rs.getInt("GI_USERCNT");
			boolean gi_exportChk = rs.getBoolean("GI_EXPORTCHK");
			String exportChkStr = null;

			if (gi_exportChk) {
				exportChkStr = "해외수출";
			} else {
				exportChkStr = "내수용";
			}
			out.println("<tr>");
			out.println("<td>" + gi_num + "</td>");
			out.println("<td>" + gi_name + "</td>");
			out.println("<td>" + gi_company + "</td>");
			out.println("<td>" + gi_price + "</td>");
			out.println("<td>" + gi_releaseDate + "</td>");
			out.println("<td>" + gi_downloadCnt + "</td>");
			out.println("<td>" + gi_dmName + "</td>");
			out.println("<td>" + gi_userCnt + "</td>");
			out.println("<td>" + exportChkStr + "</td>");
			out.println("</tr>");
		}
		%>
	</table>
</body>

</html>