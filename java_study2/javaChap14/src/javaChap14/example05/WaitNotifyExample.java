package javaChap14.example05;

public class WaitNotifyExample {
	public static void main(String[] args) {
		WorkObject workObject = new WorkObject();

		ThreadA threadA = new ThreadA(workObject);
		ThreadB threadB = new ThreadB(workObject);

		threadA.start();
		threadB.start();
		
		// ���ν������ �����Ͽ����� �ٸ� �۾������尡 �����־� �������� �ʴ´�.
	}
}