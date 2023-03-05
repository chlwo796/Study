package javaChap17.example11;

import java.util.Arrays;
import java.util.List;

public class ReductionExample {
	public static void main(String[] args) {
		List<Student> studentList = Arrays.asList(new Student("ȫ�浿", 92), new Student("�ſ��", 95),
				new Student("���ڹ�", 88));
		int sum1 = studentList.stream().mapToInt(s -> s.getScore()).sum();
		System.out.println(sum1);
		// reduce()�� ����� ����� ����
		int sum2 = studentList.stream().mapToInt(s -> s.getScore()).reduce(0, (a, b) -> a + b);
		System.out.println(sum2);
	}
}