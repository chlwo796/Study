package javaMid7.ex05;

public class Car {
//	����Ͻ� Ŭ���� - ������ ���α׷��� �ۼ��ϴ� �κ�
	private Tire tire1 = new Tire();
	private Tire tire2 = new Tire() {
//		Type name = new Type(){};
//		�͸�ü�� ����(�͸��� �ڽ�Ŭ������ ����)�Ͽ� ����� ����, bin folder�� Ȯ���غ���.(Car$1)
		@Override
		public void roll() {
			System.out.println("�͸� Tire1�� �������ϴ�.");
		}
	}; // }; �͸�Ŭ���� ����
	private Tire tire3 = new Tire() {
		@Override
		public void roll() {
			System.out.println("�̽���Ÿ�̾�");
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
				System.out.println("�͸� Tire2�� �������ϴ�.");
			}
		};
		tire.roll();

	}

	public void run3(Tire tire) {
		tire.roll();
	}
}
