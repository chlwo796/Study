package application02;

import package01.A;
//import package02.B;
//import package04.D;
//import package05.E;
//import package03.C; // module01���� package03�� exports���� �ʾҴ�.

public class Main {
	public static void main(String[] args) {
		A a = new A();
		a.methodA();
//		B b = new B();
//		b.methodB();
//		C c = new C();
//		D d = new D();
//		E e = new E();
	}
}