package javaMid4.ex07;

public class DriverMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Driver driver = new Driver();

		Bus bus = new Bus();
		Taxi taxi = new Taxi();
		Subway subway = new Subway();
		
//		������ü�� �������̽� Ÿ������ ������ �� �ִ�.(��Ӱ� ���)
		Vehicle vehicle = new Bus();
		
//		�迭�� �������̽� Ÿ���� ��� ����Ŭ������ ��� ������ �� �ִ�.
		Vehicle[] vArray = new Vehicle[10];
		vArray[0] = new Bus();
		
		driver.drive(bus);
		driver.drive(taxi);
		driver.drive(subway);

		driver.fare(subway);
		driver.fare(bus);
		driver.fare(taxi);

		System.out.println("���������" + driver.fare(bus) + "���Դϴ�.");
		System.out.println("����ö�����" + driver.fare(subway) + "���Դϴ�.");
		System.out.println("�ýÿ����" + driver.fare(taxi) + "���Դϴ�.");

	}

}
