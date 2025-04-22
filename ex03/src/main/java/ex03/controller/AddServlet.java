package ex03.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addResult")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String num1 = request.getParameter("num1");
		String num2 = request.getParameter("num2");
		String operator = request.getParameter("operator");

		int n1 = Integer.parseInt(num1);
		int n2 = Integer.parseInt(num2);		
		int result = 0;
		
		if(operator.equals("add")) {
			 result = n1 + n2;
		} else if(operator.equals("sub")) {
			result = n1 - n2;
		} else if(operator.equals("mul")) {
			result = n1 * n2;
		} else if(operator.equals("div")) {
			double result_temp = (double)n1 / n2;	
			result_temp = n1 / n2;
			
			result = n1/n2;
		}
		
		request.setAttribute("result", result);
		
		request.getRequestDispatcher("mathResult.jsp").forward(request, response);
	}

}
