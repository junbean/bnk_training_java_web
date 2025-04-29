<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 로그인 상태에 따라 리다이렉트 -->


<c:choose>
    <c:when test="${sessionScope.loggedIn}">
        <c:redirect url="rsp.jsp" />
    </c:when>
    <c:otherwise>
        <c:redirect url="login.jsp" />
    </c:otherwise>
</c:choose>

<%-- 
	<h1>index page</h1>
	<p>로그인 여부 : ${session.loggedIn }</p>
	<hr>
	<h3><a href="login.jsp">로그인 화면 이동</a></h3>
	<h3><a href="login.jsp">회원가입 화면 이동</a></h3>
	<h3><a href="rsp.jsp ">가위바위보 화면 이동</a></h3>
--%>
</body> 
</html>