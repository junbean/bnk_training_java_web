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

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		// dao 객체를 통한 확인
		MemberDAO dao = new MemberDAO();
		Member member = dao.selectOne(id, pw);
		
		if(member != null) {
			// 성공
			System.out.println("로그인에 성공했습니다.");
			// 세션에 저장
			HttpSession session = request.getSession();
			session.setAttribute("id", member.getId());
			session.setAttribute("name", member.getName());
			session.setAttribute("loggedIn", true);
			// 화면 전환
			response.sendRedirect("index.jsp");	
		} else {
			// 실패
			System.out.println("로그인에 실패했습니다.");
			// 로그인 페이지로 다시 이동
			response.sendRedirect("login.jsp");
		}
	}
}
//request.getRequestDispatcher("login.jsp").forward(request, response);
