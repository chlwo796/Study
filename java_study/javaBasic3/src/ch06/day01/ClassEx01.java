package ch06.day01;

public class ClassEx01 {

	public static void main(String[] args) {
//		사용관계
		Car car = new Car();	// 객체생성, 인스턴스화, 기본생성자를 호출한다.
//		생성자는 객체가 생성될 때 한번만 수행된다.
//		생성자의 용도는 객체가 생성될 때 data를 input할 때 사용한다.
		System.out.println(car.getCarName());
		System.out.println(car.getCarPrice());
		System.out.println(car.getCarA());
		
		Car car1 = new Car("그랜저");
		System.out.println(car1.getCarName());
		System.out.println(car1.getCarPrice());
		System.out.println(car1.getCarA());
		
		Car car2 = new Car("k5", 4000, "기아");
		System.out.println(car2.getCarName());
		System.out.println(car2.getCarPrice());
		System.out.println(car2.getCarA());
		
		Car car3 = new Car("model Y", 10000, "테슬라");
		System.out.println(car3.getCarName());
		System.out.println(car3.getCarPrice());
		System.out.println(car3.getCarA());
	}

}
