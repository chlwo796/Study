package javaMid4.ex11;

public class Main {
	public static void main(String[] args) {
		action(new B());
		action(new C());
	}

	private static void action(A a) {
		// TODO Auto-generated method stub
		a.method1();
		if (a instanceof C) {
			C c = (C) a;
			c.method2();
		}

	}
}