package javaChap17.example06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FlatMappingExample {
	public static void main(String[] args) {
		List<String> list1 = new ArrayList<String>();
		list1.add("this is java");
		list1.add("i am a best developer");

		list1.stream().flatMap(data -> Arrays.stream(data.split(" "))).forEach(data -> System.out.println(data));
		
		List<String> list2 = Arrays.asList("10, 20, 30", "40, 50");
		list2.stream().flatMapToInt(data -> {
			String[] strArray = data.split(",");
			int[] intArray = new int[strArray.length];
			for (int i = 0; i < intArray.length; i++) {
				// trim() = 공백제거
				intArray[i] = Integer.parseInt(strArray[i].trim());
			}
			// flatMapToInt() = IntStream 리턴이 필요함
			return Arrays.stream(intArray);
		}).forEach(number -> System.out.println(number));
	}
}