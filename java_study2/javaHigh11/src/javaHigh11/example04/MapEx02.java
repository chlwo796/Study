package javaHigh11.example04;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class MapEx02 {
	public static void main(String[] args) {
		int[] intArray = { 1, 2, 3, 4, 5 };
		IntStream intStream = Arrays.stream(intArray);

		intStream.asDoubleStream().forEach(d -> System.out.println(d));
		long[] longArr = { 1L, 2L, 3L, 4L };
		// double 바꾸고 3.14 곱해서 출력
		LongStream longStream = Arrays.stream(longArr);
		longStream.asDoubleStream().map(s -> s * 3.14).forEach(s -> System.out.println(s));
		
		double[] doubleArr = {1.1, 2.2, 3.3};
		Arrays.stream(doubleArr).boxed().forEach(s->System.out.println(s));
	}
}