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

<br>
<br>
<br>
<hr>

server -> server.xml에 접근
<GlobalNamingResources></GlobalNamingResources>안에서 작성

<Resource 
  		auth="Container"
  		driverClassName="oracle.jdbc.driver.OracleDriver"
  		type="javax.sql.DataSource"
  		initialiSize="5"
  		minIdle="5"
  		maxTotal="20"
  		maxIdle="20"
  		maxWaitMillis="5000" 
  		url="jdbc:oracle:this:@Localhost:1521:testdb"
  		name="dbcp_myoracle"
  		username="green"
  		passord="1234" />

<!--
		type : 데이터소스로 사용할 클래스명
		initialSize : 풀의 최초 초기화 과정에서 미리 만들어 놓을 연결의 개수(기본 : 0)
		minIdle : 최소한으로 유지할 연결 개수
		maxTotal : 동시에 사용할 수 있는 최대 연결 개수(기본 : 8)
		maxIdle : 풀에 반납할 때 최대로 유지될 수 있는 연결 개수(기본 : 8)
		maxWaitMillis : 새로운 요청이 들어왓을 때 얼마나 대기할지를 밀리초 단위로 기술
		name : 생성할 자원이름(풀이름)
-->

server -> context.xml에 접근
<Context></Context>안에서 작성

<ResourceLink global="dbcp_myoracle" name="dbcp_myoracle" type="javax.sql.DataSource" />

<hr>

연결하는 되는 이름
server.xml -> GlobalNamingResources 태그 -> Resource 태그의 name
context.xml -> ResourceLink 태그의 global

<br>

context.xml -> ResourceLink 태그의 name
DBconnPool -> DataSource ds = (DataSource)ctx.lookup("dbcp_myoracle");
<-- 여기에 name과 연결

<br>
<hr>
<br>

프로젝트 내의 webapp -> web.xml에서 작성
<context-param>
<param-name>OracleDriver</param-name>
<param-value>oracle.jdbc.driver.OracleDriver</param-value>
</context-param>
<context-param>
<param-name>OracleUrl</param-name>
<param-value>jdbc:oracle:thin:@localhost:1521:testdb</param-value>
</context-param>
<context-param>
<param-name>OracleId</param-name>
<param-value>green</param-value>
</context-param>
<context-param>
<param-name>OraclePw</param-name>
<param-value>1234</param-value>
</context-param>
