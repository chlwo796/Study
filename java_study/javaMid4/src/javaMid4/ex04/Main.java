package javaMid4.ex04;

public class Main {

	public static void main(String[] args) {
//		��ü�����غ���
//		A a = new A(); // interface�� ��ü������ �� ����.
		B b = new B();
		C c = new C();
		D d = new D();
		E e = new E();

//		������

		B b1 = new D(); // �θ�Ÿ������ �ڽ��� �ּҸ� �����Ѵ�. ��Ӱ��� �ľ�
		C c1 = new E(); // �θ�Ÿ������ �ڽ��� �ּҸ� �����Ѵ�.

//		interface A�� ������� ��ü�� ���� ������ �� �ִ�.

		A a1 = new B();
		A a2 = new C();
		A a3 = new D();

//		�ڽİ� �θ�� ���� �� Ŭ������ ���� �� �ִ�. �θ� �ٸ�
//		B b2 = new E(); // ������ ���� �ľ�

//		a1���� CŬ������ �޼ҵ� ȣ���ϱ� �����ұ�? downcasting
//		�� Ŭ������ Ÿ�Ժ�ȯ
		C c2 = (C) a2;
		c2.c1();

//		A�� ���ؼ� BCDE �޼ҵ� ȣ���ϱ�.
//		a4 ������������ EŬ������ �޼ҵ带 ȣ��
		A a4 = new E();

		E e4 = (E) a4;
		e4.printE();
		
//		overriding���� �غ���
//		interface A�� �߻�޼ҵ� ����, B�� C���� �������̵����ְ� ���� D,E���� �������̵��Ѵ�.
		a4.printAll();
	}

}
