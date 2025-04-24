<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<h2>홈쇼핑 회원 정보 수정</h2>
	<form action="memberUpdate" method="post">
		<table border="1">
			<tbody>
				<tr>
					<th>회원번호(자동발생)</th>
					<td><input type="text" name="custno" value=${memberUpdate.custno } required="required" /></td>
				</tr>
				<tr>
					<th>회원성명</th>
					<td><input type="text" name="custname" value=${memberUpdate.custname }  required="required" /></td>
				</tr>
				<tr>
					<th>회원전화</th>
					<td><input type="text" name="phone" value=${memberUpdate.phone } required="required" /></td>
				</tr>
				<tr>
					<th>회원주소</th>
					<td><input type="text" name="address" value=${memberUpdate.address } required="required" /></td>
				</tr>
				<tr>
					<th>가입일자</th>
					<td><input type="text" name="joindate" value=${memberUpdate.joindate } required="required" /></td>
				</tr>
				<tr>
					<th>고객등급(A:VIP, B:일반, C:직원)</th>
					<td><input type="text" name="grade" value=${memberUpdate.grade } required="required" /></td>
				</tr>
				<tr>
					<th>도시코드</th>
					<td><input type="text" name="city" value=${memberUpdate.city } required="required" /></td>
				</tr>
				<tr>
					<td colspan="2" >
						<input type="hidden" name="custno_org" value=${memberUpdate.custno }>				
						<input type="submit" value="수정" />
						<input type="button" value="조회" onclick="location.href='memberList'" />
					</td>
				</tr>
			</tbody>
		</table>
	</form>
	
	<!-- 푸터 -->
	<footer>
		<small>copyright</small>
	</footer>

</body>
</html>