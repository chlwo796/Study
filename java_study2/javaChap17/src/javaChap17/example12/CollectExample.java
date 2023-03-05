package javaChap17.example12;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class CollectExample {
	public static void main(String[] args) {
		List<Student> totalList = new ArrayList<Student>();

		totalList.add(new Student("ȫ�浿", "��", 92));
		totalList.add(new Student("�����", "��", 87));
		totalList.add(new Student("���ڹ�", "��", 95));
		totalList.add(new Student("���ؿ�", "��", 82));

		List<Student> maleList = totalList.stream().filter(s -> s.getSex().equals("��")).collect(Collectors.toList());

		maleList.stream().forEach(s -> System.out.println(s.getName()));
		System.out.println();
		Map<String, Integer> map = totalList.stream().collect(Collectors.toMap(s -> s.getName(), s -> s.getScore()));

		Set<String> keySet = map.keySet();

		for (String key : keySet) {
			System.out.println(key + " " + map.get(key));
		}

		Map<String, List<Student>> map1 = totalList.stream().collect(Collectors.groupingBy(s -> s.getSex()));

		Set<String> keySet1 = map1.keySet();

		for (String key : keySet1) {
			System.out.println(key + " " + map1.get(key).get(0).getName() + " " + map1.get(key).get(1).getName());
		}
	}
}