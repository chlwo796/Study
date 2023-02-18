package javaChap15.example06;

import java.util.TreeSet;

public class ComparableExample {
	public static void main(String[] args) {
		TreeSet<Person> treeSet1 = new TreeSet<Person>();
		treeSet1.add(new Person("홍길동", 45));
		treeSet1.add(new Person("김자바", 35));
		treeSet1.add(new Person("박자바", 36));
		treeSet1.add(new Person("이자바", 35));
		
		for(Person p : treeSet1) {
			System.out.println(p.name + " " + p.age);
		}
	}
}
