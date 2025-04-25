<%@page import="java.util.List"%>
<%@page import="test_discount_store.VO.OrderListDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
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
		<h3>주문 목록</h3>
		<table border="1">
			<thead>
				<tr>
					<th>할인점코드</th>
					<th>점포명</th>
					<th>주문번호</th>
					<th>주문일자</th>
					<th>제품코드</th>
					<th>제품명</th>
					<th>주문수량</th>
					<th>단가</th>
					<th>소비자가격</th>
					<th>할인가격</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="orderListDto" items="${orderList }">
					<tr>
						<td>${orderListDto.shopNo }</td>
						<td>${orderListDto.shopName }</td>
						<td>${orderListDto.orderNo }</td>
						<!--  
						<td>
   		 					<fmt:formatNumber value="${orderListDto.orderNo}" pattern="####-####" />
						</td>
						-->
						<td>${orderListDto.orderDate }</td>
						<td>${orderListDto.PCode }</td>
						<td>${orderListDto.PName }</td>
						<td>${orderListDto.amount }</td>
						<td>${orderListDto.cost }</td>
						<td>${orderListDto.consumerPrice }</td>
						<td>${orderListDto.discountPrice }</td>
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