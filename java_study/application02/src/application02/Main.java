package application02;

import package01.A;
//import package02.B;
//import package04.D;
//import package05.E;
//import package03.C; // module01에서 package03을 exports하지 않았다.

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