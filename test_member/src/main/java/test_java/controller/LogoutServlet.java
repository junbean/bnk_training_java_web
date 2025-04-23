package test_java.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import test_java.VO.Member;

import java.io.IOException;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LogoutServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Member get_member = (Member)session.getAttribute("member");

		if(get_member != null) {
			// 로그인된게 맞음
			
			// 세션에 member 키 값을 삭제
			session.removeAttribute("member");
			System.out.println("로긔아웃 되었습니다");
			response.sendRedirect("index.jsp");	
		} else {
			// 로그인이 안됨
			System.out.println("로그인된 사용자가 아닙니다. 로그인부터 해주세요");
			response.sendRedirect("index.jsp");
		}
		
		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
