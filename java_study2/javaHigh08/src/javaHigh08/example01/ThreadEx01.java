package javaHigh08.example01;

public class ThreadEx01 {
	public static void main(String[] args) {
		Task1 task1 = new Task1();
		Thread thread1 = new Thread(task1);
		thread1.start();
		// ���ý���
		for(int i = 0;i<100;i++) {
			System.out.println("���ڸ� �������");
		}
		Task2 task2 = new Task2();
		task2.start();
	}
}