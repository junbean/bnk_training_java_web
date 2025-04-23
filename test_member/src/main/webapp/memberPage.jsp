<%@page import="test_java.VO.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Member member = (Member) session.getAttribute("member");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원 전용 페이지</h1>
	<hr>
	<p>회원 전용 페이지 입니다.</p>
	<p>접속한 회원의 정보</p>
	<ul>
		<li>아이디 : <%= member.getId() %></li>
		<li>이름 : <%= member.getName() %></li>
	</ul>
</body>
</html>