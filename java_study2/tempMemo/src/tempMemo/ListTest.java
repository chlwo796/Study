package tempMemo;

import java.util.ArrayList;

class Person {
	private String name;
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

}

public class ListTest {

	public static void main(String[] args) {
//			Person p = new Person();	// 명시적 생성자 생성했기때문에 기본생성자는 사용할 수 없다.
		// 맞는 파라미터가 없어서 맞는 파라미터로 생성해야한다.
		ArrayList<Person> people = new ArrayList<Person>();
		Person p = new Person("경훈", 38);
		people.add(p);
	}
}
