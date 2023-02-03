package javaMid4.ex06;

public class CarMain {
	public static void main(String[] args) {
		Car car = new Car();
		
		car.run();
		car.tire1 = new HankookTire();
		car.tire2 = new HankookTire();
		
	}
}
