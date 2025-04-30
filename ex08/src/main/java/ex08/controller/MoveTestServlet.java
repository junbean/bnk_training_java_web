package ex08.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

// 프론트 컨트롤러
@WebServlet("/")
public class MoveTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MoveTestServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();			// URI를 가져옴 -> /ex08/a
		String conPath = request.getContextPath();		// CONTEXT를 가져옴 -> /ex08
		String com = uri.substring(conPath.length());	// 실제 해당 경로의 URI 값 -> /a
		
		System.out.println(uri);
		System.out.println(conPath);
		System.out.println(com);
		
		if(com.equals("/a") || com.equals("/")) {
			request.getRequestDispatcher("a.jsp").forward(request, response);
		} else if(com.equals("/b")) {
			response.sendRedirect("b.jsp");
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
/*

주의
	만약 webapp에 index.jsp가 있다면 
	기본 / 경로는 index.jsp를 향하기 때문에 
	uri를 /로 설정했다면 현재 서블릿을 경유하지 않고 
	바로 index.jsp로 향할수 있다 
	만약 현재 서블릿으로 향하게 하려면 index.jsp를 없애야 함

*/