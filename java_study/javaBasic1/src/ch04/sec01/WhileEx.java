package ch04.sec01;

import java.util.Scanner;

public class WhileEx {

	public static void main(String[] args) {
		// while
		int n = 5;
		while (n == 5) {
			// ���� ������ ���̸� �̰��� ����, �����̸� while�� �����Ѵ�.
			System.out.println(n);
			n++; // n = n + 1
		} // end while
		int a = 10;
		while (a >= 5) {
			System.out.print(a + " ");
			// ������ ������ �Ǵϱ� �������� ������ �ǰ� �������Ѵ�.
			a--;
		} // end while

		System.out.println(); // �ٹٲ�

		// ���� 1 ~ 10 ���� ���
		int b = 1;
		while (b <= 10) {
			System.out.print(b++ + " ");
		} // end while

		System.out.println();

		// ���� 0 5 10 15 ~ 100
		int c = 0;
		while (c <= 100) {
			System.out.print(c + " ");
			c = c + 5;
		}

		System.out.println();

		// ���� -100 -50 0 50 100
		int d = -100;
		while (d <= 100) {
			System.out.print(d + " ");
			d = d + 50;
		}
		
		System.out.println();
		
		// ���� ABCD...Z���� ����ϱ�(65~90)
		char e = 'A';
//		int f = e;
		while (e <= 'Z') {
		System.out.print(e + " ");
		e++;	// �ڵ�����ȯ
		}
		
		System.out.println();
		
		// �л��̸��� 3�� �ݺ��ؼ� �Է¹ް� ����ϼ���
		Scanner sc = new Scanner(System.in);
		
//		System.out.print("�л� �̸��� ==>");
//		String name1 = sc.nextLine();
//		System.out.println(name1);
//		
//		System.out.print("�л� �̸��� ==>");
//		String name2 = sc.nextLine();
//		System.out.println(name2);
//		
//		System.out.print("�л� �̸��� ==>");
//		String name3 = sc.nextLine();
//		System.out.println(name3);
		// �̰��� �ݺ������� ��ġ�� 1ȸ ó���� ���� �����ִ� ������ �ʿ���.
		// ���ǹ��� ������ �ұ�? count������ 3�̸� ��, ó���� ������ �����ΰ�?
		
		int count = 1;	// �ʱⰪ ����. �������� ����
		String name = null;
		while(count <= 3) {
			System.out.print("�л� �̸��� ==>");
			name = sc.nextLine();
			System.out.println(name);
			count++;
		}
	} // end main()

} // end class
