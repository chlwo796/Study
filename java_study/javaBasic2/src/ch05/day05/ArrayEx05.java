package ch05.day05;

public class ArrayEx05 {

	public static void main(String[] args) {
//		다차원 배열(2차원을 많이 사용하고, 3차원, 4차원...도 있다)
		int[][] a = new int[2][3]; // 2행 3열 2x3
									// [][][]
									// [][][]
		a[0][0] = 5; // 0행의 0열에 5라는 값을 넣는다.
		a[1][1] = 10; // 1행의 1열에 10이라는 값을 넣는다.

		int[][] b = { { 1, 2, 3 }, { 4, 5, 6 } }; // 배열에 직접 값을 넣어주기
													// [1][2][3]
													// [4][5][6]

		int[][] c = { { 4, 3 }, { 5, 7 } }; // [4][3]
											// [5][7]

		int[][] d = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 } }; // [1][2][3][4]
														// [5][6][7][8]

		String[][] strA = { { "a", "b", "c" }, { "d", "e", "f" }, { "g", "h", "i" } };

//		3차원배열
		int[][][] f = { { { 1 }, { 2 } }, { { 3 }, { 4 } }, { { 5 }, { 6 } }, { { 7 }, { 8 } } };

//		b의 배열의 모습을 new

		int[][] arrayB = new int[2][3]; // 2행 3열
		int[][] arrayC = new int[2][2];
		int[][] arrayD = new int[2][4];

		String[][] arraystrA = new String[3][3];
		int[][][] arrayF = new int[4][2][1];
		
//		출력하기
		System.out.println(b[0][0] + " " + b[0][1] + " " + b[0][2]);
		System.out.println(b[1][0] + " " + b[1][1] + " " + b[1][2]);
		
		System.out.println(strA[0][0] + " " + strA[0][1] + " " + strA[0][2]);
		System.out.println(strA[1][0] + " " + strA[1][1] + " " + strA[1][2]);
		System.out.println(strA[2][0] + " " + strA[2][1] + " " + strA[2][2]);
		
		System.out.println(f[0][0][0]);
		System.out.println(f[0][1][0]);
		System.out.println(f[1][0][0]);
		System.out.println(f[1][1][0]);
		System.out.println(f[2][0][0]);
		System.out.println(f[2][1][0]);
		System.out.println(f[3][0][0]);
		System.out.println(f[3][1][0]);
	}

}
