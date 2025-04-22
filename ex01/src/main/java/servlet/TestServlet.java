package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/test")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TestServlet() {
        super();
		System.out.println("its me...");
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get 요청이 발생시 호출됨
		System.out.println("do Get...");
		
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<head>");
		out.print("<meta charset=\"UTF-8\">");
		out.print("<title> Insert title here </title>");
		out.print("</head>");
		out.print("<body>");
		out.print("<h1>GET 방식 결과 </h1>");
		out.print("<p>Servlet을 배우고 있습니다.</p>");
		out.print("</body>");
		out.print("</html>");
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// post 요청이 발생시 호출됨
		System.out.println("do Post...");
		
		// request 요청 받아서 name 저장
		String name = request.getParameter("name");
		
		// 화면에 name 표시
		// response.getWriter().append("name : " + name);
		
		// get 요청 호출
		doGet(request, response);
	}

}
// web application server - was
// 정적, 동적 서버
