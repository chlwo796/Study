package ch05.day01;

import java.util.Scanner;

public class RefEx01 {

	public static void main(String[] args) {
		// ���������� �ڷ��� ����

		int a = 10; // a��� �̸��� ������ 4byte �� ������ stack memory�� ������.
		String name = "ȫ�浿"; // name������ "ȫ�浿"�� ����ִ� heap memory �ּҸ� ������.
		Scanner sc = new Scanner(System.in); // sc��� ������ Scanner �ڷᰡ ����ִ� �ּ�(class)�� ������.
		new Student(); // Student�� �ִ� �����Ͱ� heap memory�� �ö�. java ���ٺҰ�.
		Student st = new Student();
		// student��� ������ Student��� �ڷ������� stack memory�� ����
		// new Ŭ������() new �ش� Ŭ������ heap memory�� �ø���. heap memory �ּһ��� �� stack memory�� ����
		// stack memory������ �ڷ���(data type) ������ �ʼ�.

		new Person(); // class Person�� heap memory�� �ø���. �ּһ���
		Person p = new Person(); // Person�̶�� �ڷ������� p��� ������ class heap memory �ּҿ� ����
		Teacher t = new Teacher();
		st.stName = "ȫ�浿"; // ~(.)- = ~�ȿ�
		st.age = 20;
		p.adress = "��⵵";
		p.point = 81.5;
		t.dept = "��ǻ��";
		t.gender = true;

		System.out.println(st.stName);
		System.out.println(st.age);
		System.out.println(p.adress);
		System.out.println(p.point);
		System.out.println(t.dept);
		System.out.println(t.gender);

	}

}

class Student { // �� class������ main�̶�� method�� ������ �Ǿ�� java�� ó�� ����. stack <-> heap

	String stName;
	int age;

//	method �����ϱ⵵ ����
//	����Ÿ�� method(�Է¹޴� ����, method�� ȣ��� �� �־��ִ� ����) {ó���� �����}
	void method1() {
		System.out.println("�̰��� Student class�� method1�Դϴ�.");
	}
}

class Person {
	String adress;
	double point;
}

class Teacher {
	String dept;
	boolean gender;
}