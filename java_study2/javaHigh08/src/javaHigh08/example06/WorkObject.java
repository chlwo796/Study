package javaHigh08.example06;

public class WorkObject {
	public synchronized void methodA() throws InterruptedException {
		System.out.println("ThreadA methodA() �۾���");
		notify(); // ����
		wait();
	}

	public synchronized void methodB() throws InterruptedException {
		System.out.println("ThreadA methodB() �۾���");
		notify();
		wait();
	}
}