package javaHigh11.exercise06;

import java.util.Arrays;
import java.util.List;

public class Example {
	public static void main(String[] args) {
		List<Member> list = Arrays.asList(new Member("ȫ�浿", 30), new Member("���ڹ�", 40));
		double avg = list.stream().mapToDouble(m -> m.getAge()).average().getAsDouble();
		System.out.println("��ճ��� : " + avg);
	}
}