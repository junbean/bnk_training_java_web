package test_java.service;

import java.util.List;

import test_java.VO.Board;
import test_java.dao.BoardDao;

public class BoardService {
	BoardDao dao = new BoardDao();

	public Board selectBoardByBno(int bno) {
		Board board = dao.selectOne(bno);
		return board;
	}
	
	public List<Board> selectAllBoard() {
		List<Board> list = dao.selectAll(); 
		return list;
	}
	
	public int insertBoard(Board board) {		
		int result = dao.insert(board);
		return result;
	}
	
	public int deleteBoardByBno(int bno) {
		int result = dao.delete(bno);
		return result;
	}
}
