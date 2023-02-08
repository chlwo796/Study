package javaMid9.ex07;

public class B {
	void methodB1() throws ClassNotFoundException, ArithmeticException {
		methodB2();
	}
	void methodB2() throws ClassNotFoundException, ArithmeticException{
		int a = 5/1;
		methodB3();
	}
	void methodB3() throws ClassNotFoundException{
		Class.forName("java.lang.String");
		methodB4();
	}
	void methodB4() {
		
	}
}
