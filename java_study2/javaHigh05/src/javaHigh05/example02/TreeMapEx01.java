package javaHigh05.example02;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapEx01 {

	public static void main(String[] args) {
		TreeMap<String, Integer> treeMap = new TreeMap<String, Integer>();

		treeMap.put("apple", 10);
		treeMap.put("forever", 60);
		treeMap.put("description", 20);
		treeMap.put("ever", 40);
		treeMap.put("zoo", 20);
		treeMap.put("base", 50);
		treeMap.put("guess", 110);
		treeMap.put("cherry", 70);
		
		Set<Entry<String, Integer>> entrySet = treeMap.entrySet();
		Iterator<Entry<String, Integer>> iterator = entrySet.iterator();
		
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
		// Ư�� Ű�� ���� �� ��������
		Entry<String, Integer> entry = null;
		entry = treeMap.firstEntry();
		System.out.println("���� �� �ܾ� " + entry.getKey() + entry.getValue());
		entry = treeMap.lastEntry();
		System.out.println("���� �� �ܾ� " + entry.getKey() + entry.getValue());
		entry = treeMap.lowerEntry("ever");
		System.out.println("ever�� �� �ܾ� " + entry.getKey());
		entry = treeMap.higherEntry("ever");
		System.out.println("ever�� �� �ܾ� " + entry.getKey());
		
		NavigableMap<String, Integer> navigableMap = treeMap.descendingMap();
		Set<Entry<String, Integer>> descendingEntry = navigableMap.entrySet();
		
		for(Entry<String, Integer> e : descendingEntry) {
			System.out.println(e);
		}
		System.out.println();
		// key�������� value�� �ڵ����� ȣ���ϴ� �ڵ�, �� ������ ���δ�.
		NavigableSet<String> navigableSet = treeMap.descendingKeySet();
		for(String s : navigableSet) {
			System.out.println(s + " = " + treeMap.get(s));
		}
		System.out.println();
		NavigableMap<String, Integer> subMap1 = treeMap.subMap("c", true, "h", true);
		Set<String> keySet = subMap1.keySet();
		for(String s : keySet) {
			System.out.println(s + " = " + subMap1.get(s));
		}
		System.out.println();
		for(Entry<String, Integer> e : subMap1.entrySet()) {
			System.out.println(e);
		}
	}
}