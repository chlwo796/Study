package javaMid4.ex03;

public interface InConfig {
	void i1();	// 주로 추상메소드

//	상수 입력 가능

	static final double PI = 3.14;
	static final boolean OK = true;
	static final int COMPUTOR_PRICE = 2000000;
	static final int PRINTER_PRICE = 50000;

//	default method = 자바 1.8 이후 추가 아래 메소드들은 전부 {}블록을 사용할 수 있다.
	default void di1() {
//		interface지만 default method에서 블록을 사용해볼 수 있다.
//		overriding 불필요.
	}
	default int dd1() {
		return 0;
	}
//	static method
	static void sm() {
		
	}
//	private method
	private void pri() {
		
	}
}
