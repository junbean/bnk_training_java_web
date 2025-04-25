package test_discount_store.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import test_discount_store.VO.OrderListDto;
import test_discount_store.VO.ShopOrderListDto;
import test_discount_store.dao.OrderDao;

import java.io.IOException;
import java.util.List;

@WebServlet("/shopOrderList")
public class ShopOrderListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ShopOrderListServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OrderDao dao = new OrderDao();
		List<ShopOrderListDto> list = dao.selectShopOrderListDto();
		
		System.out.println(list);
		
		// request 저장
		request.setAttribute("shopOrderList", list);
		
		// 화면 전환
		request.getRequestDispatcher("shopOrderList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
