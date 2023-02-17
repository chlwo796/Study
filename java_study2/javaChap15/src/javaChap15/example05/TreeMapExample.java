package javaChap15.example05;

import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class TreeMapExample {
	public static void main(String[] args) {
		TreeMap<String, Integer> treeMap1 = new TreeMap<String, Integer>();
		
		treeMap1.put("apple", 10);
		treeMap1.put("forever", 10);
		treeMap1.put("description", 10);
		treeMap1.put("ever", 10);
		treeMap1.put("zoo", 10);
		treeMap1.put("base", 10);
		treeMap1.put("guess", 10);
		treeMap1.put("cherry", 10);
		
		Set<Entry<String, Integer>> entrySet = treeMap1.entrySet();
		for(Entry<String, Integer> entry : entrySet) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
		
		SortedMap<String, Integer> sortedMap = null;
		Entry<String, Integer> entry = null;
		System.out.println("제일 앞 단어");
		entry = treeMap1.firstEntry();
		System.out.println(entry.getKey() + " " + entry.getValue());
		
		System.out.println("제일 뒤 단어");
		entry = treeMap1.lastEntry();
		System.out.println(entry.getKey() + " " + entry.getValue());
		System.out.println("ever 앞 단어");
		entry = treeMap1.lowerEntry("ever");
		System.out.println(entry.getKey() + " " + entry.getValue());
		
		System.out.println("description 뒤 단어");
		entry = treeMap1.higherEntry("description");
		System.out.println(entry.getKey() + " " + entry.getValue());
		
		System.out.println("d 뒤(높은) 단어들");
		sortedMap = treeMap1.tailMap("d");
		Set<Entry<String, Integer>> sortedSet = sortedMap.entrySet();
		for(Entry<String, Integer> sortedEntry : sortedSet) {
			System.out.println(sortedEntry.getKey() + " " + sortedEntry.getValue());
		}
		System.out.println("내림차순정렬");
		NavigableMap<String, Integer> navigableMap = treeMap1.descendingMap();
		for(Entry<String, Integer> entry1 : navigableMap.entrySet()) {
			System.out.println(entry1.getKey() + " " + entry1.getValue());
		}
		System.out.println("b(포함)~i 검색");
		NavigableMap<String, Integer> rangeMap = treeMap1.subMap("b", true, "i", false);
		for(Entry<String, Integer> entry2 : rangeMap.entrySet()) {
			System.out.println(entry2.getKey() + " " + entry2.getValue());
		}
		
	}
}
