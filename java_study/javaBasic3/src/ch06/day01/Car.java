package ch06.day01;

public class Car {
	String carName;
	int carPrice;
	String carA;
	
//	��ü���� �� �����ڰ� class�� ���ٸ� �����Ϸ��� �ڵ����� �����.
	public Car() {
//		�����ڴ� class�� �̸��� ����. return Ÿ���� ����.
		System.out.println("�̰��� ������ �Դϴ�. ���� ó���ɱ��?");
		carName = "�ҳ�Ÿ";
		carPrice = 5000;
		carA= "����";
	}
	public Car(String carName, int carPrice, String carA) {
		this.carA = carA;
		this.carPrice = carPrice;
		this.carName = carName;
	}
	public Car(String carName) {
		this.carName = carName;                  
	}
	public String getCarName() {
		return carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	public int getCarPrice() {
		return carPrice;
	}
	public void setCarPrice(int carPrice) {
		this.carPrice = carPrice;
	}
	public String getCarA() {
		return carA;
	}
	public void setCarA(String carA) {
		this.carA = carA;
	}

}
