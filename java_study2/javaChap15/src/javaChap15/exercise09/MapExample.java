package javaChap15.exercise09;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class MapExample {
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String, Integer>();

		map.put("blue", 96);
		map.put("hong", 86);
		map.put("white", 92);

		String name = null;
		int maxScore = 0;
		int totalScore = 0;
		
		System.out.println("기본 map");
		Set<String> keySet1 = map.keySet();
		for (String key : keySet1) {
			System.out.println(key + " " + map.get(key));
			if (maxScore < map.get(key)) {
				name = key;
				maxScore = map.get(key);
			}
			totalScore += map.get(key);
		}
		System.out.println();
		System.out.println("9번 출력결과");
		System.out.println(name);
		System.out.println(maxScore);
		System.out.println(maxScore / map.size());
		System.out.println();
		TreeMap<String, Integer> treeMap = new TreeMap<>();
		treeMap.putAll(map);
		System.out.println("treeMap 변환");
		Set<String> keySet2 = treeMap.keySet();
		for (String key : keySet2) {
			System.out.println(key + " " + treeMap.get(key));
		}
		System.out.println();
	}
}
