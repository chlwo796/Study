package ch05.day05;

public class ArrayEx05 {

	public static void main(String[] args) {
//		������ �迭(2������ ���� ����ϰ�, 3����, 4����...�� �ִ�)
		int[][] a = new int[2][3]; // 2�� 3�� 2x3
									// [][][]
									// [][][]
		a[0][0] = 5; // 0���� 0���� 5��� ���� �ִ´�.
		a[1][1] = 10; // 1���� 1���� 10�̶�� ���� �ִ´�.

		int[][] b = { { 1, 2, 3 }, { 4, 5, 6 } }; // �迭�� ���� ���� �־��ֱ�
													// [1][2][3]
													// [4][5][6]

		int[][] c = { { 4, 3 }, { 5, 7 } }; // [4][3]
											// [5][7]

		int[][] d = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 } }; // [1][2][3][4]
														// [5][6][7][8]

		String[][] strA = { { "a", "b", "c" }, { "d", "e", "f" }, { "g", "h", "i" } };

//		3�����迭
		int[][][] f = { { { 1 }, { 2 } }, { { 3 }, { 4 } }, { { 5 }, { 6 } }, { { 7 }, { 8 } } };

//		b�� �迭�� ����� new

		int[][] arrayB = new int[2][3]; // 2�� 3��
		int[][] arrayC = new int[2][2];
		int[][] arrayD = new int[2][4];

		String[][] arraystrA = new String[3][3];
		int[][][] arrayF = new int[4][2][1];
		
//		����ϱ�
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
