package javaHigh03.example03;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetEx02 {
	public static void main(String[] args) {
		// ������ 15, ����� 10, �䳢 7, �� 3

		Set<Animal> animalSet = new HashSet<Animal>();
		animalSet.add(new Animal("������", 15));
		animalSet.add(new Animal("������", 15));
		animalSet.add(new Animal("������", 15));
		animalSet.add(new Animal("�����", 10));
		animalSet.add(new Animal("�䳢", 7));
		animalSet.add(new Animal("��", 3));

		Iterator<Animal> it = animalSet.iterator();

		while (it.hasNext()) {
			Animal animal = it.next();
			System.out.println(animal.getKind() + " " + animal.getLifeSpan());
		}
	}
}
