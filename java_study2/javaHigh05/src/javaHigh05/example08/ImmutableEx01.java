package javaHigh05.example08;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ImmutableEx01 {
	public static void main(String[] args) {
		List<String> list = List.of("A", "B", "C");
		
//		list.add("D");	// 오류
		System.out.println(list.size());
		
		for(String s : list) {
			System.out.println(s);
		}
		Set<String> set = Set.of("1", "2", "3");
		// HashSet 이 아니어서 중복값 처리가 자동으로 안됨.
		System.out.println(set.size());
		Iterator<String> iterator = set.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		Map<Integer, String> map = Map.of(1, "A", 2, "B", 3, "C");
		Set<Integer> keySet = map.keySet();
		
		for(Integer key : keySet) {
			System.out.println(key + " " + map.get(key));
		}
		Map<String, Integer> map1 = new HashMap<String, Integer>();
		map1.put("홍길동1", 100);
		map1.put("홍길동2", 80);
		map1.put("홍길동3", 70);
		map1.put("홍길동4", 80);
		
		Map<String, Integer> fixMap1 = Map.copyOf(map1);	// 고정
		System.out.println("Map 고정 전");
		map1.put("홍길동5", 50);
		System.out.println("Map에 데이터 추가");
		Set<String> keySet1 = map1.keySet();
		for(String key : keySet1) {
			System.out.println(key + " " + map1.get(key));
		}
		System.out.println("Map 고정 후");
//		fixMap1.put("홍길동6", 70); // 오류발생
		Set<String> fixkeySet1 = fixMap1.keySet();
		for(String fixKey : fixkeySet1) {
			System.out.println(fixKey + " " + fixMap1.get(fixKey));
		}
		System.out.println("엔트리로 출력");
		Set<Entry<String, Integer>> entrySet = map1.entrySet();
		
		for(Entry<String, Integer> entry : entrySet) {
			System.out.println(entry);
		}
	}
}
