package javaMid9.ex05;

public class A {
	public void methodA1() throws ArithmeticException, ArrayIndexOutOfBoundsException, ClassNotFoundException {
		methodA2();
		Class.forName("java.lang.String");
	}

	public void methodA2() throws ArithmeticException, ArrayIndexOutOfBoundsException {
//		���ÿ� ���� ����Ÿ���� ���� �� �ִ�.
		methodA3();
		int[] number = { 1, 5, 6 };
		System.out.println(number[2]);
	}

	public void methodA3() throws ArithmeticException {
//		methodA3 -> methodA2�� ���ܸ� ������.(ȣ���� ������)
//		���ܸ� �Ѱ��� ������ ����. ������ �����ϴ�.
//		try {
//			int a = 10 / 0;
//		} catch (ArithmeticException e) {
//			System.out.println(e.getMessage());
//		}
		int a = 10 / 4;

	}
}
