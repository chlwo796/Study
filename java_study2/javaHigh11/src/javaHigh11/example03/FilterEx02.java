package javaHigh11.example03;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class FilterEx02 {
	public static void main(String[] args) {
		// 반복문 이용
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i <= 100; i++) {
			list.add(i);
		}
		list.stream().filter(n -> n % 2 == 0).forEach(n -> System.out.println(n));
		// IntStream 클래스의 메소드 이용, 짝수 출력
		IntStream.rangeClosed(1, 100).filter(n -> n % 2 == 0).forEach(n -> System.out.println(n));

	}
}
