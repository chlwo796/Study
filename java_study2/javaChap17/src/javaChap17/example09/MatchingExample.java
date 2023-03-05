package javaChap17.example09;

import java.util.Arrays;

public class MatchingExample {
	public static void main(String[] args) {
		int[] intArray = { 2, 4, 6 };

		boolean result = Arrays.stream(intArray).peek(n -> System.out.printf("{%d} ", n)).allMatch(n -> n % 2 == 0);
		System.out.println();
		System.out.println("전부 2의 배수입니까?" + result);

		result = Arrays.stream(intArray).anyMatch(n -> n % 3 == 0);
		System.out.println("하나라도 3의 배수입니까?" + result);

		result = Arrays.stream(intArray).noneMatch(n -> n % 3 == 0);
		System.out.println("3의 배수가 없습니까?" + result);
	}
}