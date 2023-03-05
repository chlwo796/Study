package javaChap17.example01;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class StreamExample {
	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		set.add("홍길동");
		set.add("홍길동1");
		set.add("홍길동2");

		Stream<String> stream = set.stream();
		stream.forEach(name -> System.out.println(name));
		//forEach(Consumer<? super String> action) = Consumer라는 함수적인터페이스를 람다식으로 표현, action 메소드는 리턴값이 없다.
	}
}
