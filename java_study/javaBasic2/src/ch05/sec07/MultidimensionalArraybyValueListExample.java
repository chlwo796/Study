package ch05.sec07;

public class MultidimensionalArraybyValueListExample {

	public static void main(String[] args) {
//		�������迭

		int[][] scores = { { 80, 90, 96 }, { 76, 88 } };
		System.out.println(scores.length); // ���� �迭�� �� 2�� -> 2
		System.out.println(scores[0].length); // 0�� �� ���� 3�� -> 3
		System.out.println(scores[1].length); // 1�� ���� 2�� -> 2

//		ù��° ���� ����° ����
		System.out.println(scores[0][2]);

//		�ι�° ���� �ι��� ����
		System.out.println(scores[1][1]);

//		ù��° ���� �������
		int sum1 = 0;
		int ave1 = 0;
		for (int i = 0; i < scores[0].length; i++) {
			sum1 = sum1 + scores[0][i];
		}
		ave1 = sum1 / scores[0].length;
		System.out.println(ave1);

//		�ι�° ���� �������
		int sum2 = 0;
		int ave2 = 0;
		for (int i = 0; i < scores[1].length; i++) {
			sum2 = sum2 + scores[1][i];
		}
		ave2 = sum2 / scores[1].length;
		System.out.println(ave2);

//		��ü ��ձ��ϱ�
		int sum3 = 0;
		int ave3 = 0;
		int length = 0;
		for (int i = 0; i < scores.length; i++) {
			for (int j = 0; j < scores[i].length; j++) {
				sum3 = sum3 + scores[i][j];
			}
			length = length + (scores[i].length);
		}
		ave3 = sum3 / length;
		System.out.println(ave3);
	}

}
