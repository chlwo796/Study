package javaHigh02.example02;

import java.util.ArrayList;

public class ArrayListExample {
	public static void main(String[] args) {
//		정수타입은 Object클래스로 <Integer>로 분류한다.
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		for (int i = 1; i <= 10; i++) {
			list1.add(i);
		}
		for(int i = 0; i<list1.size();i++) {
			System.out.print(list1.get(i) + " ");
		}
		System.out.println();
		
//		5번 인덱스 위치에 값을 50으로 변경하기
		list1.set(5, 50);
		for(int i = 0; i<list1.size();i++) {
			System.out.print(list1.get(i) + " ");
		}
		System.out.println();
	}
}