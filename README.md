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
