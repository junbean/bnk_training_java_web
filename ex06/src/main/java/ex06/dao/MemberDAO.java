package ex06.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ex06.dto.MemberDTO;

public class MemberDAO {
	
	/*
	public List<MemberDTO> selectAll() {
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		Connection conn = DBUtil.getConnection();	
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String query = "SELECT * FROM tbl_member";
		
		try {
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
		
			while(rs.next()) {
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				String grade = rs.getString("grade");
				MemberDTO member = new MemberDTO(id, pw, name, phone, grade);
				list.add(member);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn, pstmt, rs);			// 자원 해제	
		}
		return list;
	}
	*/
	
	public List<MemberDTO> selectAll() {
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		String query = "SELECT * FROM tbl_member";
		
		 try (
		        Connection conn = DBUtil.getConnection();
		        PreparedStatement pstmt = conn.prepareStatement(query);
		        ResultSet rs = pstmt.executeQuery();
		    ) {
			while(rs.next()) {
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				String grade = rs.getString("grade");
				MemberDTO member = new MemberDTO(id, pw, name, phone, grade);
				list.add(member);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public void insert() {
		String query = "INSERT INTO tbl_member VALUES(?, ?, ?, ?, ?)";
		
		
		Connection conn = DBUtil.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void update() {
		Connection conn = DBUtil.getConnection();	
		
		String query = "UPDATE tbl_member SET grade = ? WHERE id = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void delete() {
		Connection conn = DBUtil.getConnection();	
		
		String query = "DELETE FROM tbl_member WHERE id = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
