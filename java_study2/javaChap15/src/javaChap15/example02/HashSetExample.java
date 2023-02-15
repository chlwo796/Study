package javaChap15.example02;

import java.util.HashSet;
import java.util.Set;

public class HashSetExample {
	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();

		set.add("Java1");
		set.add("Java2");
		set.add("Java3");
		set.add("Java1");
		set.add("Java5");

		System.out.println("µ¥ÀÌÅÍ ¼ö : " + set.size());

		Set<Member> set1 = new HashSet<Member>();
		
		set1.add(new Member("È«±æµ¿1", 30));
		set1.add(new Member("È«±æµ¿2", 20));
		set1.add(new Member("È«±æµ¿3", 21));
		set1.add(new Member("È«±æµ¿4", 31));
		set1.add(new Member("È«±æµ¿5", 35));
		
		for(Member mb : set1) {
			System.out.println(mb.getName() + " " + mb.getAge());
		}
		System.out.println("µ¥ÀÌÅÍ ¼ö : " + set1.size());
	}
}
