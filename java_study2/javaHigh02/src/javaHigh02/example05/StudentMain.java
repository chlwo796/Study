package javaHigh02.example05;

import java.util.Iterator;
import java.util.Vector;

public class StudentMain {
	public static void main(String[] args) {
//		������ ���α׷����� �̿�Ǵ� ArrayList�� ������ �÷���
//		������ ���α׷����� Vector�� ����Ѵٴ� ���� ���� �߿��ϴ�.
		Vector<Student> vlist = new Vector<Student>();
		
		vlist.add(new Student("ȫ�浿", 30));
		vlist.add(new Student("ȫ�浿1", 60));
		vlist.add(new Student("ȫ�浿2", 70));
		vlist.add(new Student("ȫ�浿3", 80));
//		Iterator = �ݺ���
		Iterator<Student> it = vlist.iterator();
//		it.hasNext() = vlist�� � �ּҸ� ������ ������ true or false
//		it.next() = vlist�� ���� �տ� �ִ� �ּҸ� �����´�.
		while(it.hasNext()) {
			Student st = it.next();
			System.out.println(st);
		}
		System.out.println("--------------");
		vlist.remove(2);
//		Iterator�� ���� x
		it = vlist.iterator();
		while(it.hasNext()) {
			Student st = it.next();
			System.out.println(st);
		}
		boolean isE = vlist.isEmpty();
		if(isE) {
			System.out.println("�ƹ��͵� �����ϴ�.");
		}else {
			System.out.println("�ֽ��ϴ�.");
		}
	}
}