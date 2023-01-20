package ch05.sec03;

public class ReferenceVariableCompareExample {

	public static void main(String[] args) {

		int[] array1;
		int[] array2;
		int[] array3;

		array1 = new int[] { 1, 2, 3 };
		array2 = new int[] { 1, 2, 3 };	// ������ ���ٰ� �ؼ� ���� �ּҷ� ����� ���� �ƴϴ�.
		
		array3 = array2;	//array3 �� array2�� �ּҸ� ����
		
		System.out.println(array1 == array2);
		System.out.println(array2 == array3);
		System.out.println(array1);
		System.out.println(array2);
		System.out.println(array3);
		
//		stack memory���� array1, array2, array3 ������ int[]Ÿ������ �������ִ�.
//		heap memory���� �迭 {1, 2, 3}�� ��ü�� ���� array1, array2�� �����Ѵ�.(���� �ּ�x)
//		�׷��� array1 == array2�� false�� ��µȴ�.
	}
}
