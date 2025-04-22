<%@page import="ex02.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	// 이대로 받으면 타입이 안 맞아서 못 받는다
	// request.getAttribute는 object 타입으로 반환한다
	List<MemberVO> list = (List<MemberVO>) request.getAttribute("list");

// 서블릿이 클라이언트에게 요청받고
// 서블릿이 서비스에게 전달하고
// 서비스는 dao한테 전달하고
// dao는 db에 쿼리를 나르고
// db는 결과집합을 서비스한테 주고
// 서비스는 받은 자료를 서블릿한테 주고
// 서블릿은 리퀘스트 영역에 그 자료를 저장하고
// 저장한 다음에 뷰에 전달한다
// 이러한 모델을 mvc 모델이라고 한다
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>MemberList Page</h1>
	<hr>
	<table>
		<thead>
			<tr>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<!-- 반복 시작 -->
			<%
				for(MemberVO m : list) {
			%>
			<tr>
				<td><%= m.getId() %></td>
				<td><%= m.getName() %></td>
				<td><%= m.getTel() %></td>
			</tr>
			<%
				}
			%>
		</tbody>
	</table>
</body>
</html>