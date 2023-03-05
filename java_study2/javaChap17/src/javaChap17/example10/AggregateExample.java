package javaChap17.example10;

import java.util.Arrays;

public class AggregateExample {
	public static void main(String[] args) {
		int[] intArray = { 1, 2, 3, 4, 5 };

		long count = Arrays.stream(intArray).peek(n -> System.out.printf("{%d}", n)).count();
		System.out.println();
		System.out.println("총 개수 : " + count);
		long evenCount = Arrays.stream(intArray).filter(n -> n % 2 == 0).count();
		System.out.println("짝수의 개수 : " + evenCount);

		long sum = Arrays.stream(intArray).filter(n -> n % 2 == 0).sum();
		System.out.println("짝수의 합 : " + sum);

		double avg = Arrays.stream(intArray).filter(n -> n % 2 == 0).average().getAsDouble();
		System.out.println("짝수의 평균 : " + avg);

		int max = Arrays.stream(intArray).filter(n -> n % 2 == 0).max().getAsInt();
		System.out.println("짝수의 최대값 : " + max);

		int min = Arrays.stream(intArray).filter(n -> n % 2 == 0).min().getAsInt();
		System.out.println("짝수의 최소값 : " + min);

		int first = Arrays.stream(intArray).filter(n -> n % 3 == 0).findFirst().getAsInt();
		System.out.println("첫번째 3의 배수 : " + first);
	}
}