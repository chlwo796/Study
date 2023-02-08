package javaMid9.ex05;

public class ExceptionEx05 {
	public static void main(String[] args) {
		try {
			A a = new A();
			a.methodA1();
		} catch (ArithmeticException | ArrayIndexOutOfBoundsException | ClassNotFoundException e) {
			if (e instanceof ArithmeticException) {
				System.out.println("����" + e.getMessage());
			} else if (e instanceof ArrayIndexOutOfBoundsException) {
				System.out.println("����" + e.getMessage());
			} else if (e instanceof ClassNotFoundException) {
				System.out.println("����" + e.getMessage());
			}
		} catch (Exception e) {
			System.out.println("��翹��");
		}finally {
			System.out.println("���ܿ� ������� ó���ؾ� �ϴ� �ڵ�");
		}
	}
}
