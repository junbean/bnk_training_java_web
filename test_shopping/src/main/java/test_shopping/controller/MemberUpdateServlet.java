package test_shopping.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import test_shopping.VO.Member;
import test_shopping.dao.MemberDao;

import java.io.IOException;

@WebServlet("/memberUpdate")
public class MemberUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberUpdateServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 파라미터 받기
		String custno_str = request.getParameter("custno");
		int custno = Integer.parseInt(custno_str);
		String custName = request.getParameter("custname");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String joindate = request.getParameter("joindate");
		String grade = request.getParameter("grade");
		String city = request.getParameter("city");
		String custno_org_str = request.getParameter("custno_org");
		int custno_org = Integer.parseInt(custno_org_str);
		
		// member 객체 생성
		Member member = new Member();
		member.setCustno(custno);
		member.setCustname(custName);
		member.setPhone(phone);
		member.setAddress(address);
		member.setJoindate(joindate);
		member.setGrade(grade);
		member.setCity(city);
	
		// 데이터 수정
		MemberDao dao = new MemberDao();
		int result = dao.update(member, custno_org);
		
		if(result != 0) {
			// 데이터 수정 성공
			System.out.println("회원 데이터 수정 성공");
			response.sendRedirect("memberList");
		} else {
			// 데이터 수정 실패
			System.out.println("회원 데이터 수정 실패");
			response.sendRedirect("memberUpdatePage?custno=" + custno);
		}
		
		// doGet(request, response);
	}

}
