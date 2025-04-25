# bnk_training_java_web

bnk 자바 웹서버 학습

<br>
<br>
<br>

# 요청 - request

1. GET 방식 (주소창에 파라미터가 보여진다)
    - `a` 태그 이용 (쿼리스트링 직접 작성)
        - `form`을 통한 `GET` method (쿼리 스트링 자동 생성)
2. POST 방식 (주소창에 파라미터가 보여지지 않는다)
    - 요청 몸통(body)에 파라미터를 실어 보낸다

# 응답 - response

1. 요청을 처리하는 과정에서 view를 지정하는 것
    - request 객체를 활용
    - request.getRequestDispatcher("페이지지정.jsp");
2. 클라이언트의 요청을 완료한 후 view를 지정하는 것
    - response 객체를 활용
    - response.sendRedirect("페이지지정.jsp");

<br>
<br>
<br>

# 요청, 응답 데이터 형태

클라이언트(view) --------> 데이터(parmeter) --------> 서버(servlet)

클라이언트(view) <-------- 데이터(request 영역에 저장) <-------- 서버(servlet)

<br>
<br>
<br>
<hr>
<br>
<br>
<br>

# http의 특징

-   비연결성
-   사용자의 기록을 기억하지 않음
-   그래서 저장소를 필요로 하다
-   그리고 request도 공유하지 않기에 복사를 해서 상태를 저장한다

<br>
<br>
<br>

# 값을 저장하기 위한 저장소

1. page
2. request
3. session
4. application

<br>
<br>
<br>

# WAS 서버에 대해

<br>
<br>
<br>
<hr>
<br>
<br>
<br>

# `JSTL` - Action Tag

1. <jsp:forward>

    - 해당 태그 사이에 내용이 있을경우 <></> 이걸 사용
    - 아니면 걍 </> 이거 사용

2. <jsp:include>
    - 파일을 포함해서 나타냄
    - jsp파일을 사용하면 해당 jsp파일의 내용이 화면에 출력 + 거기서 지정한 저장소의 데이터도 사용가능하다(pageContext 제외)
3. <jsp:param>
    - 파라미터를 전달함
4. <jsp:useBean>
    - 자바 클래스 객체 사용
5. <jsp:setProperty>
6. <jsp:getProperty>
