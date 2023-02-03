package javaMid6.ex01;

public class AMain {
	public static void main(String[] args) {
		A a = new A();
		a.method();
		
//		B클래스를 다른 클래스에서 사용하고싶다면?
//		외부클래스를 객체화 하고 B클래스를 객체화한다.(.)으로 연결
		
		A.B b = a.new B();
		b.methodB();
	}
}
