package ex02.controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import ex02.service.MemberService;
import ex02.vo.MemberVO;

@WebServlet("/ExServlet")
public class ExServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MemberService memberService = new MemberService();
       
    public ExServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	public void destroy() {
		// TODO Auto-generated method stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 파라미터 받기
		List<MemberVO> list = memberService.selectAll();
		
		// 키-값 처럼 list라는 이름으로 list값을 저장한다
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("memberList.jsp").forward(request, response);
	}

	/*
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 파라미터 받기
		// 파라미터로 받은데이터 가지고 해볼만 한 것들
		// 데이터 유효성 검사...
		
		
		
		
		doGet(request, response);
	}
	*/
}
