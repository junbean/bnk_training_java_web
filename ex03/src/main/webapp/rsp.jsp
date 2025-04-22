<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>컴퓨터와 가위바위보 게임</h1>
	<hr>
	<p></p>
	<form action="rsp" method="get">
		<input type="radio" name="rsp" value="1">가위
		<input type="radio" name="rsp" value="2">바위
		<input type="radio" name="rsp" value="3">보
		<br>
		
		<input type="submit" value="이걸로 결정">
	</form>
</body>
</html>