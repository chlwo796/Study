package javaHigh11.example04;

import java.util.ArrayList;
import java.util.List;

public class MapEx01 {
	public static void main(String[] args) {
		List<Student> list = new ArrayList<>();
		list.add(new Student("ȫ�浿1", 80, 2.5));
		list.add(new Student("ȫ�浿2", 97, 1.5));
		list.add(new Student("ȫ�浿3", 78, 1.0));
		list.add(new Student("ȫ�浿4", 95, 0.9));
		list.add(new Student("ȫ�浿5", 92, 1.1));

		list.stream().mapToDouble(s -> s.getScope()).forEach(s -> System.out.println(s));
		System.out.println();
		list.stream().mapToInt(s -> s.getAge()).forEach(s -> System.out.println(s));
		System.out.println();
		list.stream().mapToInt(s -> s.getAge()).forEach(s -> System.out.println(s));
		System.out.println();
		list.stream().map(s -> s.getName()).forEach(s -> System.out.println(s));
		System.out.println();
	}
}