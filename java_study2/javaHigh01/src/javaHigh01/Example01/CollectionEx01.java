package javaHigh01.Example01;

import java.util.ArrayList;
import java.util.List;

public class CollectionEx01 {

	public static void main(String[] args) {

		ArrayList arrayList = new ArrayList();

//		1���� �迭�� �÷������� ����	
//		������, �� ���� ���
		List list1 = new ArrayList();
//		�迭�� ���� = �ѹ� �����ϸ� ���̸� ������ �� ���� ������, 
//		���� �����ϰ� �Ű��־���Ѵ�.
//		�߰��ϰų� �߰��� ������� ��쿡�� �����ϱ� �ſ� ��Ʊ� ������,
//		�޸𸮿� ȿ���� ���� �ʴ�.
		int[] n1 = new int[3];

		list1.add("a");
		list1.add("b");
		list1.add("c");
		list1.add("d");
		list1.add(12);

		System.out.println(list1.get(3));
		System.out.println("����ִ� ������ : " + list1.size());
		
//		"k"��� �ڷᰡ �ֳ���?
		int count = 0;
		for (int i = 0; i < list1.size(); i++) {
			if (list1.get(i).equals("k")) {
				System.out.println(list1.get(i));
				count++;
			}
		}
		if (count == 0) {
			System.out.println("�����ϴ�.");
		} else {
			System.out.println(" k �ֽ��ϴ�.");
		}
		
//		�迭�������� �� �÷����̱� ������ �ݺ����� ������� �ʴ��� �����ϰ� �����ϴ�
		if (list1.contains("k")) {
			System.out.println("�ֽ��ϴ�");
		} else {
			System.out.println("�����ϴ�.");
		}
	}
}