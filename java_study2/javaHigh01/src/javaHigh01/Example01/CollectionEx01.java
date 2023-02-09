package javaHigh01.Example01;

import java.util.ArrayList;
import java.util.List;

public class CollectionEx01 {

	public static void main(String[] args) {

		ArrayList arrayList = new ArrayList();

//		1차원 배열을 컬렉션으로 만듬	
//		다형성, 더 많이 사용
		List list1 = new ArrayList();
//		배열의 단점 = 한번 선언하면 길이를 수정할 수 없기 때문에, 
//		새로 생성하고 옮겨주어야한다.
//		추가하거나 중간이 비어있을 경우에도 수정하기 매우 어렵기 때문에,
//		메모리외 효율이 좋지 않다.
		int[] n1 = new int[3];

		list1.add("a");
		list1.add("b");
		list1.add("c");
		list1.add("d");
		list1.add(12);

		System.out.println(list1.get(3));
		System.out.println("들어있는 개수는 : " + list1.size());
		
//		"k"라는 자료가 있나요?
		int count = 0;
		for (int i = 0; i < list1.size(); i++) {
			if (list1.get(i).equals("k")) {
				System.out.println(list1.get(i));
				count++;
			}
		}
		if (count == 0) {
			System.out.println("없습니다.");
		} else {
			System.out.println(" k 있습니다.");
		}
		
//		배열집합으로 된 컬렉션이기 때문에 반복문을 사용하지 않더라도 간단하게 가능하다
		if (list1.contains("k")) {
			System.out.println("있습니다");
		} else {
			System.out.println("없습니다.");
		}
	}
}