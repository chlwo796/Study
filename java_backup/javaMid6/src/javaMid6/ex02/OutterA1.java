package javaMid6.ex02;

public class OutterA1 {
	OutterA1 outterA1 = new OutterA1();
	int a = 10;
	static int sa = 20;

	void m1() { // �ڽ��� method���� �ʵ� ��� ��� ����
		a = a + 1;
		sa = sa + 1;
	}

	static void sm1() {
//		a = a + 2;	// static �޼ҵ忡���� ����� �� ����. static method�� ���� �޸𸮿� �ö󰣴�.
//		�޸𸮿� �ö󰡴� ������ �ľ��Ѵ�.
//		a = a + 1;
		sa = sa + 1;
	}

	public OutterA1() { // �����ڿ����� �ڽ��� �ʵ带 ��� ����� �� �ִ�.

		a = a + 20;
		sa = sa + 10;
		m1();
		sm1();
	}

	class InnerA1 {
		int iaa = 20;
//		static int isa = 20;	// inner class ���� static�� ����� �� ����.
//		���ÿ� static�� �ö� �� ����. ������ class �� static�� �������ָ� static������ �޼ҵ带 ��� �� �� �ִ�.

		void methodInnerA() {
			a = a + 20;
			sa = sa + 10;
			m1();
			sm1(); // inner���� static�� ������ �� �ִ�.
		}

//		static void methodInnerAA() {
//
//		}
	}
}