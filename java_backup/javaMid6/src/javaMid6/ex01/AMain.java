package javaMid6.ex01;

public class AMain {
	public static void main(String[] args) {
		A a = new A();
		a.method();
		
//		BŬ������ �ٸ� Ŭ�������� ����ϰ�ʹٸ�?
//		�ܺ�Ŭ������ ��üȭ �ϰ� BŬ������ ��üȭ�Ѵ�.(.)���� ����
		
		A.B b = a.new B();
		b.methodB();
	}
}
