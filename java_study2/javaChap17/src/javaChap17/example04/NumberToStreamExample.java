package javaChap17.example04;

import java.util.stream.IntStream;

public class NumberToStreamExample {
	public static int sum = 0;

	public static void main(String[] args) {
		// int sum을 인스턴스변수로 선언하면, final적 특성을 가지지 못하여 사용할 수 없다.
		IntStream stream = IntStream.rangeClosed(1, 100);
		stream.forEach(a -> sum += a);
		System.out.println(sum);
	}
}