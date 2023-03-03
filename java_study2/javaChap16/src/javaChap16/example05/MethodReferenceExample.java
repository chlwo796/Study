package javaChap16.example05;

public class MethodReferenceExample {
	public static void main(String[] args) {
		Person person = new Person();

		person.action((x, y) -> Computer.staticMethod(x, y));
		// x,y 라는 매개변수를 받는 Computer의 staticMethod는 단순히 매개변수만 받아서 처리 후 리턴한다.
		// 정적메소드 참조형
		person.action(Computer::staticMethod);
		// 객체생성 후 인스턴스메소드 접근
		Computer computer = new Computer();

		person.action((x, y) -> computer.instanceMethod(x, y));
		// 인스턴스메소드 참조형
		person.action(computer::instanceMethod);
	}
}
