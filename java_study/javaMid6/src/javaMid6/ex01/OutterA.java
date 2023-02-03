package javaMid6.ex01;

public class OutterA {

	int a = 100;

	void methodA() {
		a = a + 200;
//		ia = ia +200; // inner에서 선언된 필드는 outter에서 사용할 수 없다.
//		methodInnerA(); // method도 마찬가지이다.

//		outter에서 instance화하여 inner field에 접근한다.

		InnerA ina = new InnerA();

		ina.ia = ina.ia + 100;
		ina.methodInnerA();
	}

	public OutterA() {
		// TODO Auto-generated constructor stub
	}

	class InnerA { // 상속관계가 아니더라도 outter class member들을 모두 사용할 수 있다.
		int ia = 100;

		void methodInnerA() {
			a = a + 400; // inner는 outter의 필드,메소드를 사용할 수 있다.
//			methodA();
			System.out.println(a);

		}

		public InnerA() {
			// TODO Auto-generated constructor stub
		}
	}
}