package javaChap17.example08;

import java.util.Arrays;

public class LoopingExample {
	public static void main(String[] args) {
		int[] intArray = { 1, 2, 3, 4, 5 };
		// peek()�� ����ó���� ������� ���� �������� �ʴ´�.
		Arrays.stream(intArray).filter(number -> number % 2 == 0).peek(number -> System.out.println(number));

		int[] evenArray = Arrays.stream(intArray).filter(number -> number % 2 == 0).peek(number -> System.out.println(number)).toArray();
		
	}
}
