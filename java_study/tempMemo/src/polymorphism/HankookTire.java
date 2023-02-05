package polymorphism;

public class HankookTire extends Tire {
	@Override
	boolean roll() {
		++accumulatedRotation;
		if (accumulatedRotation < maxRotation) {
			System.out.println(location + "HankookTire ¼ö¸í: " + (maxRotation-accumulatedRotation) + "È¸");
			return true;
		} else {
			System.out.println(location + "HankookTire ÆãÅ©");
			return false;
		}
	}

	public HankookTire(String location, int maxRotation) {
		super(location, maxRotation);
	}
}