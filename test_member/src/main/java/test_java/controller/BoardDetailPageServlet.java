package test_java.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import test_java.VO.Board;
import test_java.service.BoardService;

import java.io.IOException;

@WebServlet("/boardDetailPage")
public class BoardDetailPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    BoardService service = new BoardService();   
	
    public BoardDetailPageServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 파라미터 가져오기
		String bno_str = request.getParameter("bno");
		int bno = Integer.parseInt(bno_str);
		
		// 글 가져오기
		Board board = service.selectBoardByBno(bno);
		
		// request 저장
		request.setAttribute("curr_board", board);
		
		// 화면 전환
		request.getRequestDispatcher("boardDetailPage.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
