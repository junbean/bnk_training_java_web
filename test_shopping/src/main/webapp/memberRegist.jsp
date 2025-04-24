<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%! int gno = 1; %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<!-- 
	회원 등록
	1. 회원 정보 항목 입력창에 모든 항목의 정보를 채우고 등록버튼을 누르면 db에 저장됨
	
	2. 이 때 회원번호는 자동생성 된다 (마지막 번호 + 1) 
		아무래도 이건 시퀀스가 아니라 사용자 입력에 따라서 등록이 되면 자동으로 +1 되는거인듯
	3. 항목에 정보를 넣지 않으면 알람창을 출력하여 사용자에게 알림
	
	4. 모든 항목에 대해서 유효성 체크를 실시함(유효한 값이 맞는지 확인)
		유효하지 않으면 알림표시
	
	5. 등록이 성공적이면 알림창 표시
	
	6. 조회버튼을 클릭하면 회원목록 화면으로 이동함
	
	7. 
 -->
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
	<h2>홈쇼핑 회원 등록</h2>
	<form action="memberRegist" method="post">
		<table border="1">
			<tbody>
				<tr>
					<th>회원번호(자동발생)</th>
					<td><input type="text" name="custno" required="required" /></td>
				</tr>
				<tr>
					<th>회원성명</th>
					<td><input type="text" name="custname" required="required" /></td>
				</tr>
				<tr>
					<th>회원전화</th>
					<td><input type="text" name="phone" required="required" /></td>
				</tr>
				<tr>
					<th>회원주소</th>
					<td><input type="text" name="address" required="required" /></td>
				</tr>
				<tr>
					<th>가입일자</th>
					<td><input type="text" name="joindate" required="required" /></td>
				</tr>
				<tr>
					<th>고객등급(A:VIP, B:일반, C:직원)</th>
					<td><input type="text" name="grade" required="required" /></td>
				</tr>
				<tr>
					<th>도시코드</th>
					<td><input type="text" name="city" required="required" /></td>
				</tr>
				<tr>
					<td colspan="2" >
						<input type="submit" value="등록" />
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