<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="ex06.dao.DBconnPool"%>
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
	<%
		/*  
		DBconnPool dbp = new DBconnPool();
		dbp.close();
		*/
		
		String driver = application.getInitParameter("OracleDriver");
		String url = application.getInitParameter("OracleUrl");
		String uid = application.getInitParameter("OracleId");
		String upw = application.getInitParameter("OraclePw");
		
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, uid, upw);

		/*
			jsp에서 모두 때려박아서 개발
			이렇게 개발하는 방식을 model-1 방식이라고 한다
			
			model, view, controller로 계층을 나눠서 개발
			즉, 백엔드와 클라이언트를 구분해서 개발하는 방식
			이걸 model-2 방식이라고 한다

		*/
	%>

	driver : <%= driver %><br>
	url : <%= url %><br>
	uid : <%= uid %><br>
	upw : <%= upw %><br>
</body>
</html>