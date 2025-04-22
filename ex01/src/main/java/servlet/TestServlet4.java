package servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

// init과 destroy에 대해
// 서블릿의 생명주기에 대해
// 서블릿 주소는 다른 서블릿 주소와 중보깅 되면 안된다
@WebServlet("/test4")
public class TestServlet4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/*
    public TestServlet4() {
        super();
    }
    */

	public void init(ServletConfig config) throws ServletException {
		// 처음 서버에 서블릿주소가 접속할때 발동함
		System.out.println("init....");
	}

	public void destroy() {
		// 생성된 서블릿이 종료될때 발동
		System.out.println("destroy....");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("do Get....");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


}
