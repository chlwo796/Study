package ch05.sec06;

public class ArrayCreateByValueListExample2 {

	public static void main(String[] args) {
//		�迭�� ���� ������ ���� ���ǻ���.
//		�迭������ ���� �����ϱ� ������ �̸� �����ߴٸ�, �� ���ķδ� ���������� ���� ������ �� ����.

//		int[] array = null;
//		array = {1,2,3,4};	// �����߻�. �� ������ ����� ���ÿ� �̷������ �Ѵ�.

//		�� ���Ŀ� ���� ���� �ְ� �ʹٸ� �迭�� ���� �������Ѵ�.

		int[] array = null;
		System.out.println(array); // �ʱⰪ ����

		array = new int[] { 1, 2, 3, 4, 5 }; // ���� ���� ���� �־��ش�.
		for (int a : array) { // ���� for�� ���
			System.out.println(a + " ");
		}

		int[] array1;
		int sum = 0;
		array1 = new int[] { 1, 23, 4, 5, 9 };

		for (int i = 0; i < array1.length; i++) {
			sum = sum + array1[i];
		}
		System.out.println(sum);
		printItem(new int[8]);
	}

	private static void printItem(int[] array1) {
		// TODO Auto-generated method stub
		for (int i = 0; i < array1.length; i++) {
			System.out.println(array1[i]);
		}
	}

}
