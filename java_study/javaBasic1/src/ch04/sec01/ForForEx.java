package ch04.sec01;

public class ForForEx {

	public static void main(String[] args) {
		// for - for 중첩

//		for (int i = 1; i < 3; i++) {
//			for (int j = 1; j < 2; j++) {
//				System.out.println(i + " " + j);
//
//			}
//		}
//		for(int i = 2; i <= 4; i++) {	// 상위 for가 한번 참이면
//			for(int j = 5; j >=2; j--) {	// 하위 for의 조건이 거짓이 되어 종료될때까지 실행
//				System.out.println(i + " " + j + " ");
//			}
//			System.out.println();
//		}

//		아래와 같은 코드의 출력결과를 쓰시오

		System.out.println("--------");
		for (int i = 2; i <= 4; i++) { // i = 2, 3, 4 일때 하위 for 실행
			for (int j = 5; j >= i; j--) { // j >= 2, 3, 4 일때 실행
				System.out.println(i + " " + j + " "); // 행렬과 비슷한 결과물.
			}
			System.out.println();
		}

//		아래와 같은 코드의 출력결과를 쓰시오

		System.out.println("--------");
		for (int i = 1; i <= 5; i++) { // i = 1, 2, 3, 4, 5일때 하위 for 실행
			for (int j = 1; j < 9; j++) { // j = 1 ~ 8일때 실행
				System.out.println(i + " " + j + " ");
			}
		}

//		문제1 이렇게 출력해보기
//		[1,1][1,2][1,3]
//		[2,1][2,2][2,3]

		for (int i = 1; i <= 2; i++) {
			for (int j = 1; j <= 3; j++) {
				System.out.print("[" + i + "," + j + "]");
			}
			System.out.println();
		}

//		문제2 이렇게 출력해보기
//		[1,1,1][1,1,2]
//		[1,2,1][1,2,2]
//		[2,1,1][2,1,2]
//		[2,2,1][2,2,2]

		for (int i = 1; i <= 2; i++) {
			for (int j = 1; j <= 2; j++) {
				for (int k = 1; k <= 2; k++) {
					System.out.print("[" + i + "," + j + "," + k + "]");
				}
				System.out.println();
			}
		}

//		문제3 구구단 출력하기

		for (int i = 2; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				int k = i * j;
				System.out.print(i + " X " + j + " = " + k + "  ");
//				System.out.printf("%2d x%d = %3d", i, j, k);	// printf는 format형식으로 더 보기좋게 코딩할 수 있다.
			}
			System.out.println();
		}

//		문제4 구구단 세로로 출력

		for (int i = 1; i <= 9; i++) {
			for (int j = 2; j <= 9; j++) {
				int k = i * j;
				System.out.print(j + " X " + i + " = " + k + "   ");
			}
			System.out.println();
		}

	}

}
