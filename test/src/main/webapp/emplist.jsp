<%@page import="test.Emp"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>EMP List Page</h1>
	<br>
	<%
	String url = "jdbc:oracle:thin:@localhost:1521:testdb";
	String uid = "green";
	String upw = "1234";

	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection conn = DriverManager.getConnection(url, uid, upw);
	Statement stmt = conn.createStatement();

	ResultSet rs = stmt.executeQuery("SELECT * FROM emp");
	%>
	<table border="1">
		<thead>
			<tr>
				<th>empno</th>
				<th>ename</th>
				<th>job</th>
				<th>mgr</th>
				<th>hiredate</th>
				<th>sal</th>
				<th>comm</th>
				<th>deptno</th>
			</tr>
		</thead>
		<tbody>
			<%
			while (rs.next()) {
			%>
			<tr>
				<td><%=rs.getString("empno")%></td>
				<td>
					<a href="p1.jsp?name=<%=rs.getString("ename")%>">
						<%=rs.getString("ename")%>
					</a>
				</td>
				<td><%=rs.getString("job")%></td>
				<td><%=rs.getString("mgr")%></td>
				<td><%=rs.getString("hiredate")%></td>
				<td><%=rs.getString("sal")%></td>
				<td><%=rs.getString("comm")%></td>
				<td><%=rs.getString("deptno")%></td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
</body>
</html>


