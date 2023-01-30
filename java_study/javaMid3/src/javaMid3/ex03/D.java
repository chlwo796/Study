package javaMid3.ex03;

public class D {
	public static void main(String[] args) {
		A a = new A();
		B b = new B();
		C c = new C();

//		a.sum(10);	// 겹치면 값이 변한다...왜지..?
//		a.minus(10);
		a.printA();
		System.out.println(a.sum(10) + " " + a.minus(10));

		b.sum(100);
		b.printB();

		c.sum(200);
		c.minus(200);
		c.곱하기(20); // int 의 최대값을 초과하여 최소값부터 다시 연산된다. 타입변경
		c.printC();
	}
}
