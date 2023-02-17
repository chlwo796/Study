package javaHigh05.example06;

import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class ComparatorEx03 {
	public static void main(String[] args) {
		TreeMap<TeamName, Values> treeMap1 = new TreeMap<TeamName, Values>(new TeamNameComparator());

		treeMap1.put(new TeamName("강북영업"), new Values("서울본부", "백화점", 4460));
		treeMap1.put(new TeamName("강서영업"), new Values("서울본부", "쇼핑몰", 6500));
		treeMap1.put(new TeamName("강남영업"), new Values("서울본부", "백화점", 6800));
		treeMap1.put(new TeamName("강동영업"), new Values("서울본부", "쇼핑몰", 5580));
		treeMap1.put(new TeamName("분당영업"), new Values("경기본부", "쇼핑몰", 3560));
		System.out.println();
		System.out.println("기본 keySet()으로 실행");
		Set<TeamName> keySet = treeMap1.keySet();
		System.out.printf("%s\t%s\t%s\t%s\n", "소속", "부서명", "매장위치", "매출실적");
		for (TeamName t : keySet) {
			System.out.printf("%s\t%s\t%s\t%d\n", treeMap1.get(t).getRegion(), t.getTeamName(), treeMap1.get(t).getStore(), treeMap1.get(t).getSale());
		}
		System.out.println();
		System.out.println("iterator()로 실행");
		Iterator<TeamName> iterator = keySet.iterator();
		System.out.printf("%s\t%s\t%s\t%s\n", "소속", "부서명", "매장위치", "매출실적");
		while(iterator.hasNext()) {
			TeamName keys = iterator.next();
			System.out.printf("%s\t%s\t%s\t%d\n", treeMap1.get(keys).getRegion(), keys.getTeamName(), treeMap1.get(keys).getStore(), treeMap1.get(keys).getSale());
		}
		System.out.println();
		System.out.println("descendingKeySet()으로 실행");
		NavigableSet<TeamName> navigableKeySet= treeMap1.descendingKeySet();
		System.out.printf("%s\t%s\t%s\t%s\n", "소속", "부서명", "매장위치", "매출실적");
		for (TeamName t : navigableKeySet) {
			System.out.printf("%s\t%s\t%s\t%d\n", treeMap1.get(t).getRegion(), t.getTeamName(), treeMap1.get(t).getStore(), treeMap1.get(t).getSale());
		}
		System.out.println();
		System.out.print("Key(부서명) 검색>");
		Scanner sc = new Scanner(System.in);
		String searchKey = sc.nextLine();
		System.out.printf("%s\t%s\t%s\n", "부서명", "매장위치", "매출실적");
		for (TeamName t : keySet) {
			if(t.getTeamName().contains(searchKey)) {
				System.out.printf("%s\t%s\t%d\n", t.getTeamName(), treeMap1.get(t).getStore(), treeMap1.get(t).getSale());
			}
		}
		System.out.println();
		System.out.print("매출액 총 합 : ");
		int sum = 0;
		for (TeamName t : navigableKeySet) {
			sum += treeMap1.get(t).getSale();
		}
		System.out.println(sum);
		
	}
}
