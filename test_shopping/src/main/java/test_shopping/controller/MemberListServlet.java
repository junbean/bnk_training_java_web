package test_shopping.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import test_shopping.VO.Member;
import test_shopping.dao.MemberDao;

import java.io.IOException;
import java.util.List;

@WebServlet("/memberList")
public class MemberListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberListServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 회원 목록 가져오기
		MemberDao dao = new MemberDao();
		List<Member> list = dao.selectAll();
		
		// 회원 목록 request에 저장
		request.setAttribute("memberList", list);
		
		// 회원 목록 화면 전환
		request.getRequestDispatcher("memberList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
