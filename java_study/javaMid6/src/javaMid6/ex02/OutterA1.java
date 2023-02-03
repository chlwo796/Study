package javaMid6.ex02;

public class OutterA1 {
	OutterA1 outterA1 = new OutterA1();
	int a = 10;
	static int sa = 20;

	void m1() { // 자신의 method에서 필드 모두 사용 가능
		a = a + 1;
		sa = sa + 1;
	}

	static void sm1() {
//		a = a + 2;	// static 메소드에서는 사용할 수 없다. static method가 먼저 메모리에 올라간다.
//		메모리에 올라가는 순서를 파악한다.
//		a = a + 1;
		sa = sa + 1;
	}

	public OutterA1() { // 생성자에서는 자신의 필드를 모두 사용할 수 있다.

		a = a + 20;
		sa = sa + 10;
		m1();
		sm1();
	}

	class InnerA1 {
		int iaa = 20;
//		static int isa = 20;	// inner class 에서 static은 사용할 수 없다.
//		동시에 static에 올라갈 수 없다. 하지만 class 에 static을 선언해주면 static변수나 메소드를 사용 할 수 있다.

		void methodInnerA() {
			a = a + 20;
			sa = sa + 10;
			m1();
			sm1(); // inner에서 static에 접근할 수 있다.
		}

//		static void methodInnerAA() {
//
//		}
	}
}