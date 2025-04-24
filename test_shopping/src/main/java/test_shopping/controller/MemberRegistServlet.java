package test_shopping.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import test_shopping.VO.Member;
import test_shopping.dao.MemberDao;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/memberRegist")
public class MemberRegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	
    public MemberRegistServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// post로 할때 이거 필요할듯
		request.setCharacterEncoding("UTF-8");
		
		// 파라미터 받기
		String custno_str = request.getParameter("custno");
		int custno = Integer.parseInt(custno_str);
		String custName = request.getParameter("custname");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String joindate = request.getParameter("joindate");
		String grade = request.getParameter("grade");
		String city = request.getParameter("city");
		
		// 유효성 검사
		
		// Member 객체 저장
		Member member = new Member();
		member.setCustno(custno);
		member.setCustname(custName);
		member.setPhone(phone);
		member.setAddress(address);
		member.setJoindate(joindate);
		member.setGrade(grade);
		member.setCity(city);
		
		// DB 저장
		MemberDao dao = new MemberDao();
		int result = dao.insert(member);
				
		if(result != 0) {
			// 데이터 삽입됨
			// 회원 조회 화면으로 이동
			response.sendRedirect("memberList");
		} else {
			// 데이터 삽입 안됨
			// 다시 해당 화면으로 리다이렉트
			response.sendRedirect("regist.jsp");
		}
		
		
		// doGet(request, response);
	}

}
