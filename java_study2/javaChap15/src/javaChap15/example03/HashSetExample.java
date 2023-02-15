package javaChap15.example03;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetExample {
	public static void main(String[] args) {
		Set<String> set1 = new HashSet<String>();

		set1.add("java1");
		set1.add("java2");
		set1.add("java2");
		set1.add("java3");
		set1.add("java4");
		set1.add("java4");
		set1.add("java5");

		Iterator<String> iterator = set1.iterator();

		while (iterator.hasNext()) {
			String str = iterator.next();
			System.out.println(str);
			if (str.equals("java1")) {
				iterator.remove();
			}
		}
		set1.remove("java3");
		System.out.println();
		for (String str : set1) {
			System.out.println(str);
		}

	}
}
