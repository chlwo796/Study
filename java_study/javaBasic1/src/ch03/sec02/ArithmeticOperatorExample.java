package ch03.sec02;

public class ArithmeticOperatorExample {

	public static void main(String[] args) {
		// ��� ������
		// ��� �ǿ����ڰ� ����Ÿ���̸� ������ ����� int Ÿ���̴�.
		// ���� �ϳ��� long�̸� �������� long Ÿ��, �Ǽ�Ÿ���̸� �������� �Ǽ�Ÿ���̴�.

		byte value1 = 10;
		byte value2 = 4;
		int value3 = 3;
		long value4 = 100L;

		int result1 = value1 + value2;
		System.out.println(result1);

		long result2 = value1 + value2 + value3 * value4;
		System.out.println(result2);

		double result3 = (double) value1 / value2;
		System.out.println(result3);

		int result4 = value1 % value2;		// value1�� value2 �� ������ ���� ������ �� 
		System.out.println(result4);

	}

}
