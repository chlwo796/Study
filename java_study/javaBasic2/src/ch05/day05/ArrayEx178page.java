package ch05.day05;

public class ArrayEx178page {

	public static void main(String[] args) {
//		p.178

		int[][] scores = { { 80, 90, 96 }, { 76, 88 } }; // [80][90][96]
															// [76][88]

		System.out.println("�迭�� ���� = " + scores.length); // ���� ������ ��µȴ�.
		System.out.println("�迭�� ���� 0���� ���� ���� = " + scores[0].length);
		System.out.println("�迭�� ���� 1���� ���� ���� = " + scores[1].length);

//		ù��° ���� ����° ���� = 96

		System.out.println(scores[0][2]);

//		�ι�° ���� �ι�° ���� ����ϱ�

		System.out.println(scores[1][1]);

//		ù��° ���� ��� ����

//		int aveA = (scores[0][0] + scores[0][1] + scores[0][2])/3;
//		System.out.println(aveA);

		int sum = 0;
		for (int i = 0; i < scores[0].length; i++) {
			sum = sum + scores[0][i];
		}
		int aveA = sum / scores[0].length;
		System.out.println(aveA);

//		�ι�° ���� ���

		int sumB = 0;
		for (int i = 0; i < scores[1].length; i++) {
			sumB = sumB + scores[1][i];
		}
		int aveB = sumB / scores[1].length;
		System.out.println(aveB);
		sumB = 0; // �Ʒ� for�� ���� �ʱ�ȭ
		for (int a : scores[1]) { // scores[1]�� �迭���� �ϳ��� int a�� ���� �����Ѵ�.
			sumB = sumB + a;
		}
		int aveC = sumB / scores[1].length;
		System.out.println(aveC);

//		p.187 �迭 ����
		int[] oldIntArray = { 1, 2, 3 };

		int[] newIntArray = new int[5];

		for (int i = 0; i < oldIntArray.length; i++) {
			newIntArray[i] = oldIntArray[i];
		}

		for (int a : newIntArray) {
			System.out.print(a + " "); // ���鿡 ���� ó�� ����
		}

		int[] old = { 4, 5 }; // newIntArray �迭�� �� �ֱ� �ѹ� �� �غ���

		int[] newArr1 = new int[10]; // 10ĭ¥�� �迭�� ����� oldIntArray �����ϱ�
		System.arraycopy(oldIntArray, 0, newArr1, 0, oldIntArray.length);
//		oldIntArray�迭�� 0��° index����, ���ο� newArr1�迭�� 0��° index����, oldIntArray�迭�� ���̸�ŭ �ű��.

		System.out.println();
		for (int i = 0; i < newArr1.length; i++) {
			System.out.print(newArr1[i] + " ");
		}
		
//		ss = [10][25][30][35]
//		SS = [0][0][0][0][0][0][0] -> [0][0][10][25][30][35][0]
		
		int[] ss = {10, 25, 30, 35};
		int[] SS = new int[7];
		
		System.arraycopy(ss, 0, SS, 2, ss.length);
		for(int a : SS) {
			System.out.print(a + " ");
		}
	}

}
