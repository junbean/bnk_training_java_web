package test_java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import test_java.VO.Member;

public class MemberDao {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public MemberDao() {
		conn = DBConn.getConnection();
	}
	
	public int insert(Member member) {
		String query = "INSERT INTO test_member VALUES(?,?,?,?)";
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPw());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getGrade());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public Member selectOne(String id) {
		String query = "SELECT * FROM test_member where id=?";
		Member member = new Member();
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			
			// 쿼리 실행
			rs = pstmt.executeQuery();
			
			rs.next();
			
			member.setId(rs.getString("id"));
			member.setPw(rs.getString("pw"));
			member.setName(rs.getString("name"));
			member.setGrade(rs.getString("grade"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return member;
	}

	public Member selectOne(String id, String pw) {
		String query = "SELECT * FROM test_member where id=? AND pw=?";
		Member member = new Member();
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);			
			
			// 쿼리 실행
			rs = pstmt.executeQuery();
			
			rs.next();
			
			member.setId(rs.getString("id"));
			member.setPw(rs.getString("pw"));
			member.setName(rs.getString("name"));
			member.setGrade(rs.getString("grade"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return member;
	}
	
	/*
	public List<Member> selectAll() {
		String query = "SELECT * FROM test_member";
		List<Member> list = new ArrayList<>();
		
		try {
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Member member = new Member();
				
				member.setId(rs.getString("id"));
				member.setPw(rs.getString("pw"));
				member.setName(rs.getString("name"));
				member.setGrade(rs.getString("grade"));
				
				list.add(member);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	*/
	
	
	
}
