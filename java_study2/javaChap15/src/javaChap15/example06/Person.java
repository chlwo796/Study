package javaChap15.example06;

public class Person implements Comparable<Person> {
	public String name;
	public int age;

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	@Override
	public int compareTo(Person o) {
//		이름으로정렬
//		return this.name.compareTo(o.name);
		// 나이로 정렬
		if (this.age > o.age) {
			return 1;
		} else if (this.age == o.age) {
			return 0;
		} else
			return -1;
	}

}
