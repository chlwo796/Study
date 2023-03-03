package javaChap16.example06;

public class MethodReferenceExample {
	public static void main(String[] args) {
		Person person = new Person();

		person.ordering((a, b) -> a.compareToIgnoreCase(b));
		// a의 클래스(타입) :: methodName
		person.ordering(String::compareToIgnoreCase);
	}
}