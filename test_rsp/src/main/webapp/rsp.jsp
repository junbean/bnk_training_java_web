<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	body {
        font-family: 'Arial', sans-serif;
        max-width: 800px;
        margin: 0 auto;
        padding: 20px;
        text-align: center;
    }
    
    .players {
        display: flex;
        justify-content: space-around;
        margin: 30px 0;
    }
    .player {
        text-align: center;
    }
    .player img {
        width: 100px;
        height: 100px;
        border: 2px solid #ddd;
        border-radius: 10px;
        padding: 10px;
    }
</style>
</head>
<body>
    <h1>가위바위보 게임</h1>
	
	<!-- 스코어 -->
	<div class="score-board">
	    <h3>승패 현황</h3>
	    <div class="score-detail">
	        <div class="score-item win">승: <span id="wins">0</span></div>
	        <div class="score-item draw">무: <span id="draws">0</span></div>
	        <div class="score-item lose">패: <span id="losses">0</span></div>
	    </div>
    </div>
	
	<!-- 사용자 선택 -->
	<div class="choices" id="choices">
		<button class="choice-btn" id="scissors" onclick="playGame(1)">가위</button>
		<button class="choice-btn" id="rock" onclick="playGame(2)">바위</button>
		<button class="choice-btn" id="paper" onclick="playGame(3)">보</button>
    </div>
    
	<!-- 플레이 -->    
    <div class="players">
        <div class="player">
            <h3>사용자</h3>
            <img src="" alt="없음" id="user_img" width="100" >
        </div>
        
        <div class="player">
            <h3>컴퓨터</h3>
            <img src="" alt="없음" id="computer_img" width="100" >
        </div>
    </div>
    
    <!-- 결과 메세지 -->
    <div class="message" id="message"></div>
    
    <!-- 행동 -->
    <div class="actions">
        <button id="save_score_btn" class="btn btn-save" onclick="saveScore()">기록 저장</button>
        <button id="home_btn" class="btn btn-home" onclick="logout()">로그아웃</button>
        <button id="ranking_btn" class="btn btn-ranking" onclick="viewRanking()">랭킹</button>
    </div>
    
    <!-- 자바스크립트 -->
    <script type="text/javascript">
		 // 게임 점수 변수
	    let wins = 0;
	    let draws = 0;
	    let losses = 0;
    
	 	// 선택에 대한 이미지 경로
        const images = {
            user: {
                1: "images/scissors.jpg",
                2: "images/rock.jpg",
                3: "images/paper.jpg"
            },
            computer: {
                1: "images/scissors.jpg",
                2: "images/rock.jpg",
                3: "images/paper.jpg"
            }
        };
	 	
        // 초기화 함수
        function init() {
            document.getElementById("user_img").src = "images/question.jpg";
            document.getElementById("computer_img").src = "images/question.jpg";
            document.getElementById("user_img").alt = "";
            document.getElementById("computer_img").alt = "";
            updateScore();
        }
        
     	// 게임 플레이 함수
        function playGame(userChoice) {
        	// 컴퓨터 선택 (1: 가위, 2: 바위, 3: 보)
            const computerChoice = Math.floor(Math.random() * 3) + 1;
            
            // 이미지 업데이트
            document.getElementById("user_img").src = images.user[userChoice];
            document.getElementById("computer_img").src = images.computer[computerChoice];
            
            // alt 텍스트 설정
            const choices = {1: "가위", 2: "바위", 3: "보"};
            document.getElementById("user_img").alt = choices[userChoice];
            document.getElementById("computer_img").alt = choices[computerChoice];
            
            // 승패 결정
            let result = "";
    		
            if (userChoice === computerChoice) {
                result = "무승부!";
                draws++;
            } else if (
                (userChoice === 1 && computerChoice === 3) || 
                (userChoice === 2 && computerChoice === 1) || 
                (userChoice === 3 && computerChoice === 2)
            ) {
                result = "승리!";
                wins++;
            } else {
                result = "패배!";
                losses++;
            }
            
            // 결과 메시지 표시
            document.getElementById("message").textContent = result;
            
            // 점수 업데이트
            updateScore();
    	}
     	
     	
     	// 점수 업데이트 함수
        function updateScore() {
            document.getElementById("wins").textContent = wins;
            document.getElementById("draws").textContent = draws;
            document.getElementById("losses").textContent = losses;
        }
     	
     	// 점수 저장
        function saveScore() {
            // URL에 파라미터를 포함하여 페이지 이동
            window.location.href = `savescore?wins=${wins}&draws=${draws}&losses=${losses}`;
        }
     	
     	
        function logout() {
            window.location.href = "logout";
        }

        // 페이지 로드 시 초기화
        window.onload = init;
    </script>
</body>
</html>
<!-- 
	<button class="choice-btn" id="scissors" onclick="playGame(1)">
           <img src="img/sci.jpg" alt="가위">
       </button>
       <button class="choice-btn" id="rock" onclick="playGame(2)">
           <img src="img/rock.jpg" alt="바위">
       </button>
       <button class="choice-btn" id="paper" onclick="playGame(3)">
           <img src="img/paper.jpg" alt="보">
       </button>
       
       
       이 형식으로 다시 짜줄래
그리고 추가사항이 있음
1. 로그아웃 버튼을 사용해서 logout서블릿으로 이동후에 세션객체에 사용자의 데이터를 삭제하는 기능
2. 기록 저장은 일단은 가위바위보를 하지 않더라도 기록을 저장할수 있음, 그리고 숨기지 않고 드러내도 좋음




     	/*
        // 점수 저장
     	function saveScore() {
            // AJAX를 사용하여 서버에 점수 저장
            const xhr = new XMLHttpRequest();
            xhr.open("POST", "SaveScoreServlet", true);
            xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
            xhr.onreadystatechange = function() {
                if (xhr.readyState === 4 && xhr.status === 200) {
                    alert("점수가 성공적으로 저장되었습니다!");
                }
            };
            xhr.send(`wins=${wins}&draws=${draws}&losses=${losses}`);
        }
     	*/
-->