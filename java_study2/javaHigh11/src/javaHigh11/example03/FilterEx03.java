package javaHigh11.example03;

import java.util.Arrays;
import java.util.List;

public class FilterEx03 {
	public static void main(String[] args) {
		// 객체를 참조하는 리스트의 필터링 후 출력
		Arrays.asList(new Student("신길동", 10), new Student("홍길동2", 15), new Student("김길동", 30),
				new Student("신길동", 20), new Student("홍길동5", 18)).stream().filter(s -> s.getAge() < 30)
				.forEach(s -> System.out.println(s.getName() + "\t" + s.getAge()));
		System.out.println();
		List<Student> list = Arrays.asList(new Student("신길동", 10), new Student("홍길동2", 15), new Student("김길동", 30),
				new Student("신길동", 20), new Student("홍길동5", 18));
		// 이름을 가져와 중복 제거
		list.stream().map(s->s.getName()).distinct().forEach(s->System.out.println(s));
	}
}
