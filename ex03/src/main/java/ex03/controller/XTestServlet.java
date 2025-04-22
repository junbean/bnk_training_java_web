package ex03.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/xtest")
public class XTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public XTestServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String num = "1";
		int n = Integer.parseInt(num);	// 숫자형 문자열이면 정수로 변환
		
		String grade = "A";
		request.setAttribute("grade", grade);
		request.getRequestDispatcher("result.jsp").forward(request, response);
	}

}
