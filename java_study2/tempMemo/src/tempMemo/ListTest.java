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
//			Person p = new Person();	// ����� ������ �����߱⶧���� �⺻�����ڴ� ����� �� ����.
		// �´� �Ķ���Ͱ� ��� �´� �Ķ���ͷ� �����ؾ��Ѵ�.
		ArrayList<Person> people = new ArrayList<Person>();
		Person p = new Person("����", 38);
		people.add(p);
	}
}
