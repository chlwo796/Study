package ch05.sec07;

public class MultidimensionalArrayByNewExample {

	public static void main(String[] args) {
//		�������迭

		int[][] mathScores = new int[2][3];

//		�ʱⰪ Ȯ��
		for (int i = 0; i < mathScores.length; i++) {
			for (int j = 0; j < mathScores[i].length; j++) {
				System.out.println(mathScores[i][j]);
			}
		}

//		�� ���� �Է�

		mathScores[0][0] = 80;
		mathScores[0][1] = 83;
		mathScores[0][2] = 85;
		mathScores[1][0] = 86;
		mathScores[1][1] = 90;
		mathScores[1][2] = 92;

//		��ü ���

		int totalSum = 0;
		int totalLength = 0;

		for (int i = 0; i < mathScores.length; i++) {
			for (int j = 0; j < mathScores[i].length; j++) {
				totalSum = totalSum + mathScores[i][j];
			}
			totalLength = totalLength + mathScores[i].length;

		}
		int totalAve = totalSum / totalLength;
		System.out.println(totalAve);

//		�� ���� �л� ���� �ٸ� ��� ���� ������ ���� 2���� �迭 ����
		int[][] englishScores = new int[2][]; // �� �� ���̴�.
		englishScores[0] = new int[2]; // 1�� �л��� 2��
		englishScores[1] = new int[3]; // 2�� �л��� 3��

		for (int i = 0; i < englishScores.length; i++) {
			for (int j = 0; j < englishScores[i].length; j++) {
				System.out.println(englishScores[i][j]);
			}
		}

		englishScores[0][0] = 90;
		englishScores[0][1] = 91;
		englishScores[1][0] = 92;
		englishScores[1][1] = 93;
		englishScores[1][2] = 94;

		int englishSum = 0;
		int englishLength = 0;

		for (int i = 0; i < englishScores.length; i++) {
			for (int j = 0; j < englishScores[i].length; j++) {
				englishSum = englishSum + englishScores[i][j];
			}
			englishLength = englishLength + englishScores[i].length;
		}
		int englishAve = englishSum / englishLength;
		System.out.println(englishAve);
	}

}
