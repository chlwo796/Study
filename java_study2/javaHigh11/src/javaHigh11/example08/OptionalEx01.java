package javaHigh11.example08;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

public class OptionalEx01 {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
//		list.add(10);
//		list.add(20);
		// 데이터가 없는 경우 에러발생
//		double avg = list.stream().mapToInt(Integer::intValue).average().getAsDouble();

		OptionalDouble od = list.stream().mapToInt(Integer::intValue).average();
		if (od.isPresent()) {
			System.out.println(od.getAsDouble());
		} else {
			System.out.println("평균 : 0.0");
		}
		double average = list.stream().mapToInt(n -> n.intValue()).average().orElse(0.0);
		System.out.println(average);

		list.stream().mapToInt(Integer::intValue).average().ifPresent(n -> System.out.println(n));
	}
}