package javaChap17.example03;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamPipeLineExample {
	public static void main(String[] args) {
		List<Student> list = Arrays.asList(new Student("홍길동", 30), new Student("신용권", 20), new Student("유미선", 30));
//		Stream<Student> studentStream = list.stream();
//		IntStream scoreStream = studentStream.mapToInt(student -> student.getScore());
//		double avg = scoreStream.average().getAsDouble();
		// 메소드 체이닝 패턴
		double avg = list.stream().mapToInt(student -> student.getScore()).average().getAsDouble();
		System.out.println(avg);
	}
}
