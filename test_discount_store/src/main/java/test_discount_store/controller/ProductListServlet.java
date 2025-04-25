package test_discount_store.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import test_discount_store.VO.ProductListDto;
import test_discount_store.VO.ShopOrderListDto;
import test_discount_store.dao.OrderDao;
import test_discount_store.dao.ProductDao;

import java.io.IOException;
import java.util.List;

@WebServlet("/productList")
public class ProductListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProductListServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductDao dao = new ProductDao();
		List<ProductListDto> list = dao.selectProductListDto();
		
		// System.out.println(list);
		
		// request 저장
		request.setAttribute("productList", list);
		
		// 화면 전환
		request.getRequestDispatcher("productList.jsp").forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
