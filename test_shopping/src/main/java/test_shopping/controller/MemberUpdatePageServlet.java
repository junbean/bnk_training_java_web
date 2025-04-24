package test_shopping.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import test_shopping.VO.Member;
import test_shopping.dao.MemberDao;

import java.io.IOException;

@WebServlet("/memberUpdatePage")
public class MemberUpdatePageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberUpdatePageServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 파라미터 받기
		String custno_str =  request.getParameter("custno");
		int custno = Integer.parseInt(custno_str);
		
		// custno에 해당하는 데이터 행 가져오기
		MemberDao dao = new MemberDao();
		Member member = dao.selectOne(custno);
		
		// request에 저장
		request.setAttribute("memberUpdate", member);
		
		// memberUpdatePage로 화면 전환
		request.getRequestDispatcher("memberUpdate.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
