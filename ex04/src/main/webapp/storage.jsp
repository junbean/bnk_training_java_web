<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 페이지는 해당 페이지에서만 사용할수 있다, 다른 페이지 사용 X
	pageContext.setAttribute("x", "page_X");

	// 이것도 한 페이지만 가능하긴 한데, request는 다른 페이지로 복사가 된다
	request.setAttribute("x", "requset_X");
	
	// 페이지에 국한된 저장소가 아니라 브라우저(사용자)에 귀속된다, 개인화된 저장소 
	// session은 기억하는 저장소, 프로토콜 자체는 비연결성인데, session은 데이터를 저장
	session.setAttribute("x", "session_X");
	
	// 해당 프로젝트(서비스)를 사용하는 모든 사용자가 공유할수 있는 저장소, 가장 넓은 범위의 저장소
	application.setAttribute("x", "application_X");
	
	/*
		jsp의 내장 객체
		page, request, session, application들이 그렇다
	*/
	
	String s = "hello";
	pageContext.setAttribute("ss", s);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	page 저장소 값 : <%= pageContext.getAttribute("x") %><br>
	request 저장소 값 : <%= request.getAttribute("x") %><br>
	session 저장소 값 : <%= session.getAttribute("x") %><br>
	application 저장소 값 : <%= application.getAttribute("x") %>	
	<hr>
	
	<!-- ${x} : 저장소 영역에 더 가까운 값을 가져온다 -->
	<!-- 값이 존재하는대로 page, request, session, application 순서대로 우선순위가 존재한다 -->
	<!-- 이걸 ELP라고 부른다 - 이걸 호출하는 순간은 4대 저장소에서 데이터를 가져올때 이다 -->
	page 저장소 값 : ${x }<br>
	request 저장소 값 : ${x }<br>
	session 저장소 값 : ${x }<br>
	application 저장소 값 : ${x }
	
	<hr>
	s(EL) : ${ss}<br>
	s(표현식) : <%= s %><br>
	
	<hr>
	파라미터 y : ${param.y}<br>
	
</body>
</html>