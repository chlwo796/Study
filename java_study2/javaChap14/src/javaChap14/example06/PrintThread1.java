package javaChap14.example06;

public class PrintThread1 extends Thread {
	private boolean stop;

	public void setStop(boolean stop) {
		this.stop = stop;
	}

	@Override
	public void run() {
		while (!stop) {
			System.out.println("������");
		}
		System.out.println("���ҽ�����");
		System.out.println("��������");
	}
}
