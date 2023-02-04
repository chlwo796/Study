package tempMemo;

public class Main {
	public static void main(String[] args) {
		System.out.println("������ ������ = " + Earth.EARTH_RADIUS + "km");
		System.out.println("������ ǥ���� = " + Earth.EARTH_SURFACE_AREA + "km^2");

	}
}

class Earth {
	static final double EARTH_RADIUS = 6400;
	static final double EARTH_SURFACE_AREA;

	static {
		EARTH_SURFACE_AREA = 4 * Math.PI * EARTH_RADIUS * EARTH_RADIUS;
	}
}