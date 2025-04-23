package test_java.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import test_java.VO.Member;
import test_java.dao.MemberDao;
import test_java.service.MemberService;

import java.io.IOException;

import org.apache.catalina.Session;

@WebServlet("/regist")
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    MemberService service = new MemberService();
	
    public RegistServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 파라미터 받기
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String grade = "일반";	// 서블릿에서 직접 지정
		
		// member로 묶어주기
		Member member = new Member();
		member.setId(id);
		member.setPw(pw);
		member.setName(name);
		member.setGrade(grade);
		
		// == 작업 수행 ==
		// 데이터 삽입
		MemberDao dao = new MemberDao();
		int result  = dao.insert(member);
		
		if(result == 1) {
			// 삽입 데이터 가져오기
			Member get_member = service.selectOne(id);
			
			 // 세션 객체 가져오기
		    HttpSession session = request.getSession();
			session.setAttribute("member", get_member);

			System.out.println("회원가입에 성공했습니다! 회원 정보 결과 페이지로 이동합니다.");
			request.getRequestDispatcher("registResult.jsp").forward(request, response);
		} else {
			System.out.println("회원가입에 실패했습니다... 회원등록 페이지로 돌아갑니다...");
			response.sendRedirect("regist.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
/*

<li>아이디 :  <%= member.getId() %> </li>
<li>패스워드 : <%= member.getPw() %></li>
<li>이름 : <%= member.getName() %></li>
<li>등급 : <%= member.getGrade() %></li>

*/
