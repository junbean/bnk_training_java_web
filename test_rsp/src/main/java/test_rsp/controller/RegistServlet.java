package test_rsp.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import test_rsp.dao.MemberDAO;
import test_rsp.model.Member;

import java.io.IOException;

@WebServlet("/regist")
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegistServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 파라미터 받기
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		
		// Member 객체 생성
		Member member = new Member(id, pw, name);
		
		// dao 객체를 통한 확인
		MemberDAO dao = new MemberDAO();
		int result = dao.insert(member);
		
		if(result != 0) {
			// 성공
			// 세션에 저장
			HttpSession session = request.getSession();
			session.setAttribute("id", member.getId());
			session.setAttribute("name", member.getName());
			session.setAttribute("loggedIn", true);
			
			// 화면 전환
			response.sendRedirect("index.jsp");	
		} else {
			// 실패
			// 로그인 페이지로 다시 이동
			// request.getRequestDispatcher("login.jsp").forward(request, response);
			response.sendRedirect("regist.jsp");
		}
		
		// doGet(request, response);
	}

}
