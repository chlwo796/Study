package javaChap14.example04;

public class WorkThread extends Thread {
	public boolean work = true;

	public WorkThread(String name) {
		setName(name);
	}

	@Override
	public void run() {
		while (true) {
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (work) {
				System.out.println(getName() + "작업처리중");
			} else {
				Thread.yield();
			}
		}
	}
}
