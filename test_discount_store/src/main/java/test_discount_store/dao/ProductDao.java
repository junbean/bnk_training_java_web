package test_discount_store.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import test_discount_store.VO.Order;
import test_discount_store.VO.OrderListDto;
import test_discount_store.VO.Product;
import test_discount_store.VO.ProductListDto;

public class ProductDao {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public ProductDao() {
		conn = DBConn.getConnection();
	}
	
	public List<Product> selectAll() {
		String query = "SELECT * FROM TBL_PRODUCT_202101";
		List<Product> list = new ArrayList<>();
	
		try {
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Product product = new Product();
				product.setPcode(rs.getString("pcode"));
				product.setPname(rs.getString("pname"));
				product.setCost(rs.getInt("cost"));
				list.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<String> selectAllCode() {
		String query = "SELECT pcode FROM TBL_PRODUCT_202101";
		List<String> list = new ArrayList<>();
	
		try {
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				list.add(rs.getString("pcode"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<ProductListDto> selectProductListDto() {
		String query = "SELECT\r\n"
				+ "    pcode AS 제품코드, \r\n"
				+ "    pname AS 제품명, \r\n"
				+ "    cost AS 단가, \r\n"
				+ "    cost - (cost * 0.1) AS \"할인률(10%)\", \r\n"
				+ "    cost - (cost * 0.15) AS \"할인률(15%)\"\r\n"
				+ "FROM \r\n"
				+ "    TBL_PRODUCT_202101";
		List<ProductListDto> list = new ArrayList<>();
	
		try {
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ProductListDto dto = new ProductListDto();
				dto.setPcode(rs.getString("제품코드"));
				dto.setPname(rs.getString("제품명"));
				dto.setCost(rs.getInt("단가"));
				dto.setDiscount10(rs.getInt("할인률(10%)"));
				dto.setDiscount15(rs.getInt("할인률(15%)"));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
}
