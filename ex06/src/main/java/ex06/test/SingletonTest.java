package ex06.test;

import ex06.dao.MemberDAO;
import ex06.dao.SingletonMemberDAO;

public class SingletonTest {

	public static void main(String[] args) {
		// 싱글톤을 이용한 A클래스 객체 생성
		A a_1 = A.getInstance();
		A a_2 = A.getInstance();
		System.out.println(a_1 == a_2);
	
		// 싱글톤이 아닌 B클래스 객체 비교
		B b_1 = new B();
		B b_2 = new B();
		System.out.println(b_1 == b_2);
			
		// ================================
		MemberDAO singleMember1 = SingletonMemberDAO.getInstance();
		MemberDAO singleMember2 = SingletonMemberDAO.getInstance();
		System.out.println(singleMember1 == singleMember2);
		singleMember1.selectAll();
		
	}

}
