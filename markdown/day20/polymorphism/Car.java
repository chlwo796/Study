package polymorphism;

public class Car {
	Tire tire1 = new Tire("앞왼쪽", 6);
	Tire tire2 = new Tire("앞오른쪽", 2);
	Tire tire3 = new Tire("뒤왼쪽", 3);
	Tire tire4 = new Tire("뒤오른쪽", 4);

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
