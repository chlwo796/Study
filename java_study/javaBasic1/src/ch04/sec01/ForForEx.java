package ch04.sec01;

public class ForForEx {

	public static void main(String[] args) {
		// for - for ��ø

//		for (int i = 1; i < 3; i++) {
//			for (int j = 1; j < 2; j++) {
//				System.out.println(i + " " + j);
//
//			}
//		}
//		for(int i = 2; i <= 4; i++) {	// ���� for�� �ѹ� ���̸�
//			for(int j = 5; j >=2; j--) {	// ���� for�� ������ ������ �Ǿ� ����ɶ����� ����
//				System.out.println(i + " " + j + " ");
//			}
//			System.out.println();
//		}

//		�Ʒ��� ���� �ڵ��� ��°���� ���ÿ�

		System.out.println("--------");
		for (int i = 2; i <= 4; i++) { // i = 2, 3, 4 �϶� ���� for ����
			for (int j = 5; j >= i; j--) { // j >= 2, 3, 4 �϶� ����
				System.out.println(i + " " + j + " "); // ��İ� ����� �����.
			}
			System.out.println();
		}

//		�Ʒ��� ���� �ڵ��� ��°���� ���ÿ�

		System.out.println("--------");
		for (int i = 1; i <= 5; i++) { // i = 1, 2, 3, 4, 5�϶� ���� for ����
			for (int j = 1; j < 9; j++) { // j = 1 ~ 8�϶� ����
				System.out.println(i + " " + j + " ");
			}
		}

//		����1 �̷��� ����غ���
//		[1,1][1,2][1,3]
//		[2,1][2,2][2,3]

		for (int i = 1; i <= 2; i++) {
			for (int j = 1; j <= 3; j++) {
				System.out.print("[" + i + "," + j + "]");
			}
			System.out.println();
		}

//		����2 �̷��� ����غ���
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

//		����3 ������ ����ϱ�

		for (int i = 2; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				int k = i * j;
				System.out.print(i + " X " + j + " = " + k + "  ");
//				System.out.printf("%2d x%d = %3d", i, j, k);	// printf�� format�������� �� �������� �ڵ��� �� �ִ�.
			}
			System.out.println();
		}

//		����4 ������ ���η� ���

		for (int i = 1; i <= 9; i++) {
			for (int j = 2; j <= 9; j++) {
				int k = i * j;
				System.out.print(j + " X " + i + " = " + k + "   ");
			}
			System.out.println();
		}

	}

}
