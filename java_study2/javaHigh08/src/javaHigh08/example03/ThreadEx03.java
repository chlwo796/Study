package javaHigh08.example03;

public class ThreadEx03 {
	public static void main(String[] args) throws InterruptedException {
		Thread thread1 = new Thread() {
			@Override
			public void run() {
				for (int i = 0; i < 100; i++) {
					System.out.println("전화하는중");
				}
			}
		};

//		thread1.start();

		Runnable r1 = new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 100; i++) {
					System.out.println("카톡보는중");
				}
			}
		};

		Runnable r2 = new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 100; i++) {
					System.out.println("유튜브보는중");
				}
			}
		};
		// Runnable 익명객체로 하나의 Thread에 주소 넣어준다.
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