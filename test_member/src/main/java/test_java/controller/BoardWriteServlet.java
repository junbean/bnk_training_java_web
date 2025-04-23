package test_java.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import test_java.VO.Board;
import test_java.VO.Member;
import test_java.service.BoardService;

import java.io.IOException;

@WebServlet("/writeBoard")
public class BoardWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BoardService service = new BoardService(); 
       
    public BoardWriteServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		// 사용자 객체 가져오기
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("member");
		
		// 세션에 유저 정보가 유효한지 확인
		if(member == null) {
			System.out.println("세션에 유저 정보가 유효하지 않습니다");
			response.sendRedirect("board");
		} 
		
		// 게시글 객체 생성
		Board board = new Board();
		board.setTitle(title);
		board.setContent(content);
		board.setWriter(member.getId());
		
		// 게시글 데이터 삽입
		int result = service.insertBoard(board);
		
		if(result == 0) {
			// 게시글 자성 안됨
			System.out.println("게시글 작성에 실패했습니다. 다시 작성해주세요");
			response.sendRedirect("writeBoardPage");
		} else {
			// 게시글 작성 됨
			System.out.println("게시글 작성에 성공했습니다. 게시글 목록으로 이동합니다");
			response.sendRedirect("board");
		}	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
