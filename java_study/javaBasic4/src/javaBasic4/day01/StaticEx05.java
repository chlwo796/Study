package javaBasic4.day01;

public class StaticEx05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println("메인 메소드 부분");
		System.out.println(Car.a);
		Car car = new Car();
		System.out.println(car.ia);
	}

}

class Car {
	static int a = 100;
	int ia;
	static {
		System.out.println("이곳은 정적 블록, 정적 멤버들을 처리할때 먼저.(멤버 = 필드,메소드)");
		System.out.println("정적 멤버들의 초기값을 넣을 때 주로 사용");
		a = 200;
	}
	
//	기본생성자 호출 전에 인스턴스 블록이 먼저 호출된다.
	{
		System.out.println("인스턴스 블록");
		ia = 1000;
	}

	public Car() {
		System.out.println("기본생성자");
		ia = 2000;
	}
}