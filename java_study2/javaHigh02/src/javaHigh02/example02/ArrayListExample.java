package javaHigh02.example02;

import java.util.ArrayList;

public class ArrayListExample {
	public static void main(String[] args) {
//		����Ÿ���� ObjectŬ������ <Integer>�� �з��Ѵ�.
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		for (int i = 1; i <= 10; i++) {
			list1.add(i);
		}
		for(int i = 0; i<list1.size();i++) {
			System.out.print(list1.get(i) + " ");
		}
		System.out.println();
		
//		5�� �ε��� ��ġ�� ���� 50���� �����ϱ�
		list1.set(5, 50);
		for(int i = 0; i<list1.size();i++) {
			System.out.print(list1.get(i) + " ");
		}
		System.out.println();
	}
}