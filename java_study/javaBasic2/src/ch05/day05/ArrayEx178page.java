package ch05.day05;

public class ArrayEx178page {

	public static void main(String[] args) {
//		p.178

		int[][] scores = { { 80, 90, 96 }, { 76, 88 } }; // [80][90][96]
															// [76][88]

		System.out.println("배열의 길이 = " + scores.length); // 행의 개수가 출력된다.
		System.out.println("배열의 길이 0행의 열의 개수 = " + scores[0].length);
		System.out.println("배열의 길이 1행의 열의 개수 = " + scores[1].length);

//		첫번째 반의 세번째 점수 = 96

		System.out.println(scores[0][2]);

//		두번째 반의 두번째 점수 출력하기

		System.out.println(scores[1][1]);

//		첫번째 반의 평균 점수

//		int aveA = (scores[0][0] + scores[0][1] + scores[0][2])/3;
//		System.out.println(aveA);

		int sum = 0;
		for (int i = 0; i < scores[0].length; i++) {
			sum = sum + scores[0][i];
		}
		int aveA = sum / scores[0].length;
		System.out.println(aveA);

//		두번째 반의 평균

		int sumB = 0;
		for (int i = 0; i < scores[1].length; i++) {
			sumB = sumB + scores[1][i];
		}
		int aveB = sumB / scores[1].length;
		System.out.println(aveB);
		sumB = 0; // 아래 for를 위한 초기화
		for (int a : scores[1]) { // scores[1]의 배열값이 하나씩 int a에 들어가서 연산한다.
			sumB = sumB + a;
		}
		int aveC = sumB / scores[1].length;
		System.out.println(aveC);

//		p.187 배열 복사
		int[] oldIntArray = { 1, 2, 3 };

		int[] newIntArray = new int[5];

		for (int i = 0; i < oldIntArray.length; i++) {
			newIntArray[i] = oldIntArray[i];
		}

		for (int a : newIntArray) {
			System.out.print(a + " "); // 공백에 대한 처리 이해
		}

		int[] old = { 4, 5 }; // newIntArray 배열에 값 넣기 한번 더 해보기

		int[] newArr1 = new int[10]; // 10칸짜리 배열을 만들고 oldIntArray 복사하기
		System.arraycopy(oldIntArray, 0, newArr1, 0, oldIntArray.length);
//		oldIntArray배열의 0번째 index부터, 새로운 newArr1배열의 0번째 index부터, oldIntArray배열의 길이만큼 옮긴다.

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
