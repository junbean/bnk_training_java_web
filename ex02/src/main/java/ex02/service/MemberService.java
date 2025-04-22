package ex02.service;

import java.util.List;

import ex02.DAO.MemberDao;
import ex02.vo.MemberVO;

public class MemberService {
	MemberDao dao = new MemberDao();
	
	public void f() {
		// 파라미터로 받은 데이터 가지고 해볼만 한 것들
		// 데이터 유효성 검사
		
		// dao를 가져와서 이용해야 한다
		// dao.insert();
	}

	public void insert(MemberVO member) {
		// 파라미터로 받은 데이터 가지고 해볼만 한 것들
		// 데이터 유효성 검사
		
		// dao를 가져와서 이용해야 한다
		dao.insert(member);
	}
	
	
	public List<MemberVO> selectAll() {
		// DB에 요청
		List<MemberVO> list = dao.selectAll();
		
		return list;
	}
}
