package javaHigh11.example07;

import java.util.Arrays;

public class MatchingEx01 {
	public static void main(String[] args) {
		// 모두만족(and) = allMatch(), 한개라도 만족(or) = anyMatch(), 모두 거짓 = noneMatch()
		int[] intArray = { 2, 4, 6, 7 };
		boolean result = Arrays.stream(intArray).allMatch(n -> n % 2 == 0);
		System.out.println(result);

		result = Arrays.stream(intArray).anyMatch(n -> n % 2 == 0);
		System.out.println(result);

		result = Arrays.stream(intArray).noneMatch(n -> n % 7 == 0);
		System.out.println(result);
		System.out.println();
		Student[] studentArray = { new Student("홍길동", 100), new Student("홍길동", 80), new Student("홍길동", 90),
				new Student("홍길동", 50) };
		// 점수가 모두 60점 이상?
		result = Arrays.stream(studentArray).mapToInt(s -> s.getScore()).allMatch(s -> s >= 60);
		System.out.println(result);
		// 점수중에서 한개라도 80점 이상?
		result = Arrays.stream(studentArray).mapToInt(s -> s.getScore()).anyMatch(s -> s >= 80);
		System.out.println(result);
		// 전부 100점?
		result = Arrays.stream(studentArray).mapToInt(s -> s.getScore()).allMatch(s -> s == 100);
		System.out.println(result);
	}
}