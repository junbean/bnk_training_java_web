package test_discount_store.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import test_discount_store.VO.Product;
import test_discount_store.VO.Shop;
import test_discount_store.dao.OrderDao;
import test_discount_store.dao.ProductDao;
import test_discount_store.dao.ShopDao;

import java.io.IOException;
import java.util.List;

@WebServlet("/orderRegistPage")
public class OrderRegistPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public OrderRegistPageServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//객체 생성 및 데이터 가져오기
		// 주문 점포 
		ShopDao dao_shop = new ShopDao();
		List<Shop> list_shop = dao_shop.selectAll();
		//List<String> list_shop = dao_shop.selectAllNo();
		
		// 제품 코드
		ProductDao dao_product = new ProductDao();
		List<Product> list_product = dao_product.selectAll();
		
		// request 저장
		request.setAttribute("listShop", list_shop);	// 점포 리스트
		request.setAttribute("listProduct", list_product);	// 제품 리스트
		
		request.getRequestDispatcher("orderRegist.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
