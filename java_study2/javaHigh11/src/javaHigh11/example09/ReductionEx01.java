package javaHigh11.example09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javaHigh11.example07.Student;

public class ReductionEx01 {
	public static void main(String[] args) {
		List<Student> studentList = Arrays.asList(new Student("ȫ�浿1", 92), new Student("ȫ�浿2", 93),
				new Student("ȫ�浿3", 88));
		int sumResult = studentList.stream().mapToInt(s -> s.getScore()).sum();
		System.out.println(sumResult);

		int sum = studentList.stream().map(Student::getScore).reduce(0, (a, b) -> a + b);
		System.out.println(sum);

		studentList = new ArrayList<Student>();

		sum = studentList.stream().map(Student::getScore).reduce(0, (a, b) -> a + b);
		System.out.println(sum);
	}
}