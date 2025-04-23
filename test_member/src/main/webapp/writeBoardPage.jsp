<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>게시글 작성 페이지</h1>
	<hr>
	<form action="writeBoard" method="get">
		제목 : <input type="text" name="title" required><br>
		내용 : <textarea id="content" name="content" required></textarea><br>
		<input type="submit" value="게시글 등록하기">
	</form>
</body>
</html>