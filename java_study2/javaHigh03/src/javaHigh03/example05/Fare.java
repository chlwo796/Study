package javaHigh03.example05;

public class Fare {
	String number;
	int familyNumber;
	int electricity;
	int fee;

	public Fare(String number, int familyNumber, int electricity, int fee) {
		super();
		this.number = number;
		this.familyNumber = familyNumber;
		this.electricity = electricity;
		this.fee = fee;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public int getFamilyNumber() {
		return familyNumber;
	}

	public void setFamilyNumber(int familyNumber) {
		this.familyNumber = familyNumber;
	}

	public int getElectricity() {
		return electricity;
	}

	public void setElectricity(int electricity) {
		this.electricity = electricity;
	}

	public int getFee() {
		return fee;
	}

	public void setFee(int fee) {
		this.fee = fee;
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(obj instanceof Fare) {
			Fare fare = (Fare) obj;
			return fare.number.equals(this.number);
		}
		return false;
	}@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return number.hashCode();
	}
}
