<%@page import="ex04.VO.A"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- JSTL의 CORE를 쓸때 이름을 C로 정함 -->
<%@ taglib prefix="c" uri="jakarta.tags.core"%>		

<!-- 스크릿 플립 -->
<% %>	

<!-- 표현식 -->
<%= %>	

<!-- 전역을 의미하는 스트릿 플립 -->
<!-- 함수도 정의할수 있다 -->
<%! 
	int ggolbal = 1;
	void f(){ } 
%>	

<%! int gn = 1;%>
<%
	int ln = 1;
	// gn++; // 전역에서 발생하여 새로고침하면 계속 증가한다
	// ln++;
	
	List<A> list = new ArrayList<>();
	list.add(new A("홍길동1", 23));
	list.add(new A("홍길동2", 24));
	list.add(new A("홍길동3", 25));
	
	pageContext.setAttribute("list", list);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 주석 -->
<%-- 주석 - 개발자 코드에서 나타나지 않게 한다 --%>
	GN : <%= gn %><br>
	LN : <%= ln %><br>
	<table border="1">
		<thead>
			<tr>
				<th>no</th>
				<th>name</th>
				<th>age</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="a" items="${list}" varStatus="status">
				<tr>
					<td>${status.count }</td>
					<td>${a.name }</td>
					<td>${a.age }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>