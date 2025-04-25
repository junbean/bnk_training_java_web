<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	
	<!--  -->
	
	내용 페이지 입니다. <br>

	<a href="sub.jsp">서브 페이지로 이동</a><br>

	header의 페이지 영역의 x값 : ${pageScope.x }			<!-- pageContext는 화면이 다르면 닿을수 없으므로 값 가져오기 안됨 -->

	<!--  -->

	<jsp:include page="footer.jsp" />
</body>
</html>