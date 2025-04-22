<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="test.DBCon"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
// 파라미터는 대소문자를 구분한다
String ename = request.getParameter("name");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1><%=ename%>의 상세 프로필 페이지
	</h1>
	<hr>
	<%
	Connection conn = DBCon.getConnection();

	String query = "SELECT * FROM emp WHERE ename = ?";
	PreparedStatement pstmt = conn.prepareStatement(query);
	pstmt.setString(1, ename);

	ResultSet rs = pstmt.executeQuery();

	rs.next();

	/*
	int empno = rs.getInt("empno");
	String job = rs.getString("job");
	int mgr = rs.getInt("mgr");
	String hiredate = rs.getString("hiredate");
	int sal = rs.getInt("sal");
	int comm = rs.getInt("comm");
	int deptno = rs.getInt("deptno");
	*/
	%>

	<p>
		사원번호 :
		<%=rs.getInt("empno")%>
	</p>
	<p>
		직책 :
		<%=rs.getString("job")%>
	</p>
	<p>
		상급자 :
		<%=rs.getInt("mgr")%>
	</p>
	<p>
		고용일 :
		<%=rs.getString("hiredate")%>
	</p>
	<p>
		월급 :
		<%=rs.getInt("sal")%>
	</p>
	<p>
		상여금 :
		<%=rs.getInt("comm")%>
	</p>
	<p>
		직책번호 :
		<%=rs.getInt("deptno")%>
	</p>
</body>
</html>