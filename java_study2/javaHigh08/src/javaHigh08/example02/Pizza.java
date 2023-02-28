package javaHigh08.example02;

public class Pizza implements Runnable{
	@Override
	public void run() {
		for(int i = 0;i<100;i++) {
			System.out.println("피자만드는중");
		}

	}
}
