package test_discount_store.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import test_discount_store.VO.Shop;

public class ShopDao {

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public ShopDao() {
		conn = DBConn.getConnection();
	}
	
	public List<Shop> selectAll() {
		String query = "SELECT * FROM TBL_SHOP_202101";
		List<Shop> list = new ArrayList<>();
	
		try {
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Shop shop = new Shop();
				shop.setShopno(rs.getString("shopno"));
				shop.setShopname(rs.getString("shopname"));
				shop.setDiscount(rs.getInt("discount"));
				
				list.add(shop);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<String> selectAllNo() {
		String query = "SELECT shopno FROM TBL_SHOP_202101";
		List<String> list = new ArrayList<>();
	
		try {
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				/*
				Shop shop = new Shop();
				shop.setShopno(rs.getString("shopno"));
				shop.setShopname(rs.getString("shopname"));
				shop.setDiscount(rs.getInt("discount"));
				 */
				
				list.add(rs.getString("shopno"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
}
