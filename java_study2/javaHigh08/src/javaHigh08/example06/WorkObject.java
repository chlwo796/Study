package javaHigh08.example06;

public class WorkObject {
	public synchronized void methodA() throws InterruptedException {
		System.out.println("ThreadA methodA() 작업중");
		notify(); // 실행
		wait();
	}

	public synchronized void methodB() throws InterruptedException {
		System.out.println("ThreadA methodB() 작업중");
		notify();
		wait();
	}
}