package javaHigh08.example03;

public class ThreadEx03 {
	public static void main(String[] args) throws InterruptedException {
		Thread thread1 = new Thread() {
			@Override
			public void run() {
				for (int i = 0; i < 100; i++) {
					System.out.println("��ȭ�ϴ���");
				}
			}
		};

//		thread1.start();

		Runnable r1 = new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 100; i++) {
					System.out.println("ī�庸����");
				}
			}
		};

		Runnable r2 = new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 100; i++) {
					System.out.println("��Ʃ�꺸����");
				}
			}
		};
		// Runnable �͸�ü�� �ϳ��� Thread�� �ּ� �־��ش�.
		Thread thread = new Thread(r1);
		int count = 0;
		thread = new Thread(r2);
		while (thread instanceof Runnable) {
			thread.start();
			thread.wait();
			thread.start();
			count++;
			if (count == 10) {
				break;
			}
		}
//		thread.start();
//		thread = new Thread(r2);
//		thread.start();
	}

}