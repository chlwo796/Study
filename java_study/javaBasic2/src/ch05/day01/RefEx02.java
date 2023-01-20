package ch05.day01;

// ��Ű�� �ȿ� ���ο� class �����ϱ�
class Car {	// Ŭ������ = �빮��
	String carKind;	// ������ = �ҹ���. camel style
	int carPrice;
}

class City {
	String cityName;
	String cityLocation;
	double cityTex;
	boolean cityGood;	// field��� ��. ���� ����
}

public class RefEx02 {

	public static void main(String[] args) {	// static(�����޼ҵ�) = compile ���ڸ��� stack memory�� �÷���
		// class �����ǽ�

		Car car1 = new Car();
		City city1 = new City();
		Car car2 = new Car();	// ���� �̸��� Ŭ�������� �ٸ��������� heap memory�� �ι�° ����
		City city2 = new City();
		
		car1.carKind = "�ҳ�Ÿ";
		car1.carPrice = 3500;
		car2.carKind = "�׷���";
		car2.carPrice = 5000;
		
		System.out.println(car1.carKind + car1.carPrice);
		System.out.println(car2.carKind + car2.carPrice);
		
		city1.cityName = "�ϳ���";
		city1.cityLocation = "��⵵";
		city1.cityTex = 0.125;
		city1.cityGood = true;
		
		city2.cityName = "������";
		city2.cityLocation = "�����";
		city2.cityTex = 0.134;
		city2.cityGood = true;
		
		System.out.println(city1.cityName + " " + city1.cityLocation + " " + city1.cityTex + " " + city1.cityGood);
		System.out.println(city2.cityName + " " + city2.cityLocation + " " + city2.cityTex + " " + city2.cityGood);
	}

}
