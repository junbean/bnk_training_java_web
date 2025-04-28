package ex06.test;

public class A {
	private static A instance = new A();
	
	private A() {}
	
	public static A getInstance() {
		return instance;
	}
}



/*
public class A {
	private A instance = new A();
	
	private A() {}
	
	public A getInstance() {
		return instance;
	}
}
//이거 싱글톤이 될거 같지만 이건 안된다
*/

