package javaBasic5.ex19;

import java.util.Scanner;

public class BankApplication {
	static Scanner sc = new Scanner(System.in);
	static Account[] accountArray = new Account[100];

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		boolean run = true;
		while (run) {

			System.out.println("-----------------------------------------------");
			System.out.println("1. ���»��� | 2. ���¸�� | 3. ���� | 4. ��� | 5. ����");
			System.out.println("-----------------------------------------------");
			System.out.println("����>");
			String choice = sc.nextLine();
			switch (choice) {
			case "1":
				input();
				break;
			case "2":
				list();
				break;
//			case "3":
//			case "4":
			case "5":
				run = false;
				break;
			default:
				System.out.println("�߸��Է��ϼ̽��ϴ�.");
				break;

			}

		}

	}

	public static void input() {

		int count = 0;
		Account account = new Account();
		System.out.println("-------");
		System.out.println("���»���");
		System.out.println("-------");
		while (true) {
			System.out.println("���¹�ȣ : ");
			String temp = sc.nextLine(); // ���¹�ȣ String �ߺ� �˻縦 ���� �ӽú���
			if (accountArray[0] != null) {
				for (int i = 0; i < accountArray.length; i++) {
					if ((accountArray[i].getAccount()).equals(temp)) {
						count++; // �迭 ��ü �˻� �� ���ϴ� count ���ڷ� ���ǹ� ��Ʈ��
						System.out.println("���¹�ȣ �ߺ��Դϴ�. �ٽ� �Է����ּ���.");
						break;
					} // end if

				} // end for
			} // end if(�ʱⰪ �������� ����)
			if (count == 0) {
				account.setAccount(temp);
				break;
			}
		} // end while

		System.out.println("������ : ");
		account.setName(sc.nextLine());
		System.out.println("�ʱ��Աݾ� : ");
		account.setBalance(sc.nextInt());
		sc.nextLine();

		for (int i = 0; i < accountArray.length; i++) {

			if (accountArray[i] == null) {

				accountArray[i] = account;
				break;
			}

		}
		System.out.println("���°� �����Ǿ����ϴ�.");
	}

	public static void list() {
		System.out.println("-------");
		System.out.println("���¸��");
		System.out.println("-------");

		for (int i = 0; i < accountArray.length; i++) {
			if (accountArray[i] == null) {
				break;
			}
			System.out.printf("%-8s\t%s\t%d", accountArray[i].getAccount(), accountArray[i].getName(),
					accountArray[i].getBalance());
		}

	}
}
