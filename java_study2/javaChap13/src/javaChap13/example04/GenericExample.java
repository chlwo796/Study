package javaChap13.example04;

public class GenericExample {
	public static void main(String[] args) {
		boolean result1 = compare(10, 20);
		System.out.println(result1);

		boolean result2 = compare(4.3, 4.3);
		System.out.println(result2);
		// 제네릭메소드의 타입을 Number로 제한하였다.
//		boolean result3 = compare("12", "12");
//		System.out.println(result3);
	}

	public static <T extends Number> boolean compare(T t1, T t2) {
		System.out.println("compare(" + t1.getClass().getSimpleName() + ", " + t2.getClass().getSimpleName() + ")");
		double value1 = t1.doubleValue();
		double value2 = t2.doubleValue();
		return value1 == value2;
	}
}
