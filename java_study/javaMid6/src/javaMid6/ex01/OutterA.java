package javaMid6.ex01;

public class OutterA {

	int a = 100;

	void methodA() {
		a = a + 200;
//		ia = ia +200; // inner���� ����� �ʵ�� outter���� ����� �� ����.
//		methodInnerA(); // method�� ���������̴�.

//		outter���� instanceȭ�Ͽ� inner field�� �����Ѵ�.

		InnerA ina = new InnerA();

		ina.ia = ina.ia + 100;
		ina.methodInnerA();
	}

	public OutterA() {
		// TODO Auto-generated constructor stub
	}

	class InnerA { // ��Ӱ��谡 �ƴϴ��� outter class member���� ��� ����� �� �ִ�.
		int ia = 100;

		void methodInnerA() {
			a = a + 400; // inner�� outter�� �ʵ�,�޼ҵ带 ����� �� �ִ�.
//			methodA();
			System.out.println(a);

		}

		public InnerA() {
			// TODO Auto-generated constructor stub
		}
	}
}