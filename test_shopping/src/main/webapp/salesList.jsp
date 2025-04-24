<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<!-- 
	회원의 총 매출현황이 조회됨
	
	두 개의 테이블을 참조하여 아래와 같은 데이터를 출력하낟
		1. 회원 번호
		2. 회원 성명
		3. 고객 등급
		4. 매출
	
	예시(A:VIP B:일반 C:직원) - 매출이있는 회원의 총 매출 현황
		회원번호	회원성명	고객등급	매출		
		10001	김항복	VIP		8000
		
	조회순서는 매출이 높은 회원 수능로
		매출이 없는 회원은 조회되지 않는다
	
 -->
 
 
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
	<h2>회원매출조회</h2>
	<table border="1">
		<thead>
			<tr>
				<th>회원번호</th>
				<th>회원성명</th>
				<th>고객등급</th>
				<th>매출</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="s" items="${salesList}" varStatus="status">
				<tr>
					<td>${s.custno }</td>
					<td>${s.custname }</td>
					<td>${s.grade }</td>
					<td>${s.total }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<!-- 푸터 -->
	<footer>
		<small>copyright</small>
	</footer>
<body>
</body>
</html>