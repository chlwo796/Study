package ch02.sec02;

public class LongExample {

	public static void main(String[] args) {
		
		long v1 = 10;		// longŸ���� ���ڰ� ū ���α׷����� ����Ѵ�. ����, ���� ��.
		long v2 = 10L;
		// long v3 = 10000000000000;		// �⺻������ �����Ϸ��� ���� literal�� intŸ������ �����Ѵ�.
		long v4 = 10000000000000L;
		
		// Unresolved compilation problem: 
		// The literal 10000000000000 of type int is out of range
		// �� �����Ͽ����� �� ���ڸ� long Ÿ���� �ƴ� int Ÿ������ �����Ͽ� ����� ����.
		// �ڿ� L�� ���� longŸ���̶�� �����ؾ��Ѵ�.
		
		System.out.println(v1);
		System.out.println(v2);
		// System.out.println(v3);
		System.out.println(v4);

	}

}
