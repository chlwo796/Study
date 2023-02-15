package javaChap15.example01;

import java.util.ArrayList;
import java.util.List;

public class ArrayListExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Board> list = new ArrayList<Board>();

		list.add(new Board("����1", "����1", "�۾���1"));
		list.add(new Board("����2", "����2", "�۾���2"));
		list.add(new Board("����3", "����3", "�۾���3"));
		list.add(new Board("����4", "����4", "�۾���3"));
		list.add(new Board("����5", "����5", "�۾���4"));
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
		
		System.out.println();
		for(int i = 0;i<list.size();i++) {
			System.out.println(list.get(i).getSubject() + "\t" + list.get(i).getContent() + "\t" + list.get(i).getWriter());
		}
		System.out.println();
		for(Board b : list) {
			System.out.println(b.getSubject() + "\t" + b.getContent() + "\t" + b.getWriter());
		}
	}
}
