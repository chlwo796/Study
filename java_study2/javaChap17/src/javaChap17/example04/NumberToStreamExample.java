package javaChap17.example04;

import java.util.stream.IntStream;

public class NumberToStreamExample {
	public static int sum = 0;

	public static void main(String[] args) {
		// int sum�� �ν��Ͻ������� �����ϸ�, final�� Ư���� ������ ���Ͽ� ����� �� ����.
		IntStream stream = IntStream.rangeClosed(1, 100);
		stream.forEach(a -> sum += a);
		System.out.println(sum);
	}
}