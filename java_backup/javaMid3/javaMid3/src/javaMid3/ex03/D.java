package javaMid3.ex03;

public class D {
	public static void main(String[] args) {
		A a = new A();
		B b = new B();
		C c = new C();

//		a.sum(10);	// ��ġ�� ���� ���Ѵ�...����..?
//		a.minus(10);
		a.printA();
		System.out.println(a.sum(10) + " " + a.minus(10));

		b.sum(100);
		b.printB();

		c.sum(200);
		c.minus(200);
		c.���ϱ�(20); // int �� �ִ밪�� �ʰ��Ͽ� �ּҰ����� �ٽ� ����ȴ�. Ÿ�Ժ���
		c.printC();
	}
}
