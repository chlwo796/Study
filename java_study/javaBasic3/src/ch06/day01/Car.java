package ch06.day01;

public class Car {
	String carName;
	int carPrice;
	String carA;
	
//	객체생성 후 생성자가 class에 없다면 컴파일러가 자동으로 만든다.
	public Car() {
//		생성자는 class와 이름이 같다. return 타입이 없다.
		System.out.println("이곳은 생성자 입니다. 언제 처리될까요?");
		carName = "소나타";
		carPrice = 5000;
		carA= "현대";
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
