package javaChap14.example01;

import java.awt.Toolkit;

public class BeepPrintExample {
	public static void main(String[] args) throws InterruptedException {
		// �۾������� �߰� �� ��Ƽ������� ����ó��
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

		// main ������� �̱۽������ ����ó���۾��� �� �� ���� ���� �����ش�.
		for (int i = 0; i < 5; i++) {
			System.out.println("��");
			Thread.sleep(300);
		}
	}
}