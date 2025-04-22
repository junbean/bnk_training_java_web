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
	<!-- get 요청을 보내는 경로 : http://localhost:8080/test/req1.jsp?username=&age= -->
	<!-- 쿼리 스트링 : req1.jsp?username=&age= -->
	<!-- 파라미터 :  username, age -->
	
	<!-- 색상 포함 쿼리 스트링 : ?username=aaa&age=13&hobbies=독서&hobbies=코딩&colors=red -->
	<form action="req1.jsp" method="GET">
		username : <input type="text" name="username"><br>
		age : <input type="text" name="age"><br>
		
		hobby : 
		<input type="checkbox" name="hobbies" value="독서">독서
		<input type="checkbox" name="hobbies" value="코딩">코딩
		<br>
		
		<select name="colors" >
		  <option value="red">red</option>
		  <option value="blue">blue</option>
		</select>
		<br>
		
		<input type="submit" value="전송">
	</form>
	<hr>
	<a href="emplist.jsp">사원 목록 보기</a>
	<a href="a.jsp">a page로 가기</a>
</body>
</html>