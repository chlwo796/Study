package javaHigh11.example02;

import java.util.Arrays;

public class ArrayStreamEx03 {
	public static void main(String[] args) {
		// 래퍼클래스를 이용하여
		Double[] dArray = { 1.1, 2.2, 3.3, 4.4, 5.5 };

		Boolean[] bArray = { true, false, true, true, false, true };

		long[] lArray = { 1000L, 2000L, -123400L };

		Float[] fArray = { 2.3f, 4.5f, 2.6f };
		Float[] fArray1 = { 2.3f, 4.5f, 2.6f };
		Arrays.asList(dArray).stream().forEach(number -> System.out.println(number));

		// 래퍼클래스로 출력
		Arrays.asList(bArray).stream().forEach(x -> System.out.println(x));

		Arrays.stream(dArray).forEach(n -> System.out.println(n));

		double average = Arrays.stream(lArray).average().getAsDouble();
		System.out.println(average);
		// 박싱과 언박싱의 개념...
		float sum = Arrays.stream(fArray).reduce((float) 0, (a, b) -> a + b);

		float sum1 = Arrays.asList(fArray1).stream().reduce((float) 0, (a, b) -> a + b);

		System.out.println(sum);

		System.out.println(sum1);
	}
}