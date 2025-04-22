<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Index Page</h1>
	<hr>
	<ul>
		<li><a href="regist_form.jsp">게시글 등록</a></li>
		<li><a href="board_list.jsp">게시글 목록보기</a></li>
		<li><a href="test">test</a></li>
		<li><a href="test4">test4</a></li>
	</ul>
	<hr>
	
	<!--  -->
	<!-- 서블릿에서 뷰를  선택하는 방식 --> 
	<h1>GET 방식</h1>
	<hr>
	<form action="test1" method="GET">
		<input type="text" name="name" value="aaa"> <input
			type="submit" value="전송">
	</form>

	<h1>POST 방식</h1>
	<hr>
	<form action="test2" method="POST">
		<input type="text" name="name" value="aaa"> <input
			type="submit" value="전송">
	</form>
</body>
</html>