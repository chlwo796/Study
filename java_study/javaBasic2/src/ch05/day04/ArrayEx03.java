package ch05.day04;

import java.util.Scanner;

public class ArrayEx03 {

	public static void main(String[] args) {
//		2. �迭�� ���� �����ΰ� ���߿� ���� �ֱ�

		int[] a1 = new int[5]; // 5ĭ�� �迭�� ���� ��������(0~4)
		a1[0] = 10;
		a1[1] = 20;
		a1[2] = 30;
		a1[3] = 40;
		a1[4] = 50;
//		a1[5] = 60;	// arrayindexoutofbounds error

//		for (int a : a1) {
//			System.out.print(a + "\t");
//		}
//		Ű����� ���� 5�� �Է¹ް� �� ���ϱ�

//		Scanner sc = new Scanner(System.in);
//		int[] a2 = new int[5];
//		int sum = 0;
//		for(int i = 0; i<a2.length; i++) {
//			System.out.print((i+1) + "��° ���� �Է�>");	// 5���� �Է¹޴´�.
//			a2[i] = sc.nextInt();
//			sum = sum + a2[i];
//		}
//		System.out.println(sum);

//		�Է¹��� �����߿��� ���� ū ���ڴ�?
//		���� �������ڴ�?
		Scanner sc = new Scanner(System.in);

//		int[] a3 = new int[5];
//		int max = 0;
//		int min = 0; // �������� �ʱⰪ ���� �����غ���
//		for (int i = 0; i < a3.length; i++) {
//			System.out.print((i + 1) + "��° ���� �Է�>");
//			a3[i] = sc.nextInt();
//			if (max <= a3[i]) {
//				max = a3[i];
//			}	
//			if (min >= a3[i] || min == 0) {	// min == 0 ������ �ϳ� �߰��ؼ� �ʱⰪ�� 0�̴��� min = a3[0]�� ����ǵ��� ��..
//				min	= a3[i];	// �Է��� ���ڵ� �߿��� min(0)�� �׻� ���� ����. ������ ������ ������� ��� 0
//			}
//		}
//		System.out.println(max);
//		System.out.println(min);

		System.out.println();

//		���� ���ں��� �����ϱ�
		int[] a4 = new int[5];

		int temp;

		for (int i = 0; i < a4.length; i++) {
			System.out.print((i + 1) + "��° ���� �Է�>"); // 5���� �Է¹޴´�.
			a4[i] = sc.nextInt();
		}
		System.out.print("0ȸ���� =>");
		for (int a : a4) {
			System.out.print(a + "\t");
		}
		for (int i = 0; i < a4.length - 1; i++) {
			System.out.print("\n" + (i + 1) + "ȸ ���� =>");

			for (int j = i; j < a4.length; j++) { // i�� �ݺ�ȸ���� ������ �� j = i ��� �Ŀ��� j�� ����Ƚ���� ���δ�.
				if (a4[i] > a4[j]) { // i = j = 0�϶� �ʱⰪ a4[0]�� a4[0]������ � ���굵 �̷�� �����ʴ´�.!!!
					temp = a4[i];
					a4[i] = a4[j];
					a4[j] = temp;
//						System.out.println(j + "ȸ �Ϸ�");
//					System.out.println((j+1) + "ȸ ���� =>");
//					for (int a : a4) {
//						System.out.print(a + "\t");
//					}
				}
			}
			for (int a : a4) {
				System.out.print(a + "\t");
			}

		}
	}

}
