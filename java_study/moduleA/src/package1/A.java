package package1;

import package2.B;
import package3.C;

public class A {
	public void methodA() {
		B b = new B();
		b.methodB();
	}

	public C getC() {
		C c = new C();
		return c;
	}
}
