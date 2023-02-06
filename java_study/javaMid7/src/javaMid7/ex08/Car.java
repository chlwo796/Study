package javaMid7.ex08;

public class Car {
	Tire tire1 = new Tire() {
		@Override
		public void roll() {
			System.out.println("일반타이어가 달립니다.");

		}
	};
	
	Tire tire2 = new Tire() {
		@Override
		public void roll() {
		System.out.println("금호타이어가 달립니다.");	
		}
	};
}