package test_rsp.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 세션 객체 가져오기
		HttpSession session = request.getSession(false);
        
		if (session != null) {
            // 로그아웃 메시지 출력
            System.out.println("사용자 " + session.getAttribute("id") + "가 로그아웃했습니다.");
            
            // 세션 무효화 (모든 세션 데이터 삭제)
            session.invalidate();
        }

        // 로그인 페이지로 이동
        response.sendRedirect("login.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
