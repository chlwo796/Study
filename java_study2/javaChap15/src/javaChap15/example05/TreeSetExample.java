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
		System.out.println("���� ���� ���� : " + treeSet.first());
		System.out.println("���� ���� ���� : " + treeSet.last());
		System.out.println("80�� �ٷ� �� ���� : " + treeSet.ceiling(80));
		System.out.println("80�� �ٷ� �Ʒ� ���� : " + treeSet.floor(80));
		System.out.println("70�� �ٷ� �Ʒ� ���� : " + treeSet.lower(70));
		System.out.println("50�� �ٷ� �� ���� : " + treeSet.higher(50));
		
		NavigableSet<Integer> navigableSet = treeSet.descendingSet();
		System.out.println("descendingSet()�� ������������ ����");
		for(Integer i : navigableSet) {
			System.out.println(i);
		}
		Iterator<Integer> iterator = treeSet.descendingIterator();
		System.out.println("descendingIterator()�� �������� ����");
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		System.out.println("�����˻� : 70�� �̸� ����");
		NavigableSet<Integer> navigableSet1 = treeSet.headSet(70, false);
		for(Integer i : navigableSet1) {
			System.out.println(i);
		}
		System.out.println("�����˻� : 80�� �̻� ����");
		NavigableSet<Integer> navigableSet2 = treeSet.tailSet(80, true);
		for(Integer i : navigableSet2) {
			System.out.println(i);
		}
		System.out.println("�����˻� : 80�� �ʰ�, 90�� ���� ����");
		NavigableSet<Integer> navigableSet3 = treeSet.subSet(80, false, 90, true);
		for(Integer i : navigableSet3) {
			System.out.println(i);
		}

	}

}
