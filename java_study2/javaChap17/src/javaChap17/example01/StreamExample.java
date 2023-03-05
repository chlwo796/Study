package javaChap17.example01;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class StreamExample {
	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		set.add("ȫ�浿");
		set.add("ȫ�浿1");
		set.add("ȫ�浿2");

		Stream<String> stream = set.stream();
		stream.forEach(name -> System.out.println(name));
		//forEach(Consumer<? super String> action) = Consumer��� �Լ����������̽��� ���ٽ����� ǥ��, action �޼ҵ�� ���ϰ��� ����.
	}
}
