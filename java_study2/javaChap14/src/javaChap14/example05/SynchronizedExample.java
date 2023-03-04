package javaChap14.example05;

public class SynchronizedExample {
	public static void main(String[] args) {
		Calculator calculator = new Calculator();
		User1Thread user1Thread = new User1Thread();
		user1Thread.setCalculator(calculator);
		User2Thread user2Thread = new User2Thread();
		user2Thread.setCalculator(calculator);
		// 메인스레드에서 거의 동시에 시작하더라도 동기화되어 데이터가 각각 다르게 출력됨을 확인할 수 있다.
		user1Thread.start();
		user2Thread.start();
	}
}