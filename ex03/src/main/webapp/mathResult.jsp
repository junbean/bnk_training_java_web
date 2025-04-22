<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>연산 결과 페이지</h1>
	<hr>
	<p>연산 기호 : <%= request.getParameter("operator") %> </p> 
	<p>결과는 <%= request.getAttribute("result") %> 입니다</p>
</body>
</html>