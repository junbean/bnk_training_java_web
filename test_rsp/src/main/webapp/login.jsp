<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>로그인 페이지</h1>
	<hr>
	<form action="login" method="post">
        <div>
            <label for="id">아이디</label>
            <input type="text" id="id" name="id" placeholder="아이디를 입력하세요" required>
        </div>
        <div>
            <label for="pw">비밀번호</label>
            <input type="password" id="pw" name="pw" placeholder="비밀번호를 입력하세요" required>
        </div>
        <div style="margin-top: 15px;">
            <input type="submit" value="로그인">
        </div>
    </form>
    
    <div class="signup-prompt">
        계정이 없으신가요?
        <a href="regist.jsp" class="signup-btn">회원가입</a>
    </div>
</body>
</html>