package javaChap17.example06;

import java.util.Arrays;
import java.util.stream.IntStream;

public class BoxingMapExample {
	public static void main(String[] args) {
		int[] intArray = { 1, 3, 5, 7, 9 };

		IntStream intStream = Arrays.stream(intArray);

		intStream.asDoubleStream().forEach(d -> System.out.println(d));

		Arrays.stream(intArray).boxed().forEach(number -> System.out.println(number));
	}
}