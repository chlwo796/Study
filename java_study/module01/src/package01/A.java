package package01;

import package02.B;
import package03.C;

public class A {
	public void methodA() {
		System.out.println("methodA");
		B b = new B();
		b.methodB();

	}

	public C getC() {
		C c = new C();
		return c;
	}
}