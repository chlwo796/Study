package javaChap14.example03;

public class ThreadNameExample {
	public static void main(String[] args) {
		Thread mainThread = Thread.currentThread();
		System.out.println(mainThread.getName());

		for (int i = 0; i < 3; i++) {
			Thread threadA = new Thread() {
				@Override
				public void run() {
					System.out.println(getName() + " 실행");
				}
			};
			threadA.start();
		}
		for (int i = 0; i < 3; i++) {
			String number = Integer.toString(i);
			Thread chatThread = new Thread() {
				@Override
				public void run() {

					System.out.println(getName() + " 실행");
				}
			};
			chatThread.setName("chatThread-" + number);
			chatThread.start();
		}
	}
}
