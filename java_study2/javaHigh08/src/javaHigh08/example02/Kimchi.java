package javaHigh08.example02;

public class Kimchi implements Runnable {
	@Override
	public void run() {
		for(int i = 0;i<100;i++) {
			System.out.println("김치만드는중");
		}

	}
}
