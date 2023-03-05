package javaChap17.example10;

import java.util.Arrays;

public class AggregateExample {
	public static void main(String[] args) {
		int[] intArray = { 1, 2, 3, 4, 5 };

		long count = Arrays.stream(intArray).peek(n -> System.out.printf("{%d}", n)).count();
		System.out.println();
		System.out.println("�� ���� : " + count);
		long evenCount = Arrays.stream(intArray).filter(n -> n % 2 == 0).count();
		System.out.println("¦���� ���� : " + evenCount);

		long sum = Arrays.stream(intArray).filter(n -> n % 2 == 0).sum();
		System.out.println("¦���� �� : " + sum);

		double avg = Arrays.stream(intArray).filter(n -> n % 2 == 0).average().getAsDouble();
		System.out.println("¦���� ��� : " + avg);

		int max = Arrays.stream(intArray).filter(n -> n % 2 == 0).max().getAsInt();
		System.out.println("¦���� �ִ밪 : " + max);

		int min = Arrays.stream(intArray).filter(n -> n % 2 == 0).min().getAsInt();
		System.out.println("¦���� �ּҰ� : " + min);

		int first = Arrays.stream(intArray).filter(n -> n % 3 == 0).findFirst().getAsInt();
		System.out.println("ù��° 3�� ��� : " + first);
	}
}