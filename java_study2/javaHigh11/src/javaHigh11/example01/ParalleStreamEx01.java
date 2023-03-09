package javaHigh11.example01;

// util 패키지의 모두 다 import
import java.util.*;

public class ParalleStreamEx01 {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();

		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(8);

		list.parallelStream().forEach(n -> {
			System.out.println(n);
			// 병렬처리한 스트림은 순차처리x, 멀티스레드로 처리속도가 더 빠르다.
			System.out.println(Thread.currentThread().getName());
		});
	}
}