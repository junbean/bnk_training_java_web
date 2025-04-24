package test_shopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import test_shopping.VO.Member;

public class MemberDao {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public MemberDao() {
		conn = DBConn.getConnection();
	}
	
	public List<Member> selectAll() {
		String query = "SELECT * FROM member_tbl_02";
		List<Member> list = new ArrayList<>();
		
		try {
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Member member = new Member();
				member.setCustno(rs.getInt("custno"));
				member.setCustname(rs.getString("custname"));
				member.setPhone(rs.getString("phone"));
				member.setAddress(rs.getString("address"));
				member.setJoindate(rs.getString("joindate"));
				member.setGrade(rs.getString("grade"));
				member.setCity(rs.getString("city"));
				
				list.add(member);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public Member selectOne(int custno) {
		String query = "SELECT * FROM member_tbl_02 WHERE custno=?";
		Member member = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, custno);
			
			rs = pstmt.executeQuery();
			rs.next();
			
			member = new Member();
			member.setCustno(rs.getInt("custno"));
			member.setCustname(rs.getString("custname"));
			member.setPhone(rs.getString("phone"));
			member.setAddress(rs.getString("address"));
			member.setJoindate(rs.getString("joindate"));
			member.setGrade(rs.getString("grade"));
			member.setCity(rs.getString("city"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return member;
	}
	
	
	
	public int insert(Member member) {
		String query = "INSERT INTO member_tbl_02 VALUES(?, ?, ?, ?, ?, ?, ?)";
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, member.getCustno());
			pstmt.setString(2, member.getCustname());
			pstmt.setString(3, member.getPhone());
			pstmt.setString(4, member.getAddress());
			pstmt.setString(5, member.getJoindate());
			pstmt.setString(6, member.getGrade());
			pstmt.setString(7, member.getCity());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public int update(Member member, int org_custno) {
		String query = "UPDATE member_tbl_02 SET custno=?, custname=?, phone=?, address=?, joindate=?, grade=?, city=?  WHERE custno=?";
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, member.getCustno());
			pstmt.setString(2, member.getCustname());
			pstmt.setString(3, member.getPhone());
			pstmt.setString(4, member.getAddress());
			pstmt.setString(5, member.getJoindate());
			pstmt.setString(6, member.getGrade());
			pstmt.setString(7, member.getCity());
			pstmt.setInt(8, org_custno);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
}

