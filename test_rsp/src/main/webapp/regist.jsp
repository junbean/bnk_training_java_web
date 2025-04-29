<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
	<h1>회원가입 페이지</h1>
	<hr>
	<form action="regist" method="post">
        <div>
            <label for="id">아이디</label>
            <input type="text" id="id" name="id" placeholder="사용할 아이디를 입력하세요" required>
        </div>
        <div>
            <label for="pw">비밀번호</label>
            <input type="password" id="pw" name="pw" placeholder="비밀번호를 입력하세요" required>
        </div>
        <div>
            <label for="name">이름</label>
            <input type="text" id="name" name="name" placeholder="이름을 입력하세요" required>
        </div>
        <div style="margin-top: 15px;">
            <input type="submit" value="가입하기">
        </div>
    </form>
    
    <div class="login-prompt">
        이미 계정이 있으신가요?
        <a href="login.jsp" class="login-btn">로그인</a>
    </div>
</body>
</html>