<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>쇼핑몰 회원 관리</h1>
	<hr>

	<!-- 메뉴 -->
	<ul>
		<li><a href="memberRegist.jsp">회원등록</a></li>
		<li><a href="memberList">회원목록조회/수정</a></li>
		<li><a href="salesList">회원매출조회</a></li>
		<li><a href="index.jsp">홈으로</a></li>
	</ul>
	<hr>

	<!-- 메인 콘텐츠 -->
	<h2>회원목록조회/수정</h2>
	<form action="memberRegist" method="post">
		<table border="1">
			<thead>
				<tr>
					<th>회원번호</th>
					<th>회원성명</th>
					<th>전화번호</th>
					<th>주소</th>
					<th>가입일자</th>
					<th>고객등급</th>
					<th>거주지역</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="m" items="${memberList}" varStatus="status">
					<tr>
						<td><a href="memberUpdatePage?custno=${m.custno}">${m.custno}</a></td>
						<td>${m.custname}</td>
						<td>${m.phone}</td>
						<td>${m.address}</td>
						<td>${m.joindate}</td>
						<td>${m.grade}</td>
						<td>${m.city}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</form>

	<!-- 푸터 -->
	<footer>
		<small>copyright</small>
	</footer>
</body>
</html>