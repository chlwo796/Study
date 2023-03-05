package javaChap17.example07;

import java.util.ArrayList;
import java.util.List;

public class ComparatorSortingExample {
	public static void main(String[] args) {
		List<Student2> studentList = new ArrayList<Student2>();

		studentList.add(new Student2("ȫ�浿", 60));
		studentList.add(new Student2("�ſ��", 40));
		studentList.add(new Student2("���̼�", 30));
		// �������� ��������
		studentList.stream().sorted((o1, o2) -> Integer.compare(o1.getScore(), o2.getScore()))
				.forEach(s -> System.out.println(s.getName() + " " + s.getScore()));
		System.out.println();
		// ����
		studentList.stream().sorted((o1, o2) -> Integer.compare(o2.getScore(), o1.getScore()))
				.forEach(s -> System.out.println(s.getName() + " " + s.getScore()));
	}
}