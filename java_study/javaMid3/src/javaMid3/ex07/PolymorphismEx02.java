package javaMid3.ex07;

public class PolymorphismEx02 {

	public static void main(String[] args) {
		Car car = new Car();
		car.tire = new Tire();	// car라는 변수(main에서 객체생성)에 tire라는 변수를 담는다.
//		tire 변수는 Car class에서 field로 선언되었다. 그 주소를 Tire클래스의 주소로 한다.
//		class field로 선언된 부모객체타입의 변수에 각 클래스의 주소를 넣는 과정(주소에 넣은 클래스의 메소드를 호출한다)
		car.run();
		
		car.tire = new HankookTire();
		car.run();
		
		car.tire = new KumhoTire();
		car.run();
		
	}
}
