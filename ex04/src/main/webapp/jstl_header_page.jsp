<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 
		include 사용하면 데이터를 공유하여 사용할수 있다 
		그리고 해당 파일에서 저장한 데이터가 적용되어 불러올수 있다
	-->
	<%@ include file="jstl_header.jsp" %>
	<hr>
	<h2>본 페이지 - ${x}</h2>
</body>
</html>