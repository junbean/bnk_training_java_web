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
		<h3>제품 코드 조회</h3>
		<table border="1">
			<thead>
				<tr>
					<th>제품코드</th>
					<th>제품명</th>
					<th>단가</th>
					<th>할인율(10%)</th>
					<th>할인율(15%)</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="productListDto" items="${productList }">
					<tr>
						<td>${productListDto.pcode }</td>
						<td>${productListDto.pname }</td>
						<td>${productListDto.cost }</td>
						<td>${productListDto.discount10 }</td>
						<td>${productListDto.discount15 }</td>
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