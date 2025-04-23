package test_java.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import test_java.VO.Member;

import java.io.IOException;

@WebServlet("/writeBoardPage")
public class BoardWritePageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardWritePageServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 세션 객체 가져오기
		HttpSession session = request.getSession();
		Member member = (Member)session.getAttribute("member");
		
		if(member != null) {
			// 로그인 됨
			System.out.println("게시글 작성 페이지로 이동합니다");
			response.sendRedirect("writeBoardPage.jsp");
		} else {
			// 로그인 안됨
			System.out.println("로그인을 먼저 해주시기 바랍니다");
			response.sendRedirect("board");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
