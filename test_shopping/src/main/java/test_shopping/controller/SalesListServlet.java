package test_shopping.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import test_shopping.VO.SalesDto;
import test_shopping.dao.SalesDao;

import java.io.IOException;
import java.util.List;

@WebServlet("/salesList")
public class SalesListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SalesListServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 데이터 가져오기
		SalesDao dao = new SalesDao();
		List<SalesDto> list = dao.getSalesList();
		
		// requset 저장 
		request.setAttribute("salesList", list);
		
		// 화면 전환
		request.getRequestDispatcher("salesList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
