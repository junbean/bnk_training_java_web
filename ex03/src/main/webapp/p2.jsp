<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>P2 page</h1>
	<hr>
	<%
	// jsp로 파라미터를 화면에 전달하는 방식
	// 이렇게 request.getParameter()로 받아오는건 전부 문자열(String)이다
	// String name = request.getParameter("name");
	// String age = request.getParameter("age");
	
	// jsp방식으로 servlet을 통해 데이터를 전달하는 방식
	String name = (String)request.getAttribute("name");
	String age = (String)request.getAttribute("age");
	
	%>
	name 파라미터 값 : <%= name %><br>
	age 파라미터 값 : <%= age %><br>
</body>
</html>