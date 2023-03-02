package javaHigh09.example01;

public class LambdaEx01 {
	public static void main(String[] args) {
		// 기본 방법
		CalculImpl c1 = new CalculImpl();
		c1.c();

		// 방법2 = 익명구현객체

		Calculable c2 = new Calculable() {

			@Override
			public void c() {
				System.out.println("익명구현객체");

			}
		};
		c2.c();

		// 방법3 람다식
		Calculable c3 = () -> System.out.println("람다식표현");
		c3.c();
	}
}