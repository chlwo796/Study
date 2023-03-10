package javaHigh11.example05;

public class Person {
	private String name;
	private boolean gender;
	private double pay;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public double getPay() {
		return pay;
	}

	public void setPay(double pay) {
		this.pay = pay;
	}

	public Person(String name, boolean gender, double pay) {
		super();
		this.name = name;
		this.gender = gender;
		this.pay = pay;
	}
}