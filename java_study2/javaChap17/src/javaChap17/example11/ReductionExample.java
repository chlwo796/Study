package javaChap17.example11;

import java.util.Arrays;
import java.util.List;

public class ReductionExample {
	public static void main(String[] args) {
		List<Student> studentList = Arrays.asList(new Student("홍길동", 92), new Student("신용권", 95),
				new Student("김자바", 88));
		int sum1 = studentList.stream().mapToInt(s -> s.getScore()).sum();
		System.out.println(sum1);
		// reduce()로 사용자 연산식 적용
		int sum2 = studentList.stream().mapToInt(s -> s.getScore()).reduce(0, (a, b) -> a + b);
		System.out.println(sum2);
	}
}