package javaChap12.example09;

public class GetClassExample {
	public static void main(String[] args) throws ClassNotFoundException {
		Class clazz1 = Car.class;
		Class clazz2 = Class.forName("javaChap12.example09.Car");
		Car car = new Car();
		Class clazz3 = car.getClass();

		System.out.println(clazz1.getPackageName());
		System.out.println(clazz2.getSimpleName());
		System.out.println(clazz3.getName());
		System.out.println(clazz1);
		System.out.println(clazz2);
		System.out.println(clazz3);
	}
}

class Car {

}