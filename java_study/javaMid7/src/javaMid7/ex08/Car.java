package javaMid7.ex08;

public class Car {
	Tire tire1 = new Tire() {
		@Override
		public void roll() {
			System.out.println("�Ϲ�Ÿ�̾ �޸��ϴ�.");

		}
	};
	
	Tire tire2 = new Tire() {
		@Override
		public void roll() {
		System.out.println("��ȣŸ�̾ �޸��ϴ�.");	
		}
	};
}