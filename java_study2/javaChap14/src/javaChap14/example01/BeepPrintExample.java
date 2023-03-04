package javaChap14.example01;

import java.awt.Toolkit;

public class BeepPrintExample {
	public static void main(String[] args) throws InterruptedException {
		// 작업스레드 추가 후 멀티스레드로 동시처리
		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {
				Toolkit toolkit = Toolkit.getDefaultToolkit();
				for (int i = 0; i < 5; i++) {
					toolkit.beep();
					try {
						Thread.sleep(300);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

			}
		});
		thread.start();

		// main 스레드는 싱글스레드로 다중처리작업을 할 수 없는 것을 보여준다.
		for (int i = 0; i < 5; i++) {
			System.out.println("띵");
			Thread.sleep(300);
		}
	}
}