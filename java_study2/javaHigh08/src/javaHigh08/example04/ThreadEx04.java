package javaHigh08.example04;

public class ThreadEx04 {
	public static void main(String[] args) {
		Thread mainThread = Thread.currentThread();
		String threadName = mainThread.getName();
		System.out.println(threadName);

		PhoneThread ph = new PhoneThread();
		Thread t1 = new Thread(ph);
		t1.start();

		YoutubeThread yu = new YoutubeThread();
		yu.start();

		System.out.println("스레드이름 : " + t1.getName());
		System.out.println(yu.getName());
		System.out.println(t1.getName());

		t1.setName("전화걸기");
		yu.setName("유튜브보기");
		System.out.println(yu.getName());
		System.out.println(t1.getName());

		System.out.println(t1.getPriority());// 우선순위 = 1~10

		t1.setPriority(1);
		yu.setPriority(10);
	}
}