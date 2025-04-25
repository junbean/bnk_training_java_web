<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Action Form</title>
</head>
<body>
	<form action="actionTagTest.jsp" >
		아이디 : <input type="text" name="userId"><br>
		패스워드 : <input type="password" name="userPwd"><br>
		<input type="radio" name="loginCheck" value="user" checked>사용자
		<input type="radio" name="loginCheck" value="manager" >관리자 
		<br>
		<input type="submit" value="로그인">
	</form>
</body>
</html>