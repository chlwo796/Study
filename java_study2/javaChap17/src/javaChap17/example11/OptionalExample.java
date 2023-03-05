package javaChap17.example11;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

public class OptionalExample {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		// NoSuchElementsException 발생(데이터가 없음)
//		double avg = list.stream().mapToInt(n -> n.intValue()).average().getAsDouble();

		OptionalDouble optional = list.stream().mapToInt(n -> n.intValue()).average();

		if (optional.isPresent()) {
			System.out.println(optional.getAsDouble());
		} else {
			System.out.println("평균 : 0.0");
		}
		double avg = list.stream().mapToInt(n -> n.intValue()).average().orElse(0.0);
		System.out.println(avg);

		// 데이터가 없으면 최종처리(출력)를 안하도록
		list.stream().mapToInt(n -> n.intValue()).average().ifPresent(a -> System.out.println(a));
	}
}
