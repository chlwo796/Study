package javaChap15.example01;

import java.util.List;
import java.util.Vector;

public class VectorExample {
	public static void main(String[] args) {
		List<Board> list = new Vector<Board>();

		Thread threadA = new Thread() {
			@Override
			public void run() {
				for (int i = 1; i <= 1000; i++) {
					list.add(new Board("����" + i, "����" + i, "�۾���" + i));
				}
			}
		};
		Thread threadB = new Thread() {
			@Override
			public void run() {
				for (int i = 1001; i <= 2000; i++) {
					list.add(new Board("����" + i, "����" + i, "�۾���" + i));
				}
			}
		};
		threadA.start();	// �۾������� ����
		threadB.start();

		try {
			threadA.join();	// .join() = ������ ����� ������ ��ٸ�.
			threadB.join();		
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("�� ��ü �� : " + list.size());

	}
}
