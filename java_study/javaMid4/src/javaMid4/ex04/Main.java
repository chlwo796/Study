package javaMid4.ex04;

public class Main {

	public static void main(String[] args) {
//		객체생성해보기
//		A a = new A(); // interface는 객체생성할 수 없다.
		B b = new B();
		C c = new C();
		D d = new D();
		E e = new E();

//		다형성

		B b1 = new D(); // 부모타입으로 자식의 주소를 참조한다. 상속관계 파악
		C c1 = new E(); // 부모타입으로 자식의 주소를 참조한다.

//		interface A는 관계맺은 객체를 전부 참조할 수 있다.

		A a1 = new B();
		A a2 = new C();
		A a3 = new D();

//		자식과 부모는 각각 한 클래스만 가질 수 있다. 부모가 다름
//		B b2 = new E(); // 오류의 원인 파악

//		a1에서 C클래스의 메소드 호출하기 가능할까? downcasting
//		각 클래스간 타입변환
		C c2 = (C) a2;
		c2.c1();

//		A를 통해서 BCDE 메소드 호출하기.
//		a4 참조변수에서 E클래스에 메소드를 호출
		A a4 = new E();

		E e4 = (E) a4;
		e4.printE();
		
//		overriding으로 해보기
//		interface A에 추상메소드 생성, B와 C에서 오버라이딩해주고 각각 D,E에서 오버라이딩한다.
		a4.printAll();
	}

}
