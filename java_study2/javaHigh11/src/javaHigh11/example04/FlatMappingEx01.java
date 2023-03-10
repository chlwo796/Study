package javaHigh11.example04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FlatMappingEx01 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("this is java");
		list.add("i am a best developer");

		list.stream().flatMap(s -> Arrays.stream(s.split(" "))).forEach(s -> System.out.println(s));
		System.out.println();
		List<String> list2 = Arrays.asList("10, 20, 30", "40, 50");
		list2.stream().flatMapToInt(n -> {
			String[] strArray = n.split(",");
			int[] intArray = new int[strArray.length];
			for (int i = 0; i < strArray.length; i++) {
				// trim() = 공백을 버린다!!
				intArray[i] = Integer.parseInt(strArray[i].trim());
			}
			return Arrays.stream(intArray);
		}).forEach(n -> System.out.println(n));
		System.out.println();
		list2.stream().flatMap(s -> Arrays.stream(s.split(", "))).mapToInt(s -> Integer.parseInt(s))
				.forEach(s -> System.out.println(s));
	}
}