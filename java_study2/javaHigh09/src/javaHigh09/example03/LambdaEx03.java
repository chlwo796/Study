package javaHigh09.example03;

public class LambdaEx03 {
	public static void main(String[] args) {
		Person person = new Person();
		// �͸�����ü ���ٽ����� ���� ����
		// ����Ÿ��, �Ű����� �����ؾ� ��� ����
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
		// instance�޼ҵ� ���ٹ��
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
