<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- header  -->
	<c:import url="header.jsp" />
	<hr>

	<!-- menu -->
	<c:import url="menu.jsp" />
	<hr>
	
	<!-- 메인 콘텐츠 -->
	<section>
		<h3>점포별 주문현황</h3>
		<table border="1">
			<thead>
				<tr>
					<th>할인점코드</th>
					<th>제품코드</th>
					<th>제품명</th>
					<th>주문총수량</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="shopOrderListDto" items="${shopOrderList }">
					<tr>
						<td>${shopOrderListDto.shopno }</td>
						<td>${shopOrderListDto.pcode }</td>
						<td>${shopOrderListDto.pname }</td>
						<td>${shopOrderListDto.totalAmount }</td>
					</tr>
				</c:forEach>				
			</tbody>
		</table>
	</section>
	
	<!-- footer -->
	<hr>
	<c:import url="footer.jsp" />
</body>
</html>