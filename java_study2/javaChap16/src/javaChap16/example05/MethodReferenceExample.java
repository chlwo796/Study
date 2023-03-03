package javaChap16.example05;

public class MethodReferenceExample {
	public static void main(String[] args) {
		Person person = new Person();

		person.action((x, y) -> Computer.staticMethod(x, y));
		// x,y ��� �Ű������� �޴� Computer�� staticMethod�� �ܼ��� �Ű������� �޾Ƽ� ó�� �� �����Ѵ�.
		// �����޼ҵ� ������
		person.action(Computer::staticMethod);
		// ��ü���� �� �ν��Ͻ��޼ҵ� ����
		Computer computer = new Computer();

		person.action((x, y) -> computer.instanceMethod(x, y));
		// �ν��Ͻ��޼ҵ� ������
		person.action(computer::instanceMethod);
	}
}
