package javaChap17.example07;

import java.util.ArrayList;
import java.util.List;

public class ComparatorSortingExample {
	public static void main(String[] args) {
		List<Student2> studentList = new ArrayList<Student2>();

		studentList.add(new Student2("홍길동", 60));
		studentList.add(new Student2("신용권", 40));
		studentList.add(new Student2("유미선", 30));
		// 점수기준 오름차순
		studentList.stream().sorted((o1, o2) -> Integer.compare(o1.getScore(), o2.getScore()))
				.forEach(s -> System.out.println(s.getName() + " " + s.getScore()));
		System.out.println();
		// 역순
		studentList.stream().sorted((o1, o2) -> Integer.compare(o2.getScore(), o1.getScore()))
				.forEach(s -> System.out.println(s.getName() + " " + s.getScore()));
	}
}