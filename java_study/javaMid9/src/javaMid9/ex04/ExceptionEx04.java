package javaMid9.ex04;

public class ExceptionEx04 {
	public static void main(String[] args) {
		int k = 0;
		int a = 10;
		try {
			Class.forName("java.util.String");
			int b = 10 / k;
			int[] number = { 12, 30, 40, 50, 10 };
			System.out.println(number[6]);
		} catch (ArithmeticException e) {
			if (k == 0) {
				k = 5;
				System.out.println(a / k);
			}
			System.out.println(e.getMessage());
			System.out.println("���ڿ���");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("��� ���� �ֻ��� Ŭ���� Exception ��� ���ܸ� �� �޴´�.");
		} finally {
			System.out.println("��������");
		}
	}
}
