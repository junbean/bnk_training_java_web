<%@page import="ex04.VO.Man"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Man man = new Man();
	man.setName("홍길동");
	man.setAge(22);
	man.setJob("개발자");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="m" class="ex04.VO.Man">
		<jsp:setProperty property="name" name="m" value="홍길순" />
		<jsp:setProperty property="age" name="m" value="32" />
		<%--  <jsp:setProperty property="job" name="m" p="디자이너" /> --%>
		<jsp:setProperty property="job" name="m" param="job" /> 
	</jsp:useBean>
	
	이름 : <jsp:getProperty property="name" name="m" /><br>
	나이 : <jsp:getProperty property="age" name="m" /><br>
	직업 : <jsp:getProperty property="job" name="m" /><br>
	
	<%= m.getAge() %>
</body>
</html>