package javaBasic4.day01;

public class StaticEx05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println("���� �޼ҵ� �κ�");
		System.out.println(Car.a);
		Car car = new Car();
		System.out.println(car.ia);
	}

}

class Car {
	static int a = 100;
	int ia;
	static {
		System.out.println("�̰��� ���� ���, ���� ������� ó���Ҷ� ����.(��� = �ʵ�,�޼ҵ�)");
		System.out.println("���� ������� �ʱⰪ�� ���� �� �ַ� ���");
		a = 200;
	}
	
//	�⺻������ ȣ�� ���� �ν��Ͻ� ����� ���� ȣ��ȴ�.
	{
		System.out.println("�ν��Ͻ� ���");
		ia = 1000;
	}

	public Car() {
		System.out.println("�⺻������");
		ia = 2000;
	}
}