package ch02.sec10;

public class PrimitiveAndStringConversionExample {

	public static void main(String[] args) {
		// ���ڿ��� �⺻ Ÿ������ ��ȯ
		// String str = String.valueOf(�⺻Ÿ�԰�);
		int value1 = Integer.parseInt("10");		// 10�̶�� ���ڿ��� integer Ÿ������ value1 �� ����.
		double value2 = Double.parseDouble("3.141592");
		boolean value3 = Boolean.parseBoolean("true");
		
		System.out.println(value1);
		System.out.println(value2);
		System.out.println(value3);
		
		String str1 = String.valueOf(10);
		String str2 = String.valueOf(3.141592);
		String str3 = String.valueOf(true);
		
		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str3);
	}

}
