package ex04;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/test")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//String name = request.getParameter("name");
			System.out.println("doget---------------");

			// response.sendRedirect("jstl_test.jsp");
			request.getRequestDispatcher("jstl_test_page.jsp").forward(request, response);
	}

}
