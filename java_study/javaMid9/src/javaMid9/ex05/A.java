package javaMid9.ex05;

public class A {
	public void methodA1() throws ArithmeticException, ArrayIndexOutOfBoundsException, ClassNotFoundException {
		methodA2();
		Class.forName("java.lang.String");
	}

	public void methodA2() throws ArithmeticException, ArrayIndexOutOfBoundsException {
//		동시에 여러 예외타입을 보낼 수 있다.
		methodA3();
		int[] number = { 1, 5, 6 };
		System.out.println(number[2]);
	}

	public void methodA3() throws ArithmeticException {
//		methodA3 -> methodA2로 예외를 보낸다.(호출한 곳으로)
//		예외를 한곳에 모으는 개념. 관리에 용이하다.
//		try {
//			int a = 10 / 0;
//		} catch (ArithmeticException e) {
//			System.out.println(e.getMessage());
//		}
		int a = 10 / 4;

	}
}
