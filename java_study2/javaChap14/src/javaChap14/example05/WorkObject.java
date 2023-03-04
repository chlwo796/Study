package javaChap14.example05;

public class WorkObject {
	public synchronized void methodA() throws InterruptedException {
		Thread thread = Thread.currentThread();
		System.out.println(thread.getName() + ": methodA �۾� ����");
		notify();
		wait();
	}

	public synchronized void methodB() throws InterruptedException {
		Thread thread = Thread.currentThread();
		System.out.println(thread.getName() + ": methodB �۾� ����");
		notify();
		wait();
	}
}