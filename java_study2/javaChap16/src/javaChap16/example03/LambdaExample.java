package javaChap16.example03;

public class LambdaExample {
	public static void main(String[] args) {
		Person person = new Person();

		person.action1((name, job) -> {
			System.out.print(name + "�� ");
			System.out.println(job + "�� �մϴ�.");
		});
		person.action2(content -> System.out.println("\"" + content + "\" ��� ��Ĩ�ϴ�.")

		);
	}
}