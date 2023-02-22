package javaChap12.example01;

import java.util.HashSet;

public class HashSetExample {
	public static void main(String[] args) {
		HashSet<Student> hashSet = new HashSet<Student>();
		
		hashSet.add(new Student(1, "홍길동"));
		System.out.println(hashSet.size());
		hashSet.add(new Student(1, "홍길동"));
		System.out.println(hashSet.size());
		// Student 클래스에서 동등비교과정을 생략하면 값이 같더라도 저장된다.
		hashSet.add(new Student(2, "홍길동"));
		System.out.println(hashSet.size());
	}
}