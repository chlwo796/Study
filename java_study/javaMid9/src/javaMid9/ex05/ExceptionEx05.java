package javaMid9.ex05;

public class ExceptionEx05 {
	public static void main(String[] args) {
		try {
			A a = new A();
			a.methodA1();
		} catch (ArithmeticException | ArrayIndexOutOfBoundsException | ClassNotFoundException e) {
			if (e instanceof ArithmeticException) {
				System.out.println("에러" + e.getMessage());
			} else if (e instanceof ArrayIndexOutOfBoundsException) {
				System.out.println("에러" + e.getMessage());
			} else if (e instanceof ClassNotFoundException) {
				System.out.println("에러" + e.getMessage());
			}
		} catch (Exception e) {
			System.out.println("모든예외");
		}finally {
			System.out.println("예외와 상관없이 처리해야 하는 코드");
		}
	}
}
