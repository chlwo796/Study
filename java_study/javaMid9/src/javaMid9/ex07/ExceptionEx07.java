package javaMid9.ex07;

public class ExceptionEx07 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		try {
			B b = new B();
			b.methodB1();
		} catch (ArithmeticException | ClassNotFoundException e) {
			if (e instanceof ArithmeticException) {
				System.out.println("ArithmeticException");
				System.out.println(e.getMessage());
				e.printStackTrace();
			} else if (e instanceof ClassNotFoundException) {
				System.out.println("ClassNotFoundException");
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		} catch (Exception e) {
			System.out.println("예외발생");
		}
	}

}
