package test_java.service;

import test_java.VO.Member;
import test_java.dao.MemberDao;

public class MemberService {
	MemberDao dao = new MemberDao();
	
	public int insert(Member member) {
		int result = dao.insert(member);
		
		if(result != 0) {
			System.out.println("회원가입이 성공적으로 이루어졌습니다.");
		} else {
			System.out.println("회원가입에 실패했습니다.");
		}
		
		return result;
	}
	
	public Member selectOne(String id) {
		Member member = dao.selectOne(id);
		return member;
	}

	/*
	public List<Member> selectAll() {
		List<Member> list = dao.selectAll();
		
		return list;
	}
	*/
}
