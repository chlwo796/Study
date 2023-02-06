package javaBasic4.day01;

public class FinalEx01 {
//	항상그대로인 수 = 상수, 대문자가 관례
//	값을 꼭 지정해줘야 한다.
	static final double PI = 3.14;

	public static void main(String[] args) {
//		Final - 끝, 마지막

		int a = 10;
		a = a + 100;

		final int b = 100; // b변수는 100 고정
//		b = b + 200;	// 다른 값 대입 시 에러발생

		System.out.println(Math.PI);
	}
}
