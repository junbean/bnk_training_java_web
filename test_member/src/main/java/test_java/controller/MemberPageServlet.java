package test_java.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import test_java.VO.Member;

import java.io.IOException;

@WebServlet("/memberPage")
public class MemberPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberPageServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 세션 객체 가져오기
	    HttpSession session = request.getSession();
		Member get_member = (Member) session.getAttribute("member");
	    
		// 세션 member 객체 판별
		if(get_member != null) {
			System.out.println("환영합니다! 회원 전용 페이지입니다!");
			request.getRequestDispatcher("memberPage.jsp").forward(request, response);
		} else {
			System.out.println("회원 전용 페이지입니다. 회원가입을 먼저 진행해주십시오.");
			response.sendRedirect("index.jsp");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
