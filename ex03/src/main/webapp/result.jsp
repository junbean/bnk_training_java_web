<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String name = request.getParameter("name");
	String grade = request.getParameter("grade");
	
	

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>폼에서 받은 데이터 중 파라미터로 받은</p>
	<p>ID : <%= id %></p>
	<p>PW : <%= pw %></p>
	<p>NAME : <%= name %></p>
	<p>GRADE(중간에 새로 추가된 데이터) : <%= grade %></p>
</body>
</html>