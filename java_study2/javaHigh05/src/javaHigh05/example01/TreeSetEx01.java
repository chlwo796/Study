package javaHigh05.example01;

import java.util.Iterator;
import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeSet;

public class TreeSetEx01 {
	public static void main(String[] args) {
		TreeSet<Integer> tree1 = new TreeSet<Integer>();

		tree1.add(4);
		tree1.add(7);
		tree1.add(4);
		tree1.add(0);
		tree1.add(8);
		tree1.add(9);
		tree1.add(2);

		System.out.println("Ʈ���� ��� �� ->" + tree1.size());
		System.out.println("���� ���� ��ü ->" + tree1.first());
		System.out.println("���� ���� ��ü ->" + tree1.last());
		System.out.println("7�� �ٷ� �Ʒ� ��ü ->" + tree1.lower(7));
		System.out.println("7�� �ٷ� �� ��ü ->" + tree1.higher(7));
		System.out.println("5�� ���� ��ü ->(������ �ٷ� �Ʒ� ��ü)" + tree1.floor(5));
		System.out.println("3�� ���� ��ü ->(������ �ٷ� �� ��ü)" + tree1.ceiling(3));
		System.out.println("���� ���� ��ü ������ �� ���� " + tree1.pollFirst());
		System.out.println("���� ���� ��ü ������ �� ���� " + tree1.pollLast());
		System.out.println("���� ���� ��ü ->" + tree1.first());
		System.out.println("���� ���� ��ü ->" + tree1.last());
		System.out.println("Ʈ���� ��� �� ->" + tree1.size());

		// ��������
		Iterator<Integer> iterator = tree1.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		System.out.println();
		// descendingIterator() = �ݴ����, ��������
		Iterator<Integer> iterator1 = tree1.descendingIterator();
		while (iterator1.hasNext()) {
			System.out.println(iterator1.next());
		}
		System.out.println();
		// NavigableSet = ���ĵ� Set
		NavigableSet<Integer> navigableSet = tree1.descendingSet();
		Iterator<Integer> iterator2 = navigableSet.iterator();

		while (iterator2.hasNext()) {
			System.out.println(iterator2.next());
		}
		System.out.println();
		System.out.println(navigableSet.first());
		System.out.println(navigableSet.floor(3));
		System.out.println();
		SortedSet<Integer> sortedSet1 = tree1.headSet(8);
		for (Integer i : sortedSet1) {
			System.out.println(i);
		}
		System.out.println();
		SortedSet<Integer> sortedSet2 = tree1.headSet(8, true);
		for (Integer i : sortedSet2) {
			System.out.println(i);
		}
		System.out.println();
		SortedSet<Integer> sortedSet3 = tree1.tailSet(4);
		for (Integer i : sortedSet3) {
			System.out.println(i);
		}
		System.out.println();
		SortedSet<Integer> sortedSet4 = tree1.subSet(2, true, 8, false);
		for (Integer i : sortedSet4) {
			System.out.println(i);
		}
		
	}
}
