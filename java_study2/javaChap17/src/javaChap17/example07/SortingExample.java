package javaChap17.example07;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortingExample {
	public static void main(String[] args) {
		List<Student1> studentList = new ArrayList<Student1>();

		studentList.add(new Student1("홍길동", 60));
		studentList.add(new Student1("신용권", 40));
		studentList.add(new Student1("유미선", 30));
		// 점수기준 오름차순
		studentList.stream().sorted().forEach(s -> System.out.println(s.getName() + " " + s.getScore()));
		System.out.println();
		// 점수기준 내림차순
		studentList.stream().sorted(Comparator.reverseOrder()).forEach(s -> System.out.println(s.getName() + " " + s.getScore()));

	}
}