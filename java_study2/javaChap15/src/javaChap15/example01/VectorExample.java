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
					list.add(new Board("제목" + i, "내용" + i, "글쓴이" + i));
				}
			}
		};
		Thread threadB = new Thread() {
			@Override
			public void run() {
				for (int i = 1001; i <= 2000; i++) {
					list.add(new Board("제목" + i, "내용" + i, "글쓴이" + i));
				}
			}
		};
		threadA.start();	// 작업스레드 실행
		threadB.start();

		try {
			threadA.join();	// .join() = 스레드 종료될 떄까지 기다림.
			threadB.join();		
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("총 객체 수 : " + list.size());

	}
}
