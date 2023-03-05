package javaChap17.example02;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ParallelStreamExample {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();

		list.add("ȫ�浿");
		list.add("ȫ�浿1");
		list.add("ȫ�浿2");
		list.add("ȫ�浿3");
		list.add("ȫ�浿4");

		Stream<String> parallelStream = list.parallelStream();
		parallelStream.forEach(name -> System.out.println(name + ": " + Thread.currentThread().getName()));
	}
}