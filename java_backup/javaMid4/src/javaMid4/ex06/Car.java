package javaMid4.ex06;

public class Car {
//	field�� ������ 
	
	Tire tire1 = new HankookTire();
	Tire tire2 = new KumhoTire();

	void run() {
		tire1.roll();
		tire2.roll();
	}
}
