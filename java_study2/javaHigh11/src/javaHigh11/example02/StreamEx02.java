package javaHigh11.example02;

import java.util.ArrayList;
import java.util.List;

public class StreamEx02 {
	public static void main(String[] args) {
		List<Product> list = new ArrayList<Product>();
		for (int i = 1; i <= 5; i++) {
			Product product = new Product(i, "상품" + i, "멋진 회사 ", (int) (10000 * Math.random()));
			list.add(product);
		}
		list.stream().forEach(p -> System.out.println(p));
	}
}