package javaChap17.example04;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamExample {
	public static void main(String[] args) {
		List<Product> list = new ArrayList<Product>();
		for (int i = 1; i <= 5; i++) {
			Product product = new Product(i, "��ǰ" + i, "���� ȸ��", (int) (100000 * Math.random()));
			list.add(product);
		}
		Stream<Product> stream = list.stream();
		// .println(p) -> toString �ڵ�����
		stream.forEach(p -> System.out.println(p));
	}
}
