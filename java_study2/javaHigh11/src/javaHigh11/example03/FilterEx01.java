package javaHigh11.example03;

import java.util.ArrayList;
import java.util.List;

public class FilterEx01 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("ȫ�浿");
		list.add("�ſ��");
		list.add("�Ź�ö");
		list.add("�ſ��");
		list.add("���ڹ�");
		// �ߺ�����
		list.stream().distinct().forEach(name -> System.out.println(name));
		System.out.println();
		// filter �޼ҵ��� matches �޼ҵ�
		list.stream().filter(n -> n.matches("���ڹ�")).forEach(n -> System.out.println(n));
		System.out.println();
		list.stream().filter(n->n.startsWith("��")).forEach(n->System.out.println(n));
		System.out.println();
		list.stream().distinct().filter(n->n.startsWith("��")).forEach(n->System.out.println(n));
	}
}