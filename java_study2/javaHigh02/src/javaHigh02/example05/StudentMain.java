package javaHigh02.example05;

import java.util.Iterator;
import java.util.Vector;

public class StudentMain {
	public static void main(String[] args) {
//		스레드 프로그램에서 이용되는 ArrayList와 동일한 컬렉션
//		스레드 프로그램에서 Vector를 사용한다는 것이 가장 중요하다.
		Vector<Student> vlist = new Vector<Student>();
		
		vlist.add(new Student("홍길동", 30));
		vlist.add(new Student("홍길동1", 60));
		vlist.add(new Student("홍길동2", 70));
		vlist.add(new Student("홍길동3", 80));
//		Iterator = 반복자
		Iterator<Student> it = vlist.iterator();
//		it.hasNext() = vlist에 어떤 주소를 가지고 있으면 true or false
//		it.next() = vlist에 제일 앞에 있는 주소를 가져온다.
		while(it.hasNext()) {
			Student st = it.next();
			System.out.println(st);
		}
		System.out.println("--------------");
		vlist.remove(2);
//		Iterator는 재사용 x
		it = vlist.iterator();
		while(it.hasNext()) {
			Student st = it.next();
			System.out.println(st);
		}
		boolean isE = vlist.isEmpty();
		if(isE) {
			System.out.println("아무것도 없습니다.");
		}else {
			System.out.println("있습니다.");
		}
	}
}