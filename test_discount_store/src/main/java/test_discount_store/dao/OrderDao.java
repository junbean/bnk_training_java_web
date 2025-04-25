package test_discount_store.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import test_discount_store.VO.Order;
import test_discount_store.VO.OrderListDto;
import test_discount_store.VO.ShopOrderListDto;

public class OrderDao {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public OrderDao() {
		conn = DBConn.getConnection();
	}
	
	
	public List<OrderListDto> selectOrderListDto() {
		String query = "SELECT \r\n"
				+ "    o.SHOPNO AS 할인점코드, \r\n"
				+ "    s.SHOPNAME AS 점포명, \r\n"
				+ "    o.ORDERNO AS 주문번호, \r\n"
				+ "    o.ORDERDATE AS 주문일자, \r\n"
				+ "    o.PCODE AS 제품코드, \r\n"
				+ "    p.PNAME AS 제품명, \r\n"
				+ "    o.AMOUNT AS 주문수량, \r\n"
				+ "    p.COST AS 단가, \r\n"
				+ "    (p.COST * o.AMOUNT) AS 소비자가격, \r\n"
				+ "    (p.COST * o.AMOUNT) - (p.COST * o.AMOUNT * s.DISCOUNT/100) AS 할인가격\r\n"
				+ "FROM \r\n"
				+ "    TBL_ORDER_202101 o,\r\n"
				+ "    TBL_SHOP_202101 s,\r\n"
				+ "    TBL_PRODUCT_202101 p\r\n"
				+ "WHERE \r\n"
				+ "    o.SHOPNO = s.SHOPNO \r\n"
				+ "    AND o.PCODE = p.PCODE\r\n"
				+ "ORDER BY \r\n"
				+ "    o.ORDERNO";
		List<OrderListDto> list = new ArrayList<>();
	
		try {
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				OrderListDto dto = new OrderListDto();
				dto.setShopNo(rs.getString("할인점코드"));
				dto.setShopName(rs.getString("점포명"));
				dto.setOrderNo(rs.getString("주문번호"));
				dto.setOrderDate(rs.getString("주문일자"));
				dto.setPCode(rs.getString("제품코드"));
				dto.setPName(rs.getString("제품명"));
				dto.setAmount(rs.getInt("주문수량"));
				dto.setCost(rs.getInt("단가"));
				dto.setConsumerPrice(rs.getInt("소비자가격"));
				dto.setDiscountPrice(rs.getInt("할인가격"));
				
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<ShopOrderListDto> selectShopOrderListDto() {
		String query = "SELECT\r\n"
				+ "    o.SHOPNO AS 할인점코드, \r\n"
				+ "    o.pcode AS 제품코드,\r\n"
				+ "    p.pname AS 제품명,\r\n"
				+ "    SUM(o.amount) AS 주문총수량\r\n"
				+ "FROM \r\n"
				+ "    TBL_ORDER_202101 o, \r\n"
				+ "    TBL_PRODUCT_202101 p\r\n"
				+ "WHERE \r\n"
				+ "    o.pcode = p.pcode\r\n"
				+ "GROUP BY \r\n"
				+ "    o.SHOPNO, \r\n"
				+ "    o.pcode, \r\n"
				+ "    p.pname\r\n"
				+ "ORDER BY\r\n"
				+ "    o.SHOPNO";
		List<ShopOrderListDto> list = new ArrayList<>();
	
		try {
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ShopOrderListDto dto = new ShopOrderListDto();
				dto.setShopno(rs.getString("할인점코드"));
				dto.setPcode(rs.getString("제품코드"));
				dto.setPname(rs.getString("제품명"));
				dto.setTotalAmount(rs.getInt("주문총수량"));
				
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public int insert(Order order) {
		String query = "INSERT INTO TBL_ORDER_202101 VALUES(?, ?, ?, ?, ?)";
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, order.getOrderno());
			pstmt.setString(2, order.getShopno());
			pstmt.setString(3, order.getOrderdate());
			pstmt.setString(4, order.getPcode());
			pstmt.setInt(5, order.getAmount());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
