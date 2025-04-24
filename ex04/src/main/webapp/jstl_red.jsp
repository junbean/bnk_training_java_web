<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	body {
		background-color : red;
	}
</style>
</head>
<body>
	<h1>Red Page</h1>
	<!-- request.getDispatacher().forward(request,response) 와 동일하다 -->
	<jsp:forward page="jstl_color.jsp">
		<jsp:param value="green" name="color" />
	</jsp:forward>
</body>
</html>