<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>Post 방식에서 한글 깨짐 방지</h3>
	<hr>
	
	<form  action="jstl_fmt_form_result.jsp" method="POST">
		이름 : <input type="text" name="name" required><br>
		<input type="submit" value="전송">	
	</form>
</body>
</html>

