package ex06.dao;


public class SingletonMemberDAO {
	private static MemberDAO instance = new MemberDAO();
	
	private SingletonMemberDAO() {}
	
	public static MemberDAO getInstance() {
		return instance;
	}

}
