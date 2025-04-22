<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
String url = "jdbc:oracle:thin:@localhost:1521:testdb";
String uid = "green";
String upw = "1234";

Class.forName("oracle.jdbc.driver.OracleDriver");
Connection conn = DriverManager.getConnection(url, uid, upw);
Statement stmt = conn.createStatement();

int result = stmt.executeUpdate("INSERT INTO tbl_member VALUES('junbin4531', 232323, 'junbin', '010-3333-2222', 'C')");


// a.jsp페이지에서 바로 emplist.jsp페이지로 이동
response.sendRedirect("emplist.jsp");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
	<h1>A page</h1>
	<hr>
	<p>a.jsp 페이지 입니다</p>
	<a href="emplist.jsp">b.jsp 페이지로 이동</a>
</body>
</html>