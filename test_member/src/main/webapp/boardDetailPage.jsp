<%@page import="test_java.VO.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Board curBoard = (Board) request.getAttribute("curr_board");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>게시글 상세 페이지입니다</h1>
	<hr>
	<ul>
		<li>번호 : <%= curBoard.getBno() %> </li>
		<li>제목 : <%= curBoard.getTitle() %> </li>
		<li>날짜 : <%= curBoard.getContent() %> </li>
		<li>작성자 : <%= curBoard.getWriter() %> </li>
		<li>작성일자 : <%= curBoard.getRegdate() %> </li>
	</ul>
</body>
</html>