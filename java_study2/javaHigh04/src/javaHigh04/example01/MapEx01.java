package javaHigh04.example01;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapEx01 {

	public static void main(String[] args) {
		Map<String, Integer> map1 = new HashMap<String, Integer>();
		map1.put("��ǻ��", 200);
		map1.put("������", 50);
		map1.put("������", 210);
		map1.put("��������", 170);
		// key -> value
		System.out.println(map1.get("��ǻ��"));
		System.out.println(map1.get("������"));
		// ���忡 ������� �ֳ���?
		if (map1.containsKey("�����")) {
			System.out.println("�ֽ��ϴ�.");
		} else {
			System.out.println("�����ϴ�.");
		}
		System.out.println(map1);
		// 150���� �Ѵ� ���

		Set<String> set = map1.keySet(); // key -> set �÷���

		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		it = set.iterator();
		while (it.hasNext()) {
			String key = it.next();
			if (map1.get(key) > 150) {
				System.out.println(key + " " + map1.get(key));
			}
		}
		// 170����¥�� ǰ���� �ֽ��ϱ�?
		it = set.iterator();
		boolean check = true;
		while (it.hasNext()) {
			String key = it.next();
			if (map1.get(key)==170) {
				System.out.println(key + "�ֽ��ϴ�.");
				check = false;
			}
		}
		if(check) {
			System.out.println("�����ϴ�.");
		}

	}
}