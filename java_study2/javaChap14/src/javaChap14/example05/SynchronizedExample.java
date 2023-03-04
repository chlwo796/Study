package javaChap14.example05;

public class SynchronizedExample {
	public static void main(String[] args) {
		Calculator calculator = new Calculator();
		User1Thread user1Thread = new User1Thread();
		user1Thread.setCalculator(calculator);
		User2Thread user2Thread = new User2Thread();
		user2Thread.setCalculator(calculator);
		// ���ν����忡�� ���� ���ÿ� �����ϴ��� ����ȭ�Ǿ� �����Ͱ� ���� �ٸ��� ��µ��� Ȯ���� �� �ִ�.
		user1Thread.start();
		user2Thread.start();
	}
}