package test_discount_store.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import test_discount_store.VO.Order;
import test_discount_store.dao.OrderDao;

import java.io.IOException;

@WebServlet("/orderRegist")
public class OrderRegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public OrderRegistServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String orderno = request.getParameter("orderno");
		String shopno = request.getParameter("shopno");
		String orderdate = request.getParameter("orderdate");
		String pcode = request.getParameter("pcode");
		String amount_str = request.getParameter("amount");
		int amount = Integer.parseInt(amount_str);
		
		// 파라미터 데이터 유효성 검사
		System.out.println(orderno + ", " + shopno + ", " + orderdate + ", " + pcode + ", " + amount);
		
		// Order 데이터로 묶기
		Order order = new Order();
		order.setOrderno(orderno);
		order.setShopno(shopno);
		order.setOrderdate(orderdate);
		order.setPcode(pcode);
		order.setAmount(amount);
		
		// 데이터 삽입
		OrderDao dao = new OrderDao();
		int result = dao.insert(order);
		
		if(result != 0) {
			// 주문 데이터 등록 성공
			System.out.println("주문 등록 성공!!");
			// 알림메세지 : 성공 출력
			response.sendRedirect("index.jsp");
		} else {
			// 주문 데이터 등록 실패
			response.sendRedirect("orderRegistPage");	
		}
	}
	
	

}
