package javaChap16.example06;

public class Person {
	public void ordering(Comparable comparable) {
		String a = "ȫ�浿";
		String b = "��浿";
		
		int result = comparable.compare(a, b);
		
		if(result<0) {
			System.out.println(a + "�� " + b + "���� �տ� �ɴϴ�.");
		}else if(result == 0) {
			System.out.println(a + "�� " + b + "�� �����ϴ�.");
		}else {
			System.out.println(a + "�� " + b + "���� �ڿ� �ɴϴ�.");
		}
	}
}
