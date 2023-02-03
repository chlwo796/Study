package javaMid4.ex07;

public class DriverMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Driver driver = new Driver();

		Bus bus = new Bus();
		Taxi taxi = new Taxi();
		Subway subway = new Subway();
		
//		구현객체를 인터페이스 타입으로 선언할 수 있다.(상속과 비슷)
		Vehicle vehicle = new Bus();
		
//		배열이 인터페이스 타입일 경우 구현클래스를 모두 참조할 수 있다.
		Vehicle[] vArray = new Vehicle[10];
		vArray[0] = new Bus();
		
		driver.drive(bus);
		driver.drive(taxi);
		driver.drive(subway);

		driver.fare(subway);
		driver.fare(bus);
		driver.fare(taxi);

		System.out.println("버스요금은" + driver.fare(bus) + "원입니다.");
		System.out.println("지하철요금은" + driver.fare(subway) + "원입니다.");
		System.out.println("택시요금은" + driver.fare(taxi) + "원입니다.");

	}

}
