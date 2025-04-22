<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 1. 파라미터 받기
	String bno = request.getParameter("bno");
	
	// 2. DB 접속하기
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection conn = DriverManager.getConnection(
						"jdbc:oracle:thin:@localhost:1521:testdb", 
						"green", 
						"1234"
					);
	
	// 3. 쿼리 실행하기
	String query = "SELECT * FROM tbl_board WHERE bno = ?";
	PreparedStatement pstmt = conn.prepareStatement(query);
	pstmt.setString(1, bno);
	
	// 4. 결과 집합 받기
	ResultSet rs = pstmt.executeQuery();
	rs.next();
	
	// 5. 화면에 데이터 보여주기
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Board Detail Page</h1>
	<hr>
	<ul>
		<li><%= rs.getString("bno") %></li>
		<li><%= rs.getString("title") %></li>
		<li><%= rs.getString("content") %></li>
		<li><%= rs.getString("writer") %></li>
		<li><%= rs.getString("regdate") %></li>
	</ul>
</body>
</html>