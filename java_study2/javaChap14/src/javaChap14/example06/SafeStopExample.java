package javaChap14.example06;

public class SafeStopExample {
	public static void main(String[] args) {
		PrintThread1 printThread1 = new PrintThread1();
		printThread1.start();

		try {
			Thread.sleep(3000);	// ���ν����� 3�� �Ͻ�����
		} catch (InterruptedException e) {
		}
		// 3�� �� boolean �� ����
		printThread1.setStop(true);
	}
}