package ch05.sec06;

public class ArrayLengthExample {

	public static void main(String[] args) {
//		�迭�� ����, �迭 �ݺ����� �ſ� ���� ���

		int[] intArray1 = new int[] { 3, 18, 123 };
		int sum = 0;
		int ave = 0;
		for (int i = 0; i < intArray1.length; i++) {
			sum = sum + intArray1[i];
		}
		System.out.println(sum);
		ave = sum / intArray1.length;
		System.out.println(ave);
	}

}
