package javaHigh11.example07;

import java.util.Arrays;

public class MatchingEx01 {
	public static void main(String[] args) {
		// ��θ���(and) = allMatch(), �Ѱ��� ����(or) = anyMatch(), ��� ���� = noneMatch()
		int[] intArray = { 2, 4, 6, 7 };
		boolean result = Arrays.stream(intArray).allMatch(n -> n % 2 == 0);
		System.out.println(result);

		result = Arrays.stream(intArray).anyMatch(n -> n % 2 == 0);
		System.out.println(result);

		result = Arrays.stream(intArray).noneMatch(n -> n % 7 == 0);
		System.out.println(result);
		System.out.println();
		Student[] studentArray = { new Student("ȫ�浿", 100), new Student("ȫ�浿", 80), new Student("ȫ�浿", 90),
				new Student("ȫ�浿", 50) };
		// ������ ��� 60�� �̻�?
		result = Arrays.stream(studentArray).mapToInt(s -> s.getScore()).allMatch(s -> s >= 60);
		System.out.println(result);
		// �����߿��� �Ѱ��� 80�� �̻�?
		result = Arrays.stream(studentArray).mapToInt(s -> s.getScore()).anyMatch(s -> s >= 80);
		System.out.println(result);
		// ���� 100��?
		result = Arrays.stream(studentArray).mapToInt(s -> s.getScore()).allMatch(s -> s == 100);
		System.out.println(result);
	}
}