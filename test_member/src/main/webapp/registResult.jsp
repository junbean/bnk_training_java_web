<%@page import="test_java.VO.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// Member member = (Member)session.getAttribute("member");
	// System.out.println(member);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원 가입 결과 페이지</h1>
	<hr>
	<p>회원 가입 되었습니다!!</p>
	<ul>
		<li>아이디 :  ${ member.getId() } </li>
		<li>패스워드 : ${ member.getPw() } </li>
		<li>이름 : ${ member.getName() } </li>
		<li>등급 : ${ member.getGrade() } </li>
	</ul>
	<p><a href="index.jsp" >처음으로 돌아가기</a></p>
</body>
</html>
