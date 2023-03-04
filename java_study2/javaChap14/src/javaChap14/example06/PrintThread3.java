package javaChap14.example06;

public class PrintThread3 extends Thread {

	@Override
	public void run() {
		while (!Thread.interrupted()) {
			System.out.println("실행중");
		}

		System.out.println("리소스정리");
		System.out.println("실행종료");
	}
}
