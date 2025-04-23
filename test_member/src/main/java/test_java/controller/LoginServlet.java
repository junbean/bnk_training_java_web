package test_java.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import test_java.VO.Member;
import test_java.dao.MemberDao;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		MemberDao dao = new MemberDao();
		Member member = dao.selectOne(id, pw);
	
		if(member != null) {
			// 로그인 됨
			System.out.println("환영합니다! 회원 전용 페이지입니다!");

			// 로그인 객체 저장
		    HttpSession session = request.getSession();
			session.setAttribute("member", member);

			System.out.println("로그인에 성공했습니다!");
			request.getRequestDispatcher("loginResult.jsp").forward(request, response);
		} else {
			// 로그인 안됨
			System.out.println("로그인에 실패했습니다. 다시 입력해주세요");
			response.sendRedirect("login.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
