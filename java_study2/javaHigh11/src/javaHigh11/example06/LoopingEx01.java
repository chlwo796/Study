package javaHigh11.example06;

import java.util.Arrays;

public class LoopingEx01 {
	public static void main(String[] args) {
		int[] intArray = { 1, 2, 3, 4, 5 };
		Arrays.stream(intArray).filter(n -> n % 2 == 0).peek(n -> System.out.println(n)).count();
		// peek이용은 최종처리로 집계함수 필요, 전체출력이 필요한 경우에 이용
	}
}