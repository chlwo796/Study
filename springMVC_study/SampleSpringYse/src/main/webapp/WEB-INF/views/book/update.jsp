<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>책 수정하기</title>
</head>
<body>
	<h1>수정하기</h1>
	<form method="post">
		<p>
			제목 : <input type="text" name="title" />
		</p>
		<p>
			카테고리 : <input type="text" name="category" />
		</p>
		<p>
			가격 : <input type="text" name="price" />
		</p>
		<p>
			<input type="submit" value="수정" />
	</form>
</body>
</html>