package javaMid5.ex06;

public class Child extends Parent {
//	chap06. ex06
//	public int studentNo;
//
//	public Child(String name, int studentNo) {
////		super(name);	// 자식 생성자에서 부모의 생성자를 호출하는 것
////		없을 시, super(name, studentNo)가 자동으로 컴파일
//		
////		super를 호출하지 않아도, 부모클래스에 기본생성자가 있다면 오류해결가능.
////		부모에 기본생성자를 기본으로 넣어준다. 
////		자식 객체생성시 나중에 에러 발생을 줄일 수 있다.
//		this.name = name;
//		this.studentNo = studentNo;
//	}
//	정리
//	1. 부모에 기본생성자를 만들어준다.
//	2. 자식생성자에 super(name);을 명시해둔다.
//	3. 부모에 생성자를 모두 없애준다.

//	chap06.ex07
	public String name;

	public Child() {
		this("홍길동");
		System.out.println("Child() call");
	}

	public Child(String name) {
		this.name = name;
		System.out.println("Child(String name) call");
	}
}
