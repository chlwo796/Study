package javaChap15.example06;

import java.util.TreeSet;

public class ComparatorExample {
	public static void main(String[] args) {
		TreeSet<Fruit> treeSet1 = new TreeSet<Fruit>(new FruitComparator());
		treeSet1.add(new Fruit("사과", 1000));
		treeSet1.add(new Fruit("포도", 1500));
		treeSet1.add(new Fruit("바나나", 2000));
		treeSet1.add(new Fruit("배", 3000));

		for (Fruit f : treeSet1) {
			System.out.println(f.name + " " + f.price);
		}
	}
}
