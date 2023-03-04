package javaChap14.example06;

public class SafeStopExample {
	public static void main(String[] args) {
		PrintThread1 printThread1 = new PrintThread1();
		printThread1.start();

		try {
			Thread.sleep(3000);	// 메인스레드 3초 일시정지
		} catch (InterruptedException e) {
		}
		// 3초 후 boolean 값 변경
		printThread1.setStop(true);
	}
}