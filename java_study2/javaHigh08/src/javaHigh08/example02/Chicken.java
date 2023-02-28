package javaHigh08.example02;

public class Chicken extends Thread {
	@Override
	public void run() {
		for(int i = 0;i<100;i++) {
			System.out.println("치킨만드는중");
		}

	}
}
