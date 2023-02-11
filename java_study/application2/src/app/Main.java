package app;

import package1.A;
//import package2.B;
import package3.C;
import package4.D;

public class Main {
	public static void main(String[] args) {
		A a = new A();
		a.methodA();
//		B b = new B();
//		b.methodB();
		C c = new C();
		c.methodC();
		D d = new D();
		d.methodD();
	}
}
