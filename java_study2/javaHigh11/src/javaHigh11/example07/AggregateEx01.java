package javaHigh11.example07;

import java.util.Arrays;

public class AggregateEx01 {
	public static void main(String[] args) {
		Student[] studentArray = { new Student("ȫ�浿1", 100), new Student("ȫ�浿2", 80), new Student("ȫ�浿3", 90),
				new Student("ȫ�浿4", 64), new Student("ȫ�浿5", 70), new Student("ȫ�浿6", 87) };
		long countResult = Arrays.stream(studentArray).count();
		System.out.println(countResult);
		int sum = Arrays.stream(studentArray).mapToInt(s -> s.getScore()).sum();
		System.out.println(sum);
		double average = Arrays.stream(studentArray).mapToInt(s -> s.getScore()).average().getAsDouble();
		System.out.println(average);
		int max = Arrays.stream(studentArray).mapToInt(s -> s.getScore()).max().getAsInt();
		System.out.println(max);
		int min = Arrays.stream(studentArray).mapToInt(s -> s.getScore()).min().getAsInt();
		System.out.println(min);
	}
}