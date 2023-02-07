package javaMid8.ex01;

public class A {

	int a;
	static int sa;

	void methodA() {
		class SB{
			void methodSB() {
				a = a +10;
				sa = sa + 5;
				smethodA();
			}
			
		}
	}

	static void smethodA() {

	}

	static class B {

	}

	class C {
		void methodC() {
			sa = sa + 20;
		}
	}
}