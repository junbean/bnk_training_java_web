<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	System.out.println("결과 : " + request.getAttribute("result"));
	int result = (int)request.getAttribute("result");

	System.out.println(request.getAttribute("user"));
	System.out.println(request.getAttribute("computer"));
	String user = (String)request.getAttribute("user");
	String computer = (String)request.getAttribute("computer");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>가위바위보 결과 페이지</h1>
	<hr>
	<p>사용자 : <%= user %></p>
	<p>컴퓨터 : <%= computer %></p>
	<%
		if(result == 1) {
	%>
			<p>당신이 이겼습니다!!</p>
	<%
		} else if(result == 0) {
	%>
			<p>당신이 졌습니다..</p>
	<%
		} else if(result == -1) {
	%>
			<p>비겼습니다.</p>
	<%
		} 
	%>
	
	<br>
	<a href="rsp.jsp">처음으로...</a>
</body>
</html>