package javaHigh02.example01;

import java.util.ArrayList;

public class ArrayListExample {

	public static void main(String[] args) {
//		ArrayList<Ÿ��> list = new ArrayList<Ÿ��>();
//		� Ÿ���� �������� �̸� ���ϴ� �۾�. ���׸�
		ArrayList<String> list1 = new ArrayList<String>();
		list1.add("ȫ�浿");
		list1.add("�̼���");
		list1.add("������");
//		1���ڸ��� "�ֿ�", "�̼���" �����ʹ� 2������ �з�����.
		list1.add(1, "�ֿ�");

		for (int i = 0; i < list1.size(); i++) {
			System.out.print(list1.get(i) + " ");

		}
		System.out.println();
//		�ݿ� ȫ�浿�� �ֳ���?
		System.out.println(list1.contains("ȫ�浿"));
		if (list1.contains("ȫ�浿")) {
			System.out.println("�ֽ��ϴ�.");
		} else
			System.out.println("�����ϴ�.");
//		���� �� �ֿ� ����
//		Object = ��ü�� ���Ѵ�.
//		list1.remove(Object o) or list1.remove(index)
		list1.remove("�ֿ�");
		for (int i = 0; i < list1.size(); i++) {
			System.out.print(list1.get(i) + " ");

		}
		System.out.println();
		list1.remove("������");
		for (int i = 0; i < list1.size(); i++) {
			System.out.print(list1.get(i) + " ");
		}
		System.out.println();
//		��ü����
		list1.clear();	
		for (int i = 0; i < list1.size(); i++) {
			System.out.print(list1.get(i) + " ");
		}
		System.out.println();
//		list1.isEmpty() = ����Ʈ�� ��������� true or false
		System.out.println(list1.isEmpty());
	}
}