package javaChap14.example06;

public class PrintThread2 extends Thread {
	private boolean stop;

	public void setStop(boolean stop) {
		this.stop = stop;
	}

	@Override
	public void run() {
		try {
			while (!stop) {
				System.out.println("������");
				Thread.sleep(1);
			}
		} catch (InterruptedException e) {
		}
		System.out.println("���ҽ�����");
		System.out.println("��������");
	}
}
