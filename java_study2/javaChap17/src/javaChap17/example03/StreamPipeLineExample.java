package javaChap17.example03;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamPipeLineExample {
	public static void main(String[] args) {
		List<Student> list = Arrays.asList(new Student("ȫ�浿", 30), new Student("�ſ��", 20), new Student("���̼�", 30));
//		Stream<Student> studentStream = list.stream();
//		IntStream scoreStream = studentStream.mapToInt(student -> student.getScore());
//		double avg = scoreStream.average().getAsDouble();
		// �޼ҵ� ü�̴� ����
		double avg = list.stream().mapToInt(student -> student.getScore()).average().getAsDouble();
		System.out.println(avg);
	}
}
