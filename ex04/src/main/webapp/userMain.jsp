<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Main</title>
</head>
<body bgColor="pink">
	<h1>사용자 로그인 성공</h1>
	<%= request.getParameter("userName") %>
	(<%= request.getParameter("userId") %>)님 환영합니다.
</body>
</html>