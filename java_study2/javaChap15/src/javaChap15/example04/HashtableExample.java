package javaChap15.example04;

import java.util.Hashtable;
import java.util.Map;

public class HashtableExample {
	public static void main(String[] args) {
		
		Map<String, Integer> map1 = new Hashtable<String, Integer>();
		
		Thread threadA = new Thread() {
			@Override
			public void run() {
				for(int i = 1;i<=1000;i++) {
					map1.put(String.valueOf(i), i);
				}
			}
		};
		Thread threadB = new Thread() {
			@Override
			public void run() {
				for(int i = 1001;i<=2000;i++) {
					map1.put(String.valueOf(i), i);
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
		System.out.println(map1.size());
	}
}
