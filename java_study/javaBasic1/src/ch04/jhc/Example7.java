package ch04.jhc;

import java.util.Scanner;

public class Example7 {

	public static void main(String[] args) {
//		while, Scanner, nextLine() Ű����� �Էµ� �����ͷ� ����, ���, ��ȸ, ���� ����� �����ϴ� �ڵ�

		Scanner scanner = new Scanner(System.in);
		int balance = 0;	// �ܰ�� ��� �����Ǿ�� �Ѵ�.
		while (true) {
			System.out.println("----------------------------------");
			System.out.println("1. ���� | 2. ��� | 3. �ܰ� | 4. ���� ");
			System.out.println("----------------------------------");
			System.out.print("����> ");
			String str = scanner.nextLine();

			if (str.equals("1")) {
				System.out.print("���ݾ�> ");
				String str1 = scanner.nextLine();
				int str1Int = Integer.parseInt(str1);
				balance = balance + str1Int;
				System.out.println("���ݾ� " + str1Int + "�� �Դϴ�.");
				continue;
			}
			if (str.equals("2")) {
				System.out.print("��ݾ�> ");
				String str2 = scanner.nextLine();
				int str2Int = Integer.parseInt(str2);
				if (balance < str2Int) {
					System.out.println("�ܾ׺����Դϴ�.");
				} else {
					balance = balance - str2Int;
					System.out.println("��ݾ� " + str2Int + "�� �Դϴ�.");
				}
				continue;

			}
			if (str.equals("3")) {
				System.out.print("�ܰ�> ");
				System.out.println("�ܰ� " + balance + "�� �Դϴ�.");
				continue;
			}
			if (str.equals("4")) {
				System.out.println();
				System.out.println("���α׷� ����");
				break;	// �ݺ��� ������ ������.
			}

		}

	}

}
