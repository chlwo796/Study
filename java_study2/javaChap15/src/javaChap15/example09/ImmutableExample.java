package javaChap15.example09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ImmutableExample {
	public static void main(String[] args) {
		List<String> list = List.of("A", "B", "C");

//		list.add("D");	// 런타임오류(실행오류)발생, java.lang.UnsupportedOperationException

		Set<String> set = Set.of("A", "B", "C");

//		set.remove("A");// 런타임오류(실행오류)발생, java.lang.UnsupportedOperationException

		Map<Integer, String> map = Map.of(1, "A", 2, "B", 3, "C");

//		map.put(4, "D");// 런타임오류(실행오류)발생, java.lang.UnsupportedOperationException

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

		ArrayList<String> arrayList = new ArrayList<String>();

		arrayList.add("A");
		arrayList.add("B");
		arrayList.add("C");
		arrayList.add("D");

		List<String> list2 = List.copyOf(arrayList);

//		list2.add("B");// 런타임오류(실행오류)발생, java.lang.UnsupportedOperationException
		for (int i = 0; i < list2.size(); i++) {
			System.out.println(list2.get(i));
		}

		Set<String> hashSet = new HashSet<String>();

		hashSet.add("A");
		hashSet.add("B");
		hashSet.add("C");
		hashSet.add("D");

		Set<String> set2 = Set.copyOf(hashSet);

//		set2.add("E");// 런타임오류(실행오류)발생, java.lang.UnsupportedOperationException
		Map<Integer, String> hashMap = new HashMap<Integer, String>();

		hashMap.put(3, "A");
		hashMap.put(5, "M");
		hashMap.put(6, "C");
		hashMap.put(1, "D");

		Map<Integer, String> map2 = Map.copyOf(hashMap);

//		map2.clear();// 런타임오류(실행오류)발생, java.lang.UnsupportedOperationException

		String[] array = { "A", "B", "C", "D" };

		List<String> list3 = Arrays.asList(array);

		for (int i = 0; i < list3.size(); i++) {
			System.out.println(list3.get(i));
		}
	}
}
