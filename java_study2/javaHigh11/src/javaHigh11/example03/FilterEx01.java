package javaHigh11.example03;

import java.util.ArrayList;
import java.util.List;

public class FilterEx01 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("홍길동");
		list.add("신용권");
		list.add("신민철");
		list.add("신용권");
		list.add("김자바");
		// 중복제거
		list.stream().distinct().forEach(name -> System.out.println(name));
		System.out.println();
		// filter 메소드의 matches 메소드
		list.stream().filter(n -> n.matches("김자바")).forEach(n -> System.out.println(n));
		System.out.println();
		list.stream().filter(n->n.startsWith("신")).forEach(n->System.out.println(n));
		System.out.println();
		list.stream().distinct().filter(n->n.startsWith("신")).forEach(n->System.out.println(n));
	}
}