package javaChap17.example09;

import java.util.Arrays;

public class MatchingExample {
	public static void main(String[] args) {
		int[] intArray = { 2, 4, 6 };

		boolean result = Arrays.stream(intArray).peek(n -> System.out.printf("{%d} ", n)).allMatch(n -> n % 2 == 0);
		System.out.println();
		System.out.println("���� 2�� ����Դϱ�?" + result);

		result = Arrays.stream(intArray).anyMatch(n -> n % 3 == 0);
		System.out.println("�ϳ��� 3�� ����Դϱ�?" + result);

		result = Arrays.stream(intArray).noneMatch(n -> n % 3 == 0);
		System.out.println("3�� ����� �����ϱ�?" + result);
	}
}