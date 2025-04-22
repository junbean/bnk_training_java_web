<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Index Page</h1>
	<hr>
	
	<h2>GET 방식1 - a 태그 활용</h2>
	<a href="p1.jsp">p1페이지로 이동</a><br>
	<a href="p1">p1페이지로 이동(Servlet 통해 이동)</a>
	<hr>

	<h2>GET 방식2 - a 태그 활용(파라미터 보내기 -> 쿼리스트링 만들기)</h2>
	<a href="p2.jsp?name=James&age=26">p2페이지로 이동(jsp로 바로 연결)</a><br>
	<a href="p2?name=James&age=26">p2페이지로 이동(Servlet 통해 이동)</a>
	<hr>
	
	<h2>GET 방식3 - form 활용(쿼리스트링 자동 생성)</h2>
	<form action="p3.jsp" method="get">
		<!-- ?fruit=apple -->
		<!-- ?fruit=apple&subject=JAVA -->
		<!-- ?fruit=apple&subject=JAVA&animal=dog -->
		<!-- ?fruit=apple&subject=JAVA&animal=cat&movies=Taxi+Driver&movies=Le+Grand+Blue&movies=The+God+Father -->
		
		<!-- text -->
		<input type="text" name="fruit" value="apple">
		<br>
		<!-- radio -->
		<input type="radio" name="subject" value="JAVA">JAVA
		<input type="radio" name="subject" value="SQL">SQL
		<input type="radio" name="subject" value="HTML/CSS">HTML/CSS 
		<br>
		<!-- selector -->
		<select name="animal">
			<option value="dog">개</option>
			<option value="cat">고양이</option>
			<option value="tiger">호랑이</option>
		</select>
		<br>
		<!-- checkBox -->
		<input type="checkbox" name="movies" value="Taxi Driver">택시 드라이버
		<input type="checkbox" name="movies" value="Le Grand Blue">그랑블루
		<input type="checkbox" name="movies" value="The God Father">대부
		<br>
		
		<input type="submit" value="전송">
	</form>
	<hr>
	
	<h2>GET 방식4 - form 활용(쿼리스트링 자동 생성 -> Servlet 통해 이동)</h2>
	<form action="p4" method="get">
		<!-- 쿼리 스트링 -->
		<!-- ?fruit=banana&subject=SQL&animal=tiger&movies=Taxi+Driver&movies=The+God+Father -->
		<input type="text" name="fruit" value="apple">
		<br>
		<!-- radio -->
		<input type="radio" name="subject" value="JAVA">JAVA
		<input type="radio" name="subject" value="SQL">SQL
		<input type="radio" name="subject" value="HTML/CSS">HTML/CSS 
		<br>
		<!-- selector -->
		<select name="animal">
			<option value="dog">개</option>
			<option value="cat">고양이</option>
			<option value="tiger">호랑이</option>
		</select>
		<br>
		<!-- checkBox -->
		<input type="checkbox" name="movies" value="Taxi Driver">택시 드라이버
		<input type="checkbox" name="movies" value="Le Grand Blue">그랑블루
		<input type="checkbox" name="movies" value="The God Father">대부
		<br>
		
		<input type="submit" value="전송">
	</form>
	
</body>
</html>