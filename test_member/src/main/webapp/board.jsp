<%@page import="java.util.ArrayList"%>
<%@page import="test_java.VO.Board"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<Board> list = (ArrayList<Board>) session.getAttribute("board_list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>게시글 목록 페이지입니다</h1>
	<hr>
	<table border="1">
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일자</th>
			</tr>
		</thead>
		<tbody>
			<%
				for(int i=0; i<list.size(); i++) {
			%>
			<tr>
				<td><%= list.get(i).getBno() %></td>
				<td><a href="boardDetailPage?bno=<%= list.get(i).getBno() %>"><%= list.get(i).getTitle() %></a></td>
				<td><%= list.get(i).getWriter() %></td>
				<td><%= list.get(i).getRegdate() %></td>
			</tr>
			<%
				}
			%>
		</tbody>
	</table>
	<p><a href="writeBoardPage">글 작성하기</a></p>
	<p><a href="index.jsp">처음으로</a></p>
</body>
</html>