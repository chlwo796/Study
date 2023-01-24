package ch05.sec07;

public class MultidimensionalArrayByNewExample {

	public static void main(String[] args) {
//		다차원배열

		int[][] mathScores = new int[2][3];

//		초기값 확인
		for (int i = 0; i < mathScores.length; i++) {
			for (int j = 0; j < mathScores[i].length; j++) {
				System.out.println(mathScores[i][j]);
			}
		}

//		각 점수 입력

		mathScores[0][0] = 80;
		mathScores[0][1] = 83;
		mathScores[0][2] = 85;
		mathScores[1][0] = 86;
		mathScores[1][1] = 90;
		mathScores[1][2] = 92;

//		전체 평균

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

//		각 반의 학생 수가 다를 경우 점수 저장을 위한 2차원 배열 생성
		int[][] englishScores = new int[2][]; // 총 두 반이다.
		englishScores[0] = new int[2]; // 1반 학생수 2명
		englishScores[1] = new int[3]; // 2반 학생수 3명

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
