<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 스크릿 플립
	// 태그 안에서 코드를 작성할 수 있다
	// 어디에 쓰던 상관없다
	String s = "hello, jsp";
%>
<%
	// http://localhost:8080/test/req1.jsp?username=ab&age=13
	// request는 참조변수, getParameter는 참조변수의 함수
	// getParameter()는 파라미터의 이름을 사용하여 파라미터 값을 가져온다
	String param1 = request.getParameter("username");
	String param2 = request.getParameter("age");
	
	String[] hobbies = request.getParameterValues("hobbies");
	System.out.println(Arrays.toString(hobbies));
	
	String param3_1 = hobbies[0];
	String param3_2 = hobbies[1];
	
	String param4 = request.getParameter("colors");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	body {
		background-color : <%= param4 %>;
	}
</style>
</head>
<body>
	<h1>REQ1 Page</h1>
	<hr>
	<!-- 스크릿 플립 안에서 선언된 변수를 사용할 수 있다 -->
	<%= s %>
	<hr>
	username = <%= param1 %><br>
	age = <%= param2 %><br>
	hobby1 = <%= param3_1 %><br>
	hobby2 = <%= param3_2 %><br>
</body>
</html>