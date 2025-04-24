package test_shopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import test_shopping.VO.SalesDto;

public class SalesDao {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public SalesDao() {
		conn = DBConn.getConnection();
	}
	
	public List<SalesDto> getSalesList() {
		String query =  "SELECT custno, custname, grade, SUM(pcost * amount) as total FROM member_tbl_02 NATURAL JOIN money_tbl_02 group BY custno, custname, grade order BY SUM(pcost * amount) DESC";
		List<SalesDto> list = new ArrayList<>();
		
		try {
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				SalesDto sales = new SalesDto();
				sales.setCustno(rs.getInt("custno"));
				sales.setCustname(rs.getString("custname"));
				sales.setGrade(rs.getString("grade"));
				sales.setTotal(rs.getInt("total"));
				
				list.add(sales);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
}
