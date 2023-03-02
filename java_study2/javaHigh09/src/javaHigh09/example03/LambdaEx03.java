package javaHigh09.example03;

public class LambdaEx03 {
	public static void main(String[] args) {
		Person person = new Person();
		// 익명구현객체 람다식으로 생략 과정
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
		// 리턴타입, 매개변수 동일해야 사용 가능
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
		
		// 메소드 참조 표현 = 람다식에서 입력이 되었는데 어떤 메소드 1개만 실행하면 되는 경우에 사용 가능
	}
}
