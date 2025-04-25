<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>JSTL - FORM 결과</h3>
	<hr>
	
	<% request.setCharacterEncoding("UTF-8"); %>
	<fmt:requestEncoding value="UTF-8" />
	이름 : <c:out value="${param.name }" />
	
</body>
</html>