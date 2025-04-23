package test_java.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import test_java.VO.Board;
import test_java.service.BoardService;
import test_java.service.MemberService;

import java.io.IOException;
import java.util.List;

@WebServlet("/board")
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    BoardService service = new BoardService();
    
	
    public BoardServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 게시글 전체 조회
		List<Board> list = service.selectAllBoard();
		
		// session 지정
		HttpSession session = request.getSession();
		session.setAttribute("board_list", list);
		
		// board.jsp로 화면 전환
		request.getRequestDispatcher("board.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
