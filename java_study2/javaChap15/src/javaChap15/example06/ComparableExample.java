package javaChap15.example06;

import java.util.TreeSet;

public class ComparableExample {
	public static void main(String[] args) {
		TreeSet<Person> treeSet1 = new TreeSet<Person>();
		treeSet1.add(new Person("ȫ�浿", 45));
		treeSet1.add(new Person("���ڹ�", 35));
		treeSet1.add(new Person("���ڹ�", 36));
		treeSet1.add(new Person("���ڹ�", 35));
		
		for(Person p : treeSet1) {
			System.out.println(p.name + " " + p.age);
		}
	}
}
