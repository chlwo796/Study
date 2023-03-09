package javaHigh11.example01;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class StreamEx01 {
	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		set.add("홍길동");
		set.add("신용권");
		set.add("김자바");

		Iterator<String> it = set.iterator();

		while (it.hasNext()) {
			System.out.println(it.next());
		}
		System.out.println("스트림이용");
		set.stream().forEach(name -> System.out.println(name));
	}
}