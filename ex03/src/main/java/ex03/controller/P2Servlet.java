package ex03.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/p2")
public class P2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		
		request.setAttribute("name", name);
		request.setAttribute("age", age);
		
		// dispatcher를 통한 화면 전환 - 이러면 request에 있는 데이터를 해당 jsp에서 받을수 있다
		// request.getRequestDispatcher("p2.jsp").forward(request, response);
		// redirect로 화면을 전환하면 request에 저장한 데이터를 해당 jsp에서 받을 수가 없다
		response.sendRedirect("p2.jsp");
	
	}

}
