package javaMid7.ex05;

public class Car {
//	비즈니스 클래스 - 실제로 프로그램을 작성하는 부분
	private Tire tire1 = new Tire();
	private Tire tire2 = new Tire() {
//		Type name = new Type(){};
//		익명객체를 생성(익명의 자식클래스를 생성)하여 상속을 수행, bin folder를 확인해보자.(Car$1)
		@Override
		public void roll() {
			System.out.println("익명 Tire1이 굴러갑니다.");
		}
	}; // }; 익명클래스 종료
	private Tire tire3 = new Tire() {
		@Override
		public void roll() {
			System.out.println("미쉐린타이어");
		}
	};

	public void run1() {
		tire1.roll();
		tire2.roll();
		tire3.roll();

	}

	public void run2() {
		Tire tire = new Tire() {
			@Override
			public void roll() {
				System.out.println("익명 Tire2가 굴러갑니다.");
			}
		};
		tire.roll();

	}

	public void run3(Tire tire) {
		tire.roll();
	}
}
