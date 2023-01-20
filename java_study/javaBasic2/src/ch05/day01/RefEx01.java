package ch05.day01;

import java.util.Scanner;

public class RefEx01 {

	public static void main(String[] args) {
		// 참조변수와 자료형 구조

		int a = 10; // a라는 이름의 변수로 4byte 의 공간을 stack memory에 생성함.
		String name = "홍길동"; // name변수는 "홍길동"이 들어있는 heap memory 주소를 가진다.
		Scanner sc = new Scanner(System.in); // sc라는 변수는 Scanner 자료가 들어있는 주소(class)를 가진다.
		new Student(); // Student에 있는 데이터가 heap memory에 올라감. java 접근불가.
		Student st = new Student();
		// student라는 변수는 Student라는 자료형으로 stack memory에 생성
		// new 클래스명() new 해당 클래스를 heap memory에 올린다. heap memory 주소생성 후 stack memory와 연결
		// stack memory에서는 자료형(data type) 선언이 필수.

		new Person(); // class Person을 heap memory에 올린다. 주소생성
		Person p = new Person(); // Person이라는 자료형으로 p라는 변수에 class heap memory 주소와 연결
		Teacher t = new Teacher();
		st.stName = "홍길동"; // ~(.)- = ~안에
		st.age = 20;
		p.adress = "경기도";
		p.point = 81.5;
		t.dept = "컴퓨터";
		t.gender = true;

		System.out.println(st.stName);
		System.out.println(st.age);
		System.out.println(p.adress);
		System.out.println(p.point);
		System.out.println(t.dept);
		System.out.println(t.gender);

	}

}

class Student { // 각 class에서는 main이라는 method와 연결이 되어야 java가 처리 가능. stack <-> heap

	String stName;
	int age;

//	method 동작하기도 가능
//	리턴타입 method(입력받는 변수, method가 호출될 때 넣어주는 값들) {처리할 내용들}
	void method1() {
		System.out.println("이곳은 Student class의 method1입니다.");
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