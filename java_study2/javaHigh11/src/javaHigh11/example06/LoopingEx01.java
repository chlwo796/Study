package javaHigh11.example06;

import java.util.Arrays;

public class LoopingEx01 {
	public static void main(String[] args) {
		int[] intArray = { 1, 2, 3, 4, 5 };
		Arrays.stream(intArray).filter(n -> n % 2 == 0).peek(n -> System.out.println(n)).count();
		// peek�̿��� ����ó���� �����Լ� �ʿ�, ��ü����� �ʿ��� ��쿡 �̿�
	}
}