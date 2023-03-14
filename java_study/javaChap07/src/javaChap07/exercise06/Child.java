package javaChap07.exercise06;

public class Child extends Parent {
	public int studentNo;

	public Child(String name, int studentNo) {
		// 자식객체의 생성자는 super();가 명시되어 있지않으면 부모의 기본생성자를 호출한다.
		// 1. 부모의 기본생성자 추가
		// 2. 자식생성자에 super(); 추가
		// super(name);
		this.name = name;
		this.studentNo = studentNo;
	}
}