package javaHigh09.exercise04;

public class Example {
	public static void main(String[] args) {

		Thread thread = new Thread(() -> {
			for (int i = 0; i < 3; i++) {
				System.out.println("�۾� �����尡 ����˴ϴ�.");
			}
		});
		thread.start();
	}
}