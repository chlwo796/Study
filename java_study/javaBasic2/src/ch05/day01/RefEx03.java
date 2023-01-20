package ch05.day01;

import java.util.Scanner;

public class RefEx03 {

	public static void main(String[] args) {
		// 같은 package에 통용되는 같은 class가 존재할 시 error발생.

		Student1 s1 = new Student1();
		s1.stName = "홍길동";
		s1.age = 30;
		s1.method1(); // 객체화된 변수 s1.method 하면 Student1 class안에 있는 method 호출
//		method1호출 후 다시 main 실행
		System.out.println("이곳은 main() " + s1.stName);
		s1.method1();
		s1.method2();

		Person1 person = new Person1();

		person.adress = "하남시";
		person.point = 301.4;

		person.getAdress();
		person.getPoint();
		person.getAll();

//		메소드를 이용해서 값을 전달하기
//		두줄짜리 코드를 한줄로 가능

		person.setAdress("하남시");
		person.setPoint(301.4);
		person.setAll("강동구", 40.2);
		person.setEx(5, true, "홍길동", 5.8);
	}

}

class Student1 { // 각 class에서는 main이라는 method와 연결이 되어야 java가 처리 가능. stack <-> heap

	String stName;
	int age;

//	method 동작하기도 가능
//	리턴타입 method(입력받는 변수, method가 호출될 때 넣어주는 값들) {처리할 내용들}
	void method1() {
		System.out.println("이곳은 Student class의 method1입니다.");
	}

	void method2() {
		System.out.println("나이는 " + age + "입니다"); // Student1 class에서 선언된 age만 사용.
	}
}

class Person1 {
	String adress;
	double point;	// 필드. 클래스에 포함된 변수

//	멤버. 클래스 소속 메소드
	
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
		System.out.println("이곳은 Person1 클래스의 method " + adress);
	}

	void setPoint(double point) {
		this.point = point;
		System.out.println(point);
	}

	void setAll(String adress, double point) {
		this.adress = adress;	// this.변수명 = 자신의 클래스의 멤버필드
		this.point = point;
		System.out.println(adress + point);
	}

	void setEx(int number, boolean x, String y, double z) {
		System.out.println("이곳은 Person1 클래스의 method " + number + x + y + z);
	}
}

class Teacher1 {
	String dept;
	boolean gender;
}