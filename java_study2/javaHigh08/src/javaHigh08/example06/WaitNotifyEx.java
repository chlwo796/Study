package javaHigh08.example06;

public class WaitNotifyEx {
	public static void main(String[] args) {
		WorkObject workObject = new WorkObject();
		ThreadA threadA = new ThreadA(workObject);
		ThreadB threadB = new ThreadB(workObject);

		threadA.start();
		threadB.start();

//		threadB.setDaemon(true); // threadB�� ���󽺷���� ����
//		threadA.setDaemon(false); // threadA ���󽺷��� ����
	}
}