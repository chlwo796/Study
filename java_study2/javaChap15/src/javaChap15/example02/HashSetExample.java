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

		System.out.println("������ �� : " + set.size());

		Set<Member> set1 = new HashSet<Member>();
		
		set1.add(new Member("ȫ�浿1", 30));
		set1.add(new Member("ȫ�浿2", 20));
		set1.add(new Member("ȫ�浿3", 21));
		set1.add(new Member("ȫ�浿4", 31));
		set1.add(new Member("ȫ�浿5", 35));
		
		for(Member mb : set1) {
			System.out.println(mb.getName() + " " + mb.getAge());
		}
		System.out.println("������ �� : " + set1.size());
	}
}
