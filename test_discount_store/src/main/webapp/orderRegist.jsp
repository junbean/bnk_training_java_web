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
		<h3>주문 등록</h3>
		<form action="orderRegist" method="post">
			<table border="1">
				<tbody>
					<tr>
						<td>주문번호</td>
						<td><input type="text" name="orderno" placeholder="20250001"></td>
					</tr>
					<tr>
						<td>주문점포</td>
						<td>
							<select name="shopno">
								<c:forEach var="shop" items="${listShop }">
									<option value="${shop.shopno}">${shop.shopname }</option>
								</c:forEach>
							</select>
						</td>
					</tr>
					<tr>
						<td>주문일자</td>
						<td><input type="text" name="orderdate" placeholder="YYYYMMDD"></td>
					</tr>
					<tr>
						<td>제품코드</td>
						<td>
							<select name="pcode">
								<c:forEach var="product" items="${listProduct }">
									<option value="${product.pcode}">${product.pname }</option>
								</c:forEach>
							</select>
						</td>
					</tr>
					<tr>
						<td>주문수량</td>
						<td><input type="text" name="amount"></td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="submit" value="주문등록">
							<input type="button" value="다시쓰기">
						</td>
					</tr>
				</tbody>
			</table>
		</form>
		
	</section>
	
	<!-- footer -->
	<hr>
	<c:import url="footer.jsp" />
</body>
</html>