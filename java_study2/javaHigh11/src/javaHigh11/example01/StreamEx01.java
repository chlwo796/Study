package javaHigh11.example01;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class StreamEx01 {
	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		set.add("ȫ�浿");
		set.add("�ſ��");
		set.add("���ڹ�");

		Iterator<String> it = set.iterator();

		while (it.hasNext()) {
			System.out.println(it.next());
		}
		System.out.println("��Ʈ���̿�");
		set.stream().forEach(name -> System.out.println(name));
	}
}