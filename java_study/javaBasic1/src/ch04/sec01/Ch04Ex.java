package ch04.sec01;

import java.util.Scanner;

public class Ch04Ex {

	public static void main(String[] args) {
//		4�� Ȯ�ι���4
//		while (true) {
//			int a1 = ((int) (Math.random() * 6) + 1);
//			int a2 = ((int) (Math.random() * 6) + 1);
//			System.out.println("(" + a1 + ", " + a2 + ")");
//			if (a1 + a2 == 5) {
//				System.out.println("(" + a1 + ", " + a2 + ")");
//				break;
//			}
//		}

//		4�� Ȯ�ι���5

		for (int x = 1; x <= 10; x++) {
			for (int y = 1; y <= 10; y++) {
				if (4 * x + 5 * y == 60) {
					System.out.println("(" + x + ", " + y + ")");
				}
			}
		}

//		4�� Ȯ�ι���6
//		System.out.println("*");�� �ݺ��Ѵ�.

		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

//		4�� Ȯ�ι���7 �ſ��߿�.

		Scanner sc = new Scanner(System.in);
		String choice = null;
		int money = 0; // �Է¹޴� �� = �����Ǿ���.
		int balance = 0; // �ܾ׺���
		while (true) {
			System.out.println("-----------------------------------------");
			System.out.println("1. ���� | 2. ��� | 3. �ܰ� | 4. ��ü | 0. ����");
			System.out.println("------------------------------------------");
			System.out.print("����> ");
			choice = sc.nextLine();
			switch (choice) {
			case "1": {
				System.out.print("���ݾ�>");
				money = sc.nextInt();
				sc.nextLine();
				balance = balance + money;
				break;
			}
			case "2": {
				System.out.print("��ݾ�>");
				money = sc.nextInt();
				sc.nextLine();
				if (balance < money) {
					System.out.println("�ܾ׺���");
				} else {
					balance = balance - money;
				}
				break;
			}
			case "3": {
				System.out.print("�ܰ�>");
				System.out.println(balance);
				break;
			}
			case "4": {
				System.out.print("��ü�� ���¹�ȣ>");
				String account = sc.nextLine();
				System.out.print("��ü�� �ݾ�>");
				money = sc.nextInt();
				sc.nextLine();
				if (balance < money) {
					System.out.println("�ܾ׺���");
				} else {
					balance = balance - money;
					System.out.println(account + "���·� " + money + "�ݾ��� ��ü�Ǿ����ϴ�.\n�ܾ��� " + balance + "�Դϴ�.");
				}
				break;
			}
			case "0":
				System.out.println("���α׷� ����");
				break;
			default:
				System.out.println("�ٽ� �Է��ϼ���");
			}
			if (choice.equals("0"))
				break;

		}
	}
}
