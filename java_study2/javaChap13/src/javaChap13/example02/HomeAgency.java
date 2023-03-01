package javaChap13.example02;

public class HomeAgency implements Rentable<Home> {
	@Override
	public Home rent() {
		// TODO Auto-generated method stub
		return new Home();
	}
}
