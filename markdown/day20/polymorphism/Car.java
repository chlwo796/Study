package polymorphism;

public class Car {
	Tire tire1 = new Tire("�տ���", 6);
	Tire tire2 = new Tire("�տ�����", 2);
	Tire tire3 = new Tire("�ڿ���", 3);
	Tire tire4 = new Tire("�ڿ�����", 4);

	int run() {
		System.out.println("run");
		if (tire1.roll() == false) {
			stop();
			return 1;
		}
		if (tire2.roll() == false) {
			stop();
			return 2;
		}
		if (tire3.roll() == false) {
			stop();
			return 3;
		}
		if (tire4.roll() == false) {
			stop();
			return 4;
		}
		return 0;
	}

	void stop() {
		System.out.println("stop");
	}
}
