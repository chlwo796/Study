package javaHigh07.example01;

public class GenericEx06 {
	public static void main(String[] args) {
		boolean result = GenericEx06.compare(10.0, 10);
		System.out.println(result);

	}

	public static <T extends Number> boolean compare(T t1, T t2) {
		// T extends Number 로 자료형을 Number의 자식들만 T로 제한
		System.out.println("compare(" + t1.getClass().getSimpleName() + ", " + t2.getClass().getSimpleName() + ")");
		double v1 = t1.doubleValue();
		double v2 = t2.doubleValue();

		return (v1 == v2);
	}
}
