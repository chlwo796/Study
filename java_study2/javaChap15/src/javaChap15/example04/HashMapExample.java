package javaChap15.example04;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapExample {
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("홍길동0", 30);
		map.put("홍길동1", 90);
		map.put("홍길동2", 30);
		map.put("홍길동3", 30);
		map.put("홍길동2", 40);
		// 동일한 key가 있을경우 마지막 value만 저장
		System.out.println(map.size());
		// key 지정하여 value 출력
		System.out.println(map.get("홍길동2"));
		
		// keySet()으로 반복자 선언하여 전체출력(key->value)
		Set<String> keySet = map.keySet();
		
		Iterator<String> iterator = keySet.iterator();
		
		while(iterator.hasNext()) {
			String key = iterator.next();
			System.out.println(key + " " + map.get(key));
		}
		
		// entrySet()으로 entry 전체출력(entry = (key,value))
		Set<Entry<String, Integer>> entrySet = map.entrySet();
		
		Iterator<Entry<String, Integer>> iterator1 = entrySet.iterator();
		
		while(iterator1.hasNext()) {
			System.out.println(iterator1.next());
		}
		// key로 map에서 제거
		map.remove("홍길동1");
		System.out.println(map.size());
		// 반복자 재호출 후 출력
		iterator1 = entrySet.iterator();
		while(iterator1.hasNext()) {
			System.out.println(iterator1.next());
		}
	}
}
