package javaHigh06.exercise12;

public class IntegerCompareExample {
	public static void main(String[] args) {
		Integer obj1 = 100;
		int a = obj1;
		Integer obj2 = 100;
		int b = obj2;
		Integer obj3 = 300;
		int c = obj3;
		Integer obj4 = 300;
		int d = obj4;
		// ����Ÿ���� ��� -128~127�� ������� ���������� ������ ���� �� �ִ�.
		System.out.println(obj1.equals(obj2));
		System.out.println(obj3.equals(obj4));
		
		System.out.println(a == b);
		System.out.println(c == d);
	}
}
