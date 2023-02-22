package javaChap12.example01;

public class SmartPhone {
	private String company;
	private String os;

	public SmartPhone(String company, String os) {
		super();
		this.company = company;
		this.os = os;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return company + " " + os;
	}
}
