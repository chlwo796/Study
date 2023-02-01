package javaMid3.ex08;

public class PolymorphismEx03 {
	public static void main(String[] args) {
		Driver myDriver = new Driver();
		
		Bus bus = new Bus();
		myDriver.driver(bus);	// 상속관계 파악하기
		
		Taxi taxi = new Taxi();
		myDriver.driver(taxi);
		
	}
}