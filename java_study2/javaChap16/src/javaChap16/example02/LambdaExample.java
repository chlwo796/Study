package javaChap16.example02;

public class LambdaExample {
	public static void main(String[] args) {
		Person person = new Person();
		person.action(() -> {
			System.out.println("����� �մϴ�.");
			System.out.println("���α׷����� �մϴ�.");
		});
		person.action(() -> System.out.println("����մϴ�."));
	}
}
