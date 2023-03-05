package javaChap17.example06;

import java.util.ArrayList;
import java.util.List;

public class MapExample {
	public static void main(String[] args) {
		List<Student> studentList = new ArrayList<Student>();
		studentList.add(new Student("ȫ�浿", 80));
		studentList.add(new Student("ȫ�浿", 70));
		studentList.add(new Student("ȫ�浿", 60));

		studentList.stream().mapToInt(s -> s.getScore()).forEach(score -> System.out.println(score));
	}
}