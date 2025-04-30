<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		body {
			font-family : Arial, sans-serif;
			margin : 20px;
		}
		.result-container {
			max-width : 500px;
			margin : 0 auto;
			padding : 20px;
			border : 1px solid #ddd;
			border-radius : 5px;
		}
		.success {
			color : green;
		}
		.error {
			color: red;
		}
		.back-Link {
			margin-top : 20px;
		}
	</style>
</head>
<body>
	<div class="result-container">
		<h2>이체 결과</h2>
		
		<% if(request.getAttribute("message") != null) { %>
			<p class="success"><%= request.getAttribute("message") %></p>	
		<% } %>
		
		<% if(request.getAttribute("errorMessage") != null) { %>
			<p class="error"><%= request.getAttribute("errorMessage") %></p>	
		<% } %>
		
		<div class="back-Link">
			<a href="transfer_form.jsp">다시 이체하기</a>
		</div>
	</div>
</body>
</html>