package javaChap15.example08;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SyschronizedMapExample {
	public static void main(String[] args) {
		Map<Integer, String> map = Collections.synchronizedMap(new HashMap<Integer, String>());
//		�Ʒ� �ڵ��� ����� ����ȭ�� map���� �������� Ȯ���غ� �� �ִ�.
//		Map<Integer, String> map = new HashMap<Integer, String>();
		Thread threadA = new Thread() {
			@Override
			public void run() {
				for (int i = 1; i <= 1000; i++) {
					map.put(i, String.valueOf(i));
				}
			}
		};
		Thread threadB = new Thread() {
			@Override
			public void run() {
				for (int i = 1001; i <= 2000; i++) {
					map.put(i, String.valueOf(i));
				}
			}
		};
		threadA.start();
		threadB.start();

		try {
			threadA.join();
			threadB.join();
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println(map.size());
	}
}
