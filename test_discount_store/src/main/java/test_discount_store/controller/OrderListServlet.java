package test_discount_store.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import test_discount_store.VO.OrderListDto;
import test_discount_store.dao.OrderDao;

import java.io.IOException;
import java.util.List;

@WebServlet("/orderList")
public class OrderListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public OrderListServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 객체 생성후 데이터 조회
		OrderDao dao = new OrderDao();
		List<OrderListDto> list = dao.selectOrderListDto();
		
		//System.out.println(list);
		
		// request 저장
		request.setAttribute("orderList", list);
		
		// 화면 전환
		request.getRequestDispatcher("orderList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
