<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.web.common.DBcon"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>신규등록</title>
</head>
<body>
	<h2>회원등록</h2>
	<form action="/user_insert1_ok.jsp" method="POST">
		<table border="1">


			<tr>
				<td>아이디</td>
				<td><input type="text" id="uiId" name="uiId"
					placeholder="아이디를 입력해주세요"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" id="uiName" name="uiName"
					placeholder="이름을 입력해주세요"></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type="text" id="uiEmail" name="uiEmail"
					placeholder="이메일을 입력해주세요"></td>
			</tr>
			<tr>
				<td>주소</td>
				<td><input type="text" id="uiAddress" name="uiAddress"
					placeholder="주소를 입력해주세요"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" id="uiPwd" name="uiPwd"
					placeholder="비밀번호를 입력해주세요"></td>
			</tr>
			<tr>
				<td>생일</td>
				<td><input type="text" id="uiBirth" name="uiBirth" placeholder = "생년월일 8자리"></td>
			</tr>
			<tr>
				<td>성별</td>
				<td><input type="radio" id="uiTrans" name="uiTrans" value = "1">남 <input
					type="radio" id="uiTrans" name="uiTrans" value = "2">여</td>
			</tr>

		</table>
		<button type="submit">등록</button>
		<button type="button" onclick="location.href = 'user_info1.jsp'">이전</button>
	</form>
</body>
</html>