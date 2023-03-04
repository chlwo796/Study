package javaChap14.example05;

public class WorkObject {
	public synchronized void methodA() throws InterruptedException {
		Thread thread = Thread.currentThread();
		System.out.println(thread.getName() + ": methodA 작업 실행");
		notify();
		wait();
	}

	public synchronized void methodB() throws InterruptedException {
		Thread thread = Thread.currentThread();
		System.out.println(thread.getName() + ": methodB 작업 실행");
		notify();
		wait();
	}
}