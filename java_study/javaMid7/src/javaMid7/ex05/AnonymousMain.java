package javaMid7.ex05;

public class AnonymousMain {
	public static void main(String[] args) {
		Car car = new Car();
		car.run1();
		car.run2();
		car.run3(new Tire());
	}
}
