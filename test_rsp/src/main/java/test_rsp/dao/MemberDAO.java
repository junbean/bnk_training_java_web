package test_rsp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import test_rsp.model.Member;

public class MemberDAO {


	public Member selectOne(String id, String pw) {
		Member member = new Member();
		String query = "SELECT * FROM rsp_member where id=? AND pw=?";
		
		try (
			Connection conn = DBUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
		) {
			// 파라미터 설정
	        pstmt.setString(1, id);
	        pstmt.setString(2, pw);
	        
	        // 쿼리 실행 및 ResultSet 생성
	        try (ResultSet rs = pstmt.executeQuery()) {
	            
	        	// 결과가 있는지 확인 후 처리
	            if (rs.next()) {
	                member = new Member();  // 결과가 있을 때만 객체 생성
	                member.setId(rs.getString("id"));
	                member.setPw(rs.getString("pw"));  // 컬럼명이 pw인지 ps인지 확인 필요
	                member.setName(rs.getString("name"));
	            }
	        }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return member;
	}

	
	public int insert(Member member) {
		int result = 0;
		String query = "INSERT INTO rsp_member VALUES(?, ?, ?)";
		
		try (
			Connection conn = DBUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
		) {
			// 파라미터 설정
	        pstmt.setString(1, member.getId());
	        pstmt.setString(2, member.getPw());
	        pstmt.setString(3, member.getName());
	        
	        // INSERT 실행 (executeUpdate 사용)
	        result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	    return result;
	}
}
