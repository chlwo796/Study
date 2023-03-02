package javaHigh09.example02;

public class LambdaEx02 {
	public static void main(String[] args) {
		InterfaceEx01 i1 = new InterfaceEx01() {

			@Override
			public void cc() {
				System.out.println(3000);
			}
		};
		i1.cc();
		// 한줄이면 {}중괄호 생략 가능
		// 추상메소드가 2개 이상이라면(함수적인터페이스가 아니라면) 람다식 불가
		InterfaceEx01 i2 = () -> {
			System.out.println(2000);
			System.out.println(1000);
		};
		i2.cc();

		InterfaceEx02 i3 = new InterfaceEx02() {

			@Override
			public void a(int a1, double d1) {
				System.out.println(a1);
				System.out.println(d1);
			}
		};
		i3.a(30, 40);
		// 매개변수가 있는 추상메소드를 가지고 있는 함수형 인터페이스의 경우, 타입을 생략하고 작성하는것이 일반적이다.
		InterfaceEx02 i4 = (a1, d1) -> System.out.println(a1 + d1);
		i4.a(20, 4);
		int value1 = 0;
		int value2 = 0;
		InterfaceEx03 i5 = new InterfaceEx03() {

			@Override
			public int bb(int a, int b, boolean c) {
				if (c) {
					return a;
				} else {
					return b;
				}
			}
		};
		value1 = i5.bb(30, 10, true);
		System.out.println(value1);
		InterfaceEx03 i6 = (a, b, c) -> {
			if (c) {
				return b;
			} else {
				return a;
			}
		};
		value2 = i6.bb(20, 30, true);
		System.out.println(value2);
	}
}