package javaChap14.example06;

public class PrintThread3 extends Thread {

	@Override
	public void run() {
		while (!Thread.interrupted()) {
			System.out.println("������");
		}

		System.out.println("���ҽ�����");
		System.out.println("��������");
	}
}
