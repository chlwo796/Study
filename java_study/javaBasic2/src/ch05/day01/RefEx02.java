package ch05.day01;

// 패키지 안에 새로운 class 생성하기
class Car {	// 클래스명 = 대문자
	String carKind;	// 변수명 = 소문자. camel style
	int carPrice;
}

class City {
	String cityName;
	String cityLocation;
	double cityTex;
	boolean cityGood;	// field라고 함. 변수 선언
}

public class RefEx02 {

	public static void main(String[] args) {	// static(정적메소드) = compile 하자마자 stack memory에 올려줌
		// class 예제실습

		Car car1 = new Car();
		City city1 = new City();
		Car car2 = new Car();	// 같은 이름의 클래스지만 다른공간으로 heap memory에 두번째 생성
		City city2 = new City();
		
		car1.carKind = "소나타";
		car1.carPrice = 3500;
		car2.carKind = "그랜저";
		car2.carPrice = 5000;
		
		System.out.println(car1.carKind + car1.carPrice);
		System.out.println(car2.carKind + car2.carPrice);
		
		city1.cityName = "하남시";
		city1.cityLocation = "경기도";
		city1.cityTex = 0.125;
		city1.cityGood = true;
		
		city2.cityName = "강동구";
		city2.cityLocation = "서울시";
		city2.cityTex = 0.134;
		city2.cityGood = true;
		
		System.out.println(city1.cityName + " " + city1.cityLocation + " " + city1.cityTex + " " + city1.cityGood);
		System.out.println(city2.cityName + " " + city2.cityLocation + " " + city2.cityTex + " " + city2.cityGood);
	}

}
