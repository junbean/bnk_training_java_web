<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="man" class="ex04.VO.Man" />
	<!-- 
	<jsp:setProperty property="name" name="man" param="name" />
	<jsp:setProperty property="age" name="man" param="age" />
	<jsp:setProperty property="job" name="man" param="job" />
	 -->
	 
	<jsp:setProperty property="*" name="man" />
	
	이름 : <jsp:getProperty property="name" name="man" /><br>
	나이 : <jsp:getProperty property="age" name="man" /><br>
	직업 : <jsp:getProperty property="job" name="man" /><br>
</body>
</html>