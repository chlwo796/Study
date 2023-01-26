package javaMid1.ch07;

public class D {

	int a;

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public D() {
		this(100);	// 자신의 다른 메소드 호출(메소드오버로딩), 반드시 첫째줄
		System.out.println("D클래스의 기본생성자");
	}
	public D(int a) {
		this.a = a;
		System.out.println("D클래스의 명시적생성자");
	}
}