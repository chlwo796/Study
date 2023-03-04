package javaChap14.example06;

public class InterruptedExample {
	public static void main(String[] args) {
		PrintThread3 printThread3 = new PrintThread3();
		System.out.println(printThread3.isInterrupted());
		printThread3.start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
		printThread3.interrupt();
		System.out.println(printThread3.isInterrupted());
	}
}
