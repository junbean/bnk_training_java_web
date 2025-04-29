<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- EL (Expression Language) -->
	${"Hello" }<br>
	
	<!-- 표현식 (Expression) -->
	<%= "Hello" %><br>
	
	<!-- 스크립 트릿 -->
	<% out.println("Hello"); %>
	
	<hr>
	
	정수형 : ${10 } <br>
	실수형 : ${5.6 }<br>
	문자열형 : ${"안녕" }<br>
	논리형 : ${true }<br>
	null : ${null }<br>
	
	<hr>
	
	\${5+2} : ${5+2}<br>
	\${5/2} : ${5/2}<br>
	<%--
		에러나서 잠시 주석 처리 
		\${5 div 2} : ${5 div 2}<br> 
	--%>
	\${5 mod 2} : ${5 mod 2}<br>
	\${5 > 2} : ${5 > 2}<br>
	\${2 gt 5} : ${2 gt 5}<br>	<!-- 부등호 대신 사용된, gt : greater than -> > -->
	\${2 lt 5} : ${2 lt 5}<br>	<!-- lt : lower than -> < -->
	\${2 eq 2} : ${2 eq 2}<br>	<!-- eq : equal -->
	<%-- 
		에러나서 잠시 주석 처리
		\${2 ne 5} : ${2 ne 2}<br> 	<!-- ne : not equal -->
	--%>	
	\${(5 > 2) ? 5 : 2} : ${(5 > 2) ? 5 : 2}<br>
	\${(5 > 2) || (2 < 10)} : ${(5 > 2) || (2 < 10)}<br>
	<%
		String input = null;
	%>
	\${empty input} : ${empty input}<br>
	
	
	
	
	
	
	
	
	
	
</body>
</html>