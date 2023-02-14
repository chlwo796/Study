package javaHigh03.example03;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetEx02 {
	public static void main(String[] args) {
		// 강아지 15, 고양이 10, 토끼 7, 닭 3

		Set<Animal> animalSet = new HashSet<Animal>();
		animalSet.add(new Animal("강아지", 15));
		animalSet.add(new Animal("강아지", 15));
		animalSet.add(new Animal("강아지", 15));
		animalSet.add(new Animal("고양이", 10));
		animalSet.add(new Animal("토끼", 7));
		animalSet.add(new Animal("닭", 3));

		Iterator<Animal> it = animalSet.iterator();

		while (it.hasNext()) {
			Animal animal = it.next();
			System.out.println(animal.getKind() + " " + animal.getLifeSpan());
		}
	}
}
