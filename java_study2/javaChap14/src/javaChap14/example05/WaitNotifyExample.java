package javaChap14.example05;

public class WaitNotifyExample {
	public static void main(String[] args) {
		WorkObject workObject = new WorkObject();

		ThreadA threadA = new ThreadA(workObject);
		ThreadB threadB = new ThreadB(workObject);

		threadA.start();
		threadB.start();
		
		// 메인스레드는 종료하였더라도 다른 작업스레드가 남아있어 종료하지 않는다.
	}
}