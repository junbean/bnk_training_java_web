package test_java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import test_java.VO.Board;

public class BoardDao {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public BoardDao() {
		conn = DBConn.getConnection();
	}
	
	public Board selectOne(int bno) {
		String query = "SELECT * FROM test_board WHERE bno=?";
		Board board = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bno);
			
			rs = pstmt.executeQuery();
			rs.next();
			
			board = new Board();
			board.setBno(rs.getInt("bno"));
			board.setTitle(rs.getString("title"));
			board.setContent(rs.getString("content"));
			board.setWriter(rs.getString("writer"));
			board.setRegdate(rs.getDate("regdate"));
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return board;
	}
	
	public List<Board> selectAll() {
		String query = "SELECT * FROM test_board ORDER BY bno ASC";
		List<Board> list = new ArrayList<>();
		
		try {
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Board board = new Board();
				
				board.setBno(rs.getInt("bno"));
				board.setTitle(rs.getString("title"));
				board.setContent(rs.getString("content"));
				board.setWriter(rs.getString("writer"));
				board.setRegdate(rs.getDate("regdate"));
				
				list.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public int insert(Board board) {
		String query = "INSERT INTO test_board(bno, title, content, writer) VALUES(seq_test_board.NEXTVAL, ?, ?, ?)";
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getContent());
			pstmt.setString(3, board.getWriter());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public int delete(int bno) {
		String query = "DELETE test_table WHERE bno=?";
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bno);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	
}
