package polymorphism;

public class HankookTire extends Tire {
	@Override
	boolean roll() {
		++accumulatedRotation;
		if (accumulatedRotation < maxRotation) {
			System.out.println(location + "HankookTire ����: " + (maxRotation-accumulatedRotation) + "ȸ");
			return true;
		} else {
			System.out.println(location + "HankookTire ��ũ");
			return false;
		}
	}

	public HankookTire(String location, int maxRotation) {
		super(location, maxRotation);
	}
}