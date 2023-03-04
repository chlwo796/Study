package javaChap14.example04;

public class JoinExample {
	public static void main(String[] args) throws InterruptedException {
		SumThread sumThread = new SumThread();
		sumThread.start();
		try {
			sumThread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(sumThread.getSum());
	}
}