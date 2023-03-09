package javaHigh11.example01;

import java.util.Arrays;
import java.util.List;

public class StreamPipeLineEx01 {
	public static void main(String[] args) {
		// T... = 여러개
		List<Student> studentList = Arrays.asList(new Student("홍길동1", 20), new Student("홍길동2", 30),
				new Student("홍길동3", 40), new Student("홍길동4", 50), new Student("홍길동5", 60));
		// 평균구하기, peek() 중간처리 출력
		double average = studentList.stream().mapToInt(student -> student.getScore())
				.peek(score -> System.out.println(score)).average().getAsDouble();
		System.out.println(average);
		// 합계구하기
		int sum = studentList.stream().mapToInt(student -> student.getScore()).sum();
		System.out.println(sum);
	}
}