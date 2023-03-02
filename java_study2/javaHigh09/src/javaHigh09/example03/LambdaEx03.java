package javaHigh09.example03;

public class LambdaEx03 {
	public static void main(String[] args) {
		Person person = new Person();
		// 익명구현객체 람다식으로 생략 과정
		// 리턴타입, 매개변수 동일해야 사용 가능
		person.action(new InterfaceEx01() {

			@Override
			public double c(double x, double y) {
				// TODO Auto-generated method stub
				return Computer.staticMethod(x, y);
			}
		});

		person.action((double x, double y) -> {
			return Computer.staticMethod(x, y);
		});

		person.action((x, y) -> Computer.staticMethod(x, y));

		person.action(Computer::staticMethod);
		
//		person.action(Computer::voidMethod);
		// instance메소드 접근방법
		Computer computer = new Computer();
		person.action(new InterfaceEx01() {

			@Override
			public double c(double x, double y) {
				// TODO Auto-generated method stub
				return computer.instanceMethod(x, y);
			}
		});

		person.action((x, y) -> computer.instanceMethod(x, y));
		
		person.action(computer::instanceMethod);

	}
}
