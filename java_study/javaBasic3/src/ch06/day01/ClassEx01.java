package ch06.day01;

public class ClassEx01 {

	public static void main(String[] args) {
//		������
		Car car = new Car();	// ��ü����, �ν��Ͻ�ȭ, �⺻�����ڸ� ȣ���Ѵ�.
//		�����ڴ� ��ü�� ������ �� �ѹ��� ����ȴ�.
//		�������� �뵵�� ��ü�� ������ �� data�� input�� �� ����Ѵ�.
		System.out.println(car.getCarName());
		System.out.println(car.getCarPrice());
		System.out.println(car.getCarA());
		
		Car car1 = new Car("�׷���");
		System.out.println(car1.getCarName());
		System.out.println(car1.getCarPrice());
		System.out.println(car1.getCarA());
		
		Car car2 = new Car("k5", 4000, "���");
		System.out.println(car2.getCarName());
		System.out.println(car2.getCarPrice());
		System.out.println(car2.getCarA());
		
		Car car3 = new Car("model Y", 10000, "�׽���");
		System.out.println(car3.getCarName());
		System.out.println(car3.getCarPrice());
		System.out.println(car3.getCarA());
	}

}
