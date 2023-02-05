package polymorphism;

public class Tire {
	int maxRotation;
	int accumulatedRotation;
	String location;

	public Tire(String location, int maxRoatation) {
		this.location = location;
		this.maxRotation = maxRoatation;
	}
	public Tire() {
		// TODO Auto-generated constructor stub
	}

	boolean roll() {
		++accumulatedRotation;
		if (accumulatedRotation < maxRotation) {
			System.out.println(location + "Tire ����: " + (maxRotation-accumulatedRotation) + "ȸ");
			return true;
		} else {
			System.out.println(location + "Tire ��ũ");
			return false;
		}
	}
}
