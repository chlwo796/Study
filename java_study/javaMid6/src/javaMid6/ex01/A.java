package javaMid6.ex01;

public class A {
//	chap09.Ŭ���� ��ø����
//	���Ŭ���� �ǽ�
	class B {
		public B() {
			System.out.println("BŬ������ �⺻������");
		}
		void methodB() {
			System.out.println("B-method");
		}
	};

//	B b = new B(); //�ʵ忡�� ���� ����

	public A() {
		System.out.println("AŬ������ �⺻������");
		B b = new B(); // �⺻������ �ȿ��� ��üȭ ����
	}

	void method() { // �޼ҵ� �ȿ����� ��üȭ ����
		System.out.println("A-method");
		B b = new B();
	}
}
