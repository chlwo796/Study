package javaHigh11.example05;

import java.util.Arrays;
import java.util.List;

public class SortingEx {
	public static void main(String[] args) {
		List<Student> list = Arrays.asList(new Student("ȫ�浿1", 26), new Student("ȫ�浿2", 21), new Student("ȫ�浿3", 25),
				new Student("ȫ�浿4", 20));
		// ����
		list.stream().sorted().forEach(s -> System.out.println(s.getName() + "\t" + s.getScore()));
		System.out.println();

		List<Person> personList = Arrays.asList(new Person("F", false, 2800.10), new Person("E", true, 3900.90),
				new Person("D", true, 3900.99), new Person("B", false, 2340.80), new Person("C", false, 1200.90),
				new Person("A", true, 998.90));
		// �޿����� ���
		personList.stream().sorted(new PersonComporator())
				.forEach(p -> System.out.println(p.getName() + " " + p.getPay() + " " + p.isGender()));
		System.out.println();
		// �������, �޿�����
		personList.stream().filter(s -> s.isGender()).sorted(new PersonComporator())
				.forEach(p -> System.out.println(p.getName() + " " + p.getPay() + " " + p.isGender()));
		System.out.println();
		
		personList.stream().filter(s -> s.isGender()).sorted(new PersonComporator())
		.forEach(p -> System.out.println(p.getName() + " " + p.getPay() + " " + p.isGender()));
	}
}