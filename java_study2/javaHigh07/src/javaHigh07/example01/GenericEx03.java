package javaHigh07.example01;

public class GenericEx03 {
	public static void main(String[] args) {
		HomeAgency homeAgency = new HomeAgency();
		Home home = homeAgency.rent();
		home.turnOnLight();
		
		CarAgency carAgency = new CarAgency();
		Car1 car1 = carAgency.rent();
		car1.run();
	}
}

interface Rentable<P> {
	P rent();
}

class Home {
	public void turnOnLight() {
		System.out.println("전등을 켭니다.");
	}
}

class Car1 {
	public void run() {
		System.out.println("자동차가 달립니다.");
	}
}
class HomeAgency implements Rentable<Home>{
	@Override
	public Home rent() {
		// TODO Auto-generated method stub
		return new Home();
	}
}
class CarAgency implements Rentable<Car1>{
	@Override
	public Car1 rent() {
		// TODO Auto-generated method stub
		return new Car1();
	}
}