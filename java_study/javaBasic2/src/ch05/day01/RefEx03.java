package ch05.day01;

import java.util.Scanner;

public class RefEx03 {

	public static void main(String[] args) {
		// ���� package�� ���Ǵ� ���� class�� ������ �� error�߻�.

		Student1 s1 = new Student1();
		s1.stName = "ȫ�浿";
		s1.age = 30;
		s1.method1(); // ��üȭ�� ���� s1.method �ϸ� Student1 class�ȿ� �ִ� method ȣ��
//		method1ȣ�� �� �ٽ� main ����
		System.out.println("�̰��� main() " + s1.stName);
		s1.method1();
		s1.method2();

		Person1 person = new Person1();

		person.adress = "�ϳ���";
		person.point = 301.4;

		person.getAdress();
		person.getPoint();
		person.getAll();

//		�޼ҵ带 �̿��ؼ� ���� �����ϱ�
//		����¥�� �ڵ带 ���ٷ� ����

		person.setAdress("�ϳ���");
		person.setPoint(301.4);
		person.setAll("������", 40.2);
		person.setEx(5, true, "ȫ�浿", 5.8);
	}

}

class Student1 { // �� class������ main�̶�� method�� ������ �Ǿ�� java�� ó�� ����. stack <-> heap

	String stName;
	int age;

//	method �����ϱ⵵ ����
//	����Ÿ�� method(�Է¹޴� ����, method�� ȣ��� �� �־��ִ� ����) {ó���� �����}
	void method1() {
		System.out.println("�̰��� Student class�� method1�Դϴ�.");
	}

	void method2() {
		System.out.println("���̴� " + age + "�Դϴ�"); // Student1 class���� ����� age�� ���.
	}
}

class Person1 {
	String adress;
	double point;	// �ʵ�. Ŭ������ ���Ե� ����

//	���. Ŭ���� �Ҽ� �޼ҵ�
	
	void getAdress() {
		System.out.println(adress);
	}

	void getPoint() {
		System.out.println(point);
	}

	void getAll() {
		System.out.println(adress + ", " + point);
	}

	void setAdress(String adress) {
		this.adress = adress;
		System.out.println("�̰��� Person1 Ŭ������ method " + adress);
	}

	void setPoint(double point) {
		this.point = point;
		System.out.println(point);
	}

	void setAll(String adress, double point) {
		this.adress = adress;	// this.������ = �ڽ��� Ŭ������ ����ʵ�
		this.point = point;
		System.out.println(adress + point);
	}

	void setEx(int number, boolean x, String y, double z) {
		System.out.println("�̰��� Person1 Ŭ������ method " + number + x + y + z);
	}
}

class Teacher1 {
	String dept;
	boolean gender;
}