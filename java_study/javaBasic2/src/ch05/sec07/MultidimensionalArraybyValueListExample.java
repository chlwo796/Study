package ch05.sec07;

public class MultidimensionalArraybyValueListExample {

	public static void main(String[] args) {
//		다차원배열

		int[][] scores = { { 80, 90, 96 }, { 76, 88 } };
		System.out.println(scores.length); // 점수 배열이 총 2열 -> 2
		System.out.println(scores[0].length); // 0열 각 점수 3개 -> 3
		System.out.println(scores[1].length); // 1열 점수 2개 -> 2

//		첫번째 반의 세번째 점수
		System.out.println(scores[0][2]);

//		두번째 반의 두번재 점수
		System.out.println(scores[1][1]);

//		첫번째 반의 평균점수
		int sum1 = 0;
		int ave1 = 0;
		for (int i = 0; i < scores[0].length; i++) {
			sum1 = sum1 + scores[0][i];
		}
		ave1 = sum1 / scores[0].length;
		System.out.println(ave1);

//		두번째 반의 평균점수
		int sum2 = 0;
		int ave2 = 0;
		for (int i = 0; i < scores[1].length; i++) {
			sum2 = sum2 + scores[1][i];
		}
		ave2 = sum2 / scores[1].length;
		System.out.println(ave2);

//		전체 평균구하기
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
