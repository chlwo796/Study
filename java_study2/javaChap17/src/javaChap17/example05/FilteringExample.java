package javaChap17.example05;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class FilteringExample {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("ȫ�浿1");
		list.add("ȫ�浿2");
		list.add("ȫ�浿2");
		list.add("��浿3");
		list.add("��浿3");

		Stream<String> stream = list.stream();
		stream.forEach(name -> System.out.println(name));
		System.out.println();
		// �޼ҵ� ü�̴�����
		list.stream().distinct().forEach(name -> System.out.println(name));
		System.out.println();
		list.stream().filter(f -> f.startsWith("��")).forEach(name -> System.out.println(name));
		System.out.println();
		list.stream().distinct().filter(f -> f.startsWith("��")).forEach(name -> System.out.println(name));

	}
}