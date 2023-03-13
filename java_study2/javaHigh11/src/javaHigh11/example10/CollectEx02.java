package javaHigh11.example10;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class CollectEx02 {
	public static void main(String[] args) {
		List<Student> totalList = new ArrayList<Student>();
		totalList.add(new Student("홍길동", "남", 92));
		totalList.add(new Student("김수영", "여", 87));
		totalList.add(new Student("김자바", "남", 94));
		totalList.add(new Student("오해영", "여", 92));

		Map<String, Double> map = totalList.stream()
				.collect(Collectors.groupingBy(s -> s.getSex(), Collectors.averagingDouble(s -> s.getScore())));
		System.out.println(map);

		List<Student> totalList1 = new ArrayList<Student>();
		totalList1.add(new Student("홍길동", "남", 92, "1학년"));
		totalList1.add(new Student("김수영", "여", 87, "2학년"));
		totalList1.add(new Student("김자바", "남", 94, "3학년"));
		totalList1.add(new Student("오해영", "여", 92, "2학년"));
		totalList1.add(new Student("이해영", "여", 91, "1학년"));
		totalList1.add(new Student("이자바", "남", 97, "3학년"));

		Map<String, Long> map1 = totalList1.stream()
				.collect(Collectors.groupingBy(s -> s.getGrade(), Collectors.counting()));
		System.out.println(map1);

		Map<String, List<Student>> map2 = totalList1.stream().collect(Collectors.groupingBy(s -> s.getGrade()));
		System.out.println(map2);

		Set<String> set = map2.keySet();
		for (String key : set) {
			System.out.println(key + " " + map2.get(key).size());
		}
	}
}