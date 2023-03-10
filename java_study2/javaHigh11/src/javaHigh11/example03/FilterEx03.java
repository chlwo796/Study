package javaHigh11.example03;

import java.util.Arrays;
import java.util.List;

public class FilterEx03 {
	public static void main(String[] args) {
		// ��ü�� �����ϴ� ����Ʈ�� ���͸� �� ���
		Arrays.asList(new Student("�ű浿", 10), new Student("ȫ�浿2", 15), new Student("��浿", 30),
				new Student("�ű浿", 20), new Student("ȫ�浿5", 18)).stream().filter(s -> s.getAge() < 30)
				.forEach(s -> System.out.println(s.getName() + "\t" + s.getAge()));
		System.out.println();
		List<Student> list = Arrays.asList(new Student("�ű浿", 10), new Student("ȫ�浿2", 15), new Student("��浿", 30),
				new Student("�ű浿", 20), new Student("ȫ�浿5", 18));
		// �̸��� ������ �ߺ� ����
		list.stream().map(s->s.getName()).distinct().forEach(s->System.out.println(s));
	}
}
