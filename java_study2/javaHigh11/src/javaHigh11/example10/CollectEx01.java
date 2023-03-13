package javaHigh11.example10;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import java.util.stream.Collectors;

public class CollectEx01 {
	public static void main(String[] args) {
		List<Student> totalList = new ArrayList<>();
		totalList.add(new Student("홍길동", "남", 92));
		totalList.add(new Student("김수영", "여", 87));
		totalList.add(new Student("김자바", "남", 94));
		totalList.add(new Student("오해영", "여", 92));

		List<Student> maleList = totalList.stream().filter(s -> s.getSex().equals("남")).collect(Collectors.toList());
		for (Student s : maleList) {
			System.out.println(s.getName() + " " + s.getScore());
		}
		System.out.println();
		Set<Student> scoreSet = totalList.stream().filter(s -> s.getScore() >= 90).collect(Collectors.toSet());
		for (Student s : scoreSet) {
			System.out.println(s.getName() + " " + s.getSex());
		}
		System.out.println();
		Set<Student> set = totalList.stream().filter(s -> s.getScore() >= 90).collect(Collectors.toSet());
		Map<String, Integer> map = totalList.stream().collect(Collectors.toMap(s -> s.getName(), s -> s.getScore()));
		System.out.println(map);
		
		Set<String> keySets = map.keySet();
		Iterator<String> iterator = keySets.iterator();
		while (iterator.hasNext()) {
			String key = iterator.next();
			System.out.println(key + " " + map.get(key));
		}
	}
}