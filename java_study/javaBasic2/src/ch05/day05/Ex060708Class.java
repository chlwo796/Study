package ch05.day05;

public class Ex060708Class {

	public static void main(String[] args) {
//		Ȯ�ι���6�� ��°�� ����

		int[][] array = { { 95, 86 }, { 83, 92, 96 }, { 78, 83, 93, 87, 88 } };
		System.out.println(array.length); // 3
		System.out.println(array[2].length); // 5
		System.out.println(array[1].length);
//		Ȯ�ι��� 7�� �ִ밪 ���ϱ�(for)

		int[] array1 = { 1, 5, 3, 8, 2 };
		int max = 0;
		for (int i = 0; i < array1.length-1; i++) {
			if (max <= array1[i]) {
				max = array1[i];
			}
		}
		System.out.println(max);

//		Ȯ�ι��� 8�� array ��ü �հ� ��� ���ϱ�(��ø for)

		int sum = 0;
		int count = 0; // count ������ ���� for ����� ������ count++ ����� �ִ�!!
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				sum = sum + array[i][j];
			}
			count = count + array[i].length;
		}

		System.out.println(sum);
		System.out.println((double) (sum / count));

	}

}
