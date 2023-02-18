package javaChap15.example06;

import java.util.TreeSet;

public class ComparatorExample {
	public static void main(String[] args) {
		TreeSet<Fruit> treeSet1 = new TreeSet<Fruit>(new FruitComparator());
		treeSet1.add(new Fruit("���", 1000));
		treeSet1.add(new Fruit("����", 1500));
		treeSet1.add(new Fruit("�ٳ���", 2000));
		treeSet1.add(new Fruit("��", 3000));

		for (Fruit f : treeSet1) {
			System.out.println(f.name + " " + f.price);
		}
	}
}
