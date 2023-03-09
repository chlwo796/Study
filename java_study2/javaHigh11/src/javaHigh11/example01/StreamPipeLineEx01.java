package javaHigh11.example01;

import java.util.Arrays;
import java.util.List;

public class StreamPipeLineEx01 {
	public static void main(String[] args) {
		// T... = ������
		List<Student> studentList = Arrays.asList(new Student("ȫ�浿1", 20), new Student("ȫ�浿2", 30),
				new Student("ȫ�浿3", 40), new Student("ȫ�浿4", 50), new Student("ȫ�浿5", 60));
		// ��ձ��ϱ�, peek() �߰�ó�� ���
		double average = studentList.stream().mapToInt(student -> student.getScore())
				.peek(score -> System.out.println(score)).average().getAsDouble();
		System.out.println(average);
		// �հ豸�ϱ�
		int sum = studentList.stream().mapToInt(student -> student.getScore()).sum();
		System.out.println(sum);
	}
}