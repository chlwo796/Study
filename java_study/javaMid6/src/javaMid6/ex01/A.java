package javaMid6.ex01;

public class A {
//	chap09.클래스 중첩선언
//	멤버클래스 실습
	class B {
		public B() {
			System.out.println("B클래스의 기본생성자");
		}
		void methodB() {
			System.out.println("B-method");
		}
	};

//	B b = new B(); //필드에서 선언 가능

	public A() {
		System.out.println("A클래스의 기본생성자");
		B b = new B(); // 기본생성자 안에서 객체화 가능
	}

	void method() { // 메소드 안에서도 객체화 가능
		System.out.println("A-method");
		B b = new B();
	}
}
