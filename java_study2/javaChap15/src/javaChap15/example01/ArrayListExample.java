package javaChap15.example01;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class ArrayListExample {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Board> list = new ArrayList<Board>();

		list.add(new Board("����1", "����1", "�۾���1"));
		list.add(new Board("����2", "����2", "�۾���2"));
		list.add(new Board("����3", "����3", "�۾���3"));
		list.add(new Board("����4", "����4", "�۾���3"));
		list.add(new Board("����5", "����5", "�۾���4"));
		list.add(new Board("����4", "����5", "�۾���4"));
		list.add(new Board("����2", "����5", "�۾���4"));
		list.add(new Board("����6", "����6", "�۾���4"));
		
		System.out.println("�Խñ��� �� : " + list.size());
		System.out.println();
		
		System.out.println(list.get(3).getSubject() + "\t" + list.get(3).getContent() + "\t" + list.get(3).getWriter());
		System.out.println();
		
		for(int i = 0;i<list.size();i++) {
			System.out.println(list.get(i).getSubject() + "\t" + list.get(i).getContent() + "\t" + list.get(i).getWriter());
		}
		// �ι� ���� ������ ������ index2 ���� �� index3�̾��� �����Ͱ� 2�� ���� ����. ArrayList�� Ư��
		list.remove(2);
		list.remove(2);
		for(int i = 0;i<list.size();i++) {
			System.out.println(list.get(i).getSubject() + "\t" + list.get(i).getContent() + "\t" + list.get(i).getWriter());
		}
		System.out.println();

//		System.out.println("------------------------");
//		System.out.println("Set �÷������� ����");
//		Set<Board> set = new HashSet<Board>();
//		set.addAll(list);
//		
//		for(Board s : set) {
//			System.out.println(s.getSubject() + "\t" + s.getContent() + "\t" + s.getWriter());
//		}
		
		System.out.println("------------------------");
		System.out.println("TreeSet �÷������� ����");
		TreeSet<Board> treeSet = new TreeSet<Board>();
		treeSet.addAll(list);
		
		for(Board b : treeSet) {
			System.out.println(b.getSubject() + "\t" + b.getContent() + "\t" + b.getWriter());
		}
		
	}
}
