package javaChap12.example04;

public class BoxingUnBoxingExample {
	public static void main(String[] args) {
		Integer obj = 100;
		System.out.println(obj.intValue());
		
		int value = obj;
		System.out.println(value);
		
		int result = obj + 100;	// obj �� ���� ��ڽ� �� ����
		System.out.println(result);
	}
}
