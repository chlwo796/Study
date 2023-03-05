package javaChap17.example05;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class FilteringExample {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("È«±æµ¿1");
		list.add("È«±æµ¿2");
		list.add("È«±æµ¿2");
		list.add("±è±æµ¿3");
		list.add("±è±æµ¿3");

		Stream<String> stream = list.stream();
		stream.forEach(name -> System.out.println(name));
		System.out.println();
		// ¸Þ¼Òµå Ã¼ÀÌ´×ÆÐÅÏ
		list.stream().distinct().forEach(name -> System.out.println(name));
		System.out.println();
		list.stream().filter(f -> f.startsWith("±è")).forEach(name -> System.out.println(name));
		System.out.println();
		list.stream().distinct().filter(f -> f.startsWith("±è")).forEach(name -> System.out.println(name));

	}
}