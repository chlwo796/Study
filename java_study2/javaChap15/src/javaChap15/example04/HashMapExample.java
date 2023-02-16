package javaChap15.example04;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapExample {
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("ȫ�浿0", 30);
		map.put("ȫ�浿1", 90);
		map.put("ȫ�浿2", 30);
		map.put("ȫ�浿3", 30);
		map.put("ȫ�浿2", 40);
		// ������ key�� ������� ������ value�� ����
		System.out.println(map.size());
		// key �����Ͽ� value ���
		System.out.println(map.get("ȫ�浿2"));
		
		// keySet()���� �ݺ��� �����Ͽ� ��ü���(key->value)
		Set<String> keySet = map.keySet();
		
		Iterator<String> iterator = keySet.iterator();
		
		while(iterator.hasNext()) {
			String key = iterator.next();
			System.out.println(key + " " + map.get(key));
		}
		
		// entrySet()���� entry ��ü���(entry = (key,value))
		Set<Entry<String, Integer>> entrySet = map.entrySet();
		
		Iterator<Entry<String, Integer>> iterator1 = entrySet.iterator();
		
		while(iterator1.hasNext()) {
			System.out.println(iterator1.next());
		}
		// key�� map���� ����
		map.remove("ȫ�浿1");
		System.out.println(map.size());
		// �ݺ��� ��ȣ�� �� ���
		iterator1 = entrySet.iterator();
		while(iterator1.hasNext()) {
			System.out.println(iterator1.next());
		}
	}
}
