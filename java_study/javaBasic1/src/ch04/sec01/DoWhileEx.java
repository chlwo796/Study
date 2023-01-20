package ch04.sec01;

import java.util.Scanner;

public class DoWhileEx {

	public static void main(String[] args) {
		// Do-While

//		do {
//			// �ݺ��� ���뾲��
//		}while(���ǹ�);

		// ���� 1, 2, 3, 4...10

		int a = 1;
		do {
			System.out.print(a + " ");
			a++;
		} while (a <= 10);

		System.out.println();

		// ����2 100 95 90 ...0

		int b = 100;
		do {
			System.out.print(b + " ");
			b = b - 5;
		} while (b >= 0); // b�� 0���� ũ�ų� �������ȸ� do ����

		System.out.println();

		// ����3 1~100������ �� 5050 ����ϱ�

		int c = 0;
		int sum = 0;
		do {
			c++;
			sum = sum + c;
		} while (c < 100);
		System.out.println(sum);

		// ����4 ¦���� ���� ���ϱ�

		int d = 0;
		int sum1 = 0;
		do {
			d = d + 2;
			sum1 = sum1 + (d);
		} while (d < 100);
		System.out.println(sum1);

		// ����5 1 1 2 3 5 �Ǻ���ġ

		int e = 1;
		int f = 1;
		int sum2 = e + f;
		System.out.print(e + " " + f + " " + sum2 + " ");
		do {
			e = f;
			f = sum2;
			sum2 = e + f;
			System.out.print(sum2 + " ");

		} while (sum2 < 34);

		// ����6 �̸��� ��� �޾Ƽ� ����ϴµ� �̸��� y�� ����

		Scanner sc = new Scanner(System.in);
		String name = null;

		do {
			System.out.print("�̸��� �Է��ϼ��� ==>");
			name = sc.next();
			System.out.print(name);
		} while (!name.equals("y"));		// �Է°��� y�� �ƴҵ��� do ����
		
	}

}
