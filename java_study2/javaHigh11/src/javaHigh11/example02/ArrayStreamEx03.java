package javaHigh11.example02;

import java.util.Arrays;

public class ArrayStreamEx03 {
	public static void main(String[] args) {
		// 래퍼클래스를 이용하여 
		Double[] dArray = { 1.1, 2.2, 3.3, 4.4, 5.5 };

		Boolean[] bArray = { true, false, true, true, false, true };

		long[] lArray = { 1000L, 2000L, -123400L };

		float[] fArray = { 2.3f, 4.5f, 2.6f };

		Arrays.asList(dArray).stream().forEach(number -> System.out.println(number));
		
		// 래퍼클래스로 출력
		Arrays.asList(bArray).stream().forEach(x -> System.out.println(x));

		Arrays.stream(dArray).forEach(n -> System.out.println(n));

		double average = Arrays.stream(lArray).average().getAsDouble();
		Arrays.asList(fArray).stream();
		float sum = 0f;
		Arrays.asList(fArray);
	}
}