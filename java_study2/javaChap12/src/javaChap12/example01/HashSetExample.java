package javaChap12.example01;

import java.util.HashSet;

public class HashSetExample {
	public static void main(String[] args) {
		HashSet<Student> hashSet = new HashSet<Student>();
		
		hashSet.add(new Student(1, "ȫ�浿"));
		System.out.println(hashSet.size());
		hashSet.add(new Student(1, "ȫ�浿"));
		System.out.println(hashSet.size());
		// Student Ŭ�������� ����񱳰����� �����ϸ� ���� ������ ����ȴ�.
		hashSet.add(new Student(2, "ȫ�浿"));
		System.out.println(hashSet.size());
	}
}