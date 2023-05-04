<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- id속성은 js에서 컨트롤하기 위해 사용 --%>
	<%-- name 속성이 없다면 key,value값을 가지지 않고 action경로로 이동 --%>
	<form action="/user_insert_ok.jsp" method="POST" name="login">
		<input type="text" id="uiId" name="uiId"
			onKeyDown="if(event.keyCode == 13) loginChk()"
			placeholder="아이디를 입력해주세요."><br> <input type="password"
			id="uiPw" name="uiPw" onKeyDown="if(event.keyCode == 13) loginChk()"
			placeholder="비밀번호를 입력해주세요."><br> <input type="text"
			id="uiName" name="uiName"
			onKeyDown="if(event.keyCode == 13) loginChk()"
			placeholder="이름을 입력해주세요."><br>
		<button type="button" onclick="loginChk()">유저등록</button>
	</form>
</body>

<script>
	function loginChk() {
		let form = document.login;
		if (!form.uiId.value) {
			alert("아이디를 입력해주세요.");
			form.uiId.focus();
			return;
		}
		if (!form.uiPw.value) {
			alert("비밀번호를 입력해주세요.");
			form.uiPw.focus();
			return;
		}
		if (!form.uiName.value) {
			alert("이름을 입력해주세요.");
			form.uiName.focus();
			return;
		}
		form.action = "/user_insert_ok.jsp";
		form.submit();
	}
</script>
</html>