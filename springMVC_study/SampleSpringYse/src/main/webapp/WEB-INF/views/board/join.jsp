<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
</head>
<body>
	<h1>게시판</h1>
	<form method="post">
		<p>
			글쓴이 : <input type="text" name="writer" />
		</p>
		<p>
			제목 : <input type="text" name="title" />
		</p>
		<p>
			내용 : <input type="text" name="content" />
		</p>
		<p>
			<input type="submit" value="저장" />
	</form>
</body>
</html>