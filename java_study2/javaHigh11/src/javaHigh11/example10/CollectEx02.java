package javaHigh11.example10;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class CollectEx02 {
	public static void main(String[] args) {
		List<Student> totalList = new ArrayList<Student>();
		totalList.add(new Student("ȫ�浿", "��", 92));
		totalList.add(new Student("�����", "��", 87));
		totalList.add(new Student("���ڹ�", "��", 94));
		totalList.add(new Student("���ؿ�", "��", 92));

		Map<String, Double> map = totalList.stream()
				.collect(Collectors.groupingBy(s -> s.getSex(), Collectors.averagingDouble(s -> s.getScore())));
		System.out.println(map);

		List<Student> totalList1 = new ArrayList<Student>();
		totalList1.add(new Student("ȫ�浿", "��", 92, "1�г�"));
		totalList1.add(new Student("�����", "��", 87, "2�г�"));
		totalList1.add(new Student("���ڹ�", "��", 94, "3�г�"));
		totalList1.add(new Student("���ؿ�", "��", 92, "2�г�"));
		totalList1.add(new Student("���ؿ�", "��", 91, "1�г�"));
		totalList1.add(new Student("���ڹ�", "��", 97, "3�г�"));

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