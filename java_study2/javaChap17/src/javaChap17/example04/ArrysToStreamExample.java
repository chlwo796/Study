package javaChap17.example04;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ArrysToStreamExample {
	public static void main(String[] args) {
		String[] strArray = { "ȫ�浿", "ȫ�浿1", "ȫ�浿2" };
		Stream<String> strStream = Arrays.stream(strArray);
		strStream.forEach(name -> System.out.println(name));
		System.out.println();
		int[] intArray = { 1, 3, 4, 5, 6 };
		IntStream intStream = Arrays.stream(intArray);
		intStream.forEach(number -> System.out.println(number));
		System.out.println();
	}
}