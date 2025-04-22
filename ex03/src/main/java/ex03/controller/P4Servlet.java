package ex03.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/p4")
public class P4Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 파라미터 받기
		String fruit = request.getParameter("fruit");
		String subject = request.getParameter("subject");
		String animal = request.getParameter("animal");
		String[] movies = request.getParameterValues("movies");
		
		// 데이터 저장
		request.setAttribute("fruit", fruit);
		request.setAttribute("subject", subject);
		request.setAttribute("animal", animal);
		request.setAttribute("movies", movies);
		
		// p4.jsp로 이동
		request.getRequestDispatcher("p4.jsp").forward(request, response);
	}


}
