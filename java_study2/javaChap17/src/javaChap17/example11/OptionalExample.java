package javaChap17.example11;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

public class OptionalExample {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		// NoSuchElementsException �߻�(�����Ͱ� ����)
//		double avg = list.stream().mapToInt(n -> n.intValue()).average().getAsDouble();

		OptionalDouble optional = list.stream().mapToInt(n -> n.intValue()).average();

		if (optional.isPresent()) {
			System.out.println(optional.getAsDouble());
		} else {
			System.out.println("��� : 0.0");
		}
		double avg = list.stream().mapToInt(n -> n.intValue()).average().orElse(0.0);
		System.out.println(avg);

		// �����Ͱ� ������ ����ó��(���)�� ���ϵ���
		list.stream().mapToInt(n -> n.intValue()).average().ifPresent(a -> System.out.println(a));
	}
}
