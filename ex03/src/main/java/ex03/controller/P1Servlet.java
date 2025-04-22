package ex03.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/p1")
public class P1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// p1.jsp 파일 자체로 이동 -> 주소명에는 p1.jsp로 표시
		// response.sendRedirect("p1.jsp");
		
		// 현재 주소를 바탕으로 p1.jsp 파일을 표시 -> 주소명에는 p1으로 유지된다
		request.getRequestDispatcher("p1.jsp").forward(request, response);
	}


}
