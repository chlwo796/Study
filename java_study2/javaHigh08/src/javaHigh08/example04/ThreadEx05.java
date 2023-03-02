package javaHigh08.example04;

public class ThreadEx05 {
	public static void main(String[] args) {

		Thread t2 = new Thread(new Runnable() {
			public void run() {
				for (int i = 2; i < 9; i++) {
					for (int j = 1; j <= 9; j++) {
						System.out.println(i + "X" + j + "=" + (i * j));
						try {
							Thread.sleep(10);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		});

		Thread t1 = new Thread(new Runnable() {
			public void run() {
//				try {
				t2.start();
//					t2.join();	// t2를 완료한 후 t1 마저 실행, t1실행대기

//				} catch (InterruptedException e) {
//					 TODO Auto-generated catch block
//					e.printStackTrace();
//				}

				for (int i = 0; i < 100; i++) {
					System.out.println("---------");
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}
		});
		t1.start();
	}
}
