package javaChap15.example05;

import java.util.Iterator;
import java.util.NavigableSet;
import java.util.TreeSet;

public class TreeSetExample {

	public static void main(String[] args) {
		TreeSet<Integer> treeSet = new TreeSet<Integer>();
		
		treeSet.add(87);
		treeSet.add(98);
		treeSet.add(77);
		treeSet.add(39);
		treeSet.add(90);
		treeSet.add(100);
		
		for(Integer i : treeSet) {
			System.out.println(i);
		}
		System.out.println();
		System.out.println("가장 낮은 점수 : " + treeSet.first());
		System.out.println("가장 높은 점수 : " + treeSet.last());
		System.out.println("80점 바로 위 점수 : " + treeSet.ceiling(80));
		System.out.println("80점 바로 아래 점수 : " + treeSet.floor(80));
		System.out.println("70점 바로 아래 점수 : " + treeSet.lower(70));
		System.out.println("50점 바로 위 점수 : " + treeSet.higher(50));
		
		NavigableSet<Integer> navigableSet = treeSet.descendingSet();
		System.out.println("descendingSet()로 내림차순으로 변경");
		for(Integer i : navigableSet) {
			System.out.println(i);
		}
		Iterator<Integer> iterator = treeSet.descendingIterator();
		System.out.println("descendingIterator()로 내림차순 변경");
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		System.out.println("범위검색 : 70점 미만 점수");
		NavigableSet<Integer> navigableSet1 = treeSet.headSet(70, false);
		for(Integer i : navigableSet1) {
			System.out.println(i);
		}
		System.out.println("범위검색 : 80점 이상 점수");
		NavigableSet<Integer> navigableSet2 = treeSet.tailSet(80, true);
		for(Integer i : navigableSet2) {
			System.out.println(i);
		}
		System.out.println("범위검색 : 80점 초과, 90점 이하 점수");
		NavigableSet<Integer> navigableSet3 = treeSet.subSet(80, false, 90, true);
		for(Integer i : navigableSet3) {
			System.out.println(i);
		}

	}

}
