package javaChap15.exercise08;

import java.util.HashSet;
import java.util.Set;

public class HashSetExample {
	public static void main(String[] args) {
		Set<Student> set = new HashSet<Student>();
		
		set.add(new Student(1,"ȫ�浿1"));
		set.add(new Student(2,"ȫ�浿2"));
		set.add(new Student(1,"ȫ�浿3"));
		
		System.out.println(set.size());
		for(Student s : set) {
			System.out.println(s.studentNum + ":" + s.name);
		}
		
	}
}
