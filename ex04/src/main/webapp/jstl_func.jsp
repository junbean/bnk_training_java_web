<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="jstl_header.jsp" %>
	<hr>
	<h2>본페이지 - ${x}</h2>
	<input type="button" onclick="f()" value="클릭" />
	<script>
		function f() {
			alert("버튼이 클릭됨");
			location.href="test";
		}
	</script>
</body>
</html>