package ex06.test;

import ex06.dao.DBconnPool;

public class DBconnPoolTest {

	public static void main(String[] args) {
		DBconnPool dbp = new DBconnPool();
		
		dbp.close();
	}

}
