package ex06.test;

import ex06.dao.MemberDAO;
import ex06.dao.SingletonMemberDAO;

public class DaoSingletonTest {

	public static void main(String[] args) {
		// ================================
		MemberDAO singleMember1 = SingletonMemberDAO.getInstance();
		MemberDAO singleMember2 = SingletonMemberDAO.getInstance();
		System.out.println(singleMember1 == singleMember2);
		singleMember1.selectAll();
	}

}
