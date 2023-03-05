package javaChap17.example07;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortingExample {
	public static void main(String[] args) {
		List<Student1> studentList = new ArrayList<Student1>();

		studentList.add(new Student1("ȫ�浿", 60));
		studentList.add(new Student1("�ſ��", 40));
		studentList.add(new Student1("���̼�", 30));
		// �������� ��������
		studentList.stream().sorted().forEach(s -> System.out.println(s.getName() + " " + s.getScore()));
		System.out.println();
		// �������� ��������
		studentList.stream().sorted(Comparator.reverseOrder()).forEach(s -> System.out.println(s.getName() + " " + s.getScore()));

	}
}