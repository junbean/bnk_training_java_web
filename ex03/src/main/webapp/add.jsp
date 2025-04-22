<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>사칙연산 페이지</h1>
	<hr>
	<form action="addResult" method="get">
		<input type="number" name="num1" value=1 >
		<select name="operator">
			<option value="add">+</option>
			<option value="sub">-</option>
			<option value="mul">*</option>
			<option value="div">/</option>
		</select>
		<input type="number" name="num2" value=1 >
		<br>
		
		<input type="submit" value="결과 보기">	
	</form>
</body>
</html>