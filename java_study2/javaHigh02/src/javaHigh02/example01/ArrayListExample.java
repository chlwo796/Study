package javaHigh02.example01;

import java.util.ArrayList;

public class ArrayListExample {

	public static void main(String[] args) {
//		ArrayList<타입> list = new ArrayList<타입>();
//		어떤 타입을 받을건지 미리 정하는 작업. 제네릭
		ArrayList<String> list1 = new ArrayList<String>();
		list1.add("홍길동");
		list1.add("이순신");
		list1.add("김유신");
//		1번자리에 "최영", "이순신" 데이터는 2번으로 밀려난다.
		list1.add(1, "최영");

		for (int i = 0; i < list1.size(); i++) {
			System.out.print(list1.get(i) + " ");

		}
		System.out.println();
//		반에 홍길동이 있나요?
		System.out.println(list1.contains("홍길동"));
		if (list1.contains("홍길동")) {
			System.out.println("있습니다.");
		} else
			System.out.println("없습니다.");
//		전학 간 최영 삭제
//		Object = 객체를 뜻한다.
//		list1.remove(Object o) or list1.remove(index)
		list1.remove("최영");
		for (int i = 0; i < list1.size(); i++) {
			System.out.print(list1.get(i) + " ");

		}
		System.out.println();
		list1.remove("김유신");
		for (int i = 0; i < list1.size(); i++) {
			System.out.print(list1.get(i) + " ");
		}
		System.out.println();
//		전체삭제
		list1.clear();	
		for (int i = 0; i < list1.size(); i++) {
			System.out.print(list1.get(i) + " ");
		}
		System.out.println();
//		list1.isEmpty() = 리스트가 비어있으면 true or false
		System.out.println(list1.isEmpty());
	}
}