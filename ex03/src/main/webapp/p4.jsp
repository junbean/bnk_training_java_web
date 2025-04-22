<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>P4 page</h1>
	<hr>
	<%
		String fruit = (String) request.getAttribute("fruit");
		String subject = (String) request.getAttribute("subject");
		String animal= (String) request.getAttribute("animal");
		String[] movies = (String[]) request.getAttribute("movies");
	%>
	내가 가장 좋아하는 과일은 <%= fruit %> 입니다<br>
	내가 가장 좋아하는 과목은 <%= subject %> 입니다<br>
	내가 가장 좋아하는 동물은 <%= animal %> 입니다<br>
	내가 가장 좋아하는 영화는
	<ul>
	<%
		for(int i=0; i<movies.length; i++) {
	%>
		<li><%= movies[i] %></li>
	<%
		}
	%>
	</ul>
	입니다.
</body>
</html>