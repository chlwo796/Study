package javaBasic5.ex19;

import java.util.Scanner;

public class BankApplication extends Account {
	static Scanner sc = new Scanner(System.in);
	static Account[] accountArray = new Account[100];

	public static void main(String[] args) {
		boolean runMain = true;
		// TODO Auto-generated method stub
		while (runMain) {

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
			case "3":
				deposit();
				break;
			case "4":
				withdraw();
				break;
			case "5":
				runMain = false;
				break;
			default:
				System.out.println("�߸��Է��ϼ̽��ϴ�.");
				break;

			}

		}

	}

	public static void input() {
		Account account = new Account();
		System.out.println("-------");
		System.out.println("���»���");
		System.out.println("-------");
		while (true) {
			int count = 0;
			System.out.println("���¹�ȣ : ");
			String temp = sc.nextLine(); // ���¹�ȣ String �ߺ� �˻縦 ���� �ӽú���

			for (int i = 0; i < accountArray.length; i++) {
				if (accountArray[i] != null && temp.equals(accountArray[i].getAccount())) {
					count++; // �迭 ��ü �˻� �� ���ϴ� count ���ڷ� ���ǹ� ��Ʈ��
					System.out.println("���¹�ȣ �ߺ��Դϴ�. �ٽ� �Է����ּ���.");
					break;
				} // end if
			} // end for
				// end if(�ʱⰪ �������� ����)
			if (count == 0) {
				account.setAccount(temp);
				break;
			}
		} // end while

		System.out.println("������ : ");
		account.setName(sc.nextLine());

		while (true) {
			System.out.println("�ʱ��Աݾ� : ");
			int numberCheck = sc.nextInt();
			sc.nextLine();
			if (numberCheck < Account.MIN_BALANCE) {
				System.out.println("�Է°��� 0�̻��� �����Դϴ�. �ٽ� �Է����ּ���");
				continue;
			} else {
				account.setBalance(numberCheck);
				break;
			}
		}
		// setBalance���� ������ ������ ���Ѵ�.

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
			System.out.printf("%s\t%s\t%d\n", accountArray[i].getAccount(), accountArray[i].getName(),
					accountArray[i].getBalance());
		}

	}

	public static void deposit() {
		System.out.println("-------");
		System.out.println("����");
		System.out.println("-------");
		boolean runDeposit = true; // �ʱ� ���»����� ���ߴٸ� main method �� Ż��
//		���� ������ �Է¹ް� getbalance �� �� ������ ���Ѱ� ����->�ٽ� set. �ȵǴ� ��츦 �����غ���. -�����ΰ�� ����(Account class���� ������)
		int count1 = 0;
		for (int i = 0; i < accountArray.length; i++) {
			if (accountArray[i] != null) {
				count1++;
			}
		}
		if (count1 == 0) {
			System.out.println("���������� �����ϴ�. ���»��� ���� ���ּ���.");
			runDeposit = false;
		}
		while (runDeposit) {
			int count2 = 0;
			System.out.println("���¹�ȣ :");
			String inputAccount = sc.nextLine();
			System.out.println("���ݾ�");
			int deposit = sc.nextInt();
			sc.nextLine();

			if (deposit <= 0) {
				System.out.println("�߸��� �ݾ��Դϴ�(10~)");
				continue;
			}

			for (int i = 0; i < accountArray.length; i++) {
				if (accountArray[i] != null && inputAccount.equals(accountArray[i].getAccount())) {
					// count2 �� return���� 0�� 1�ۿ�����. input���� �����ߺ�, deposit���� ���°� �ƿ��������� ���������.
					if ((deposit + accountArray[i].getBalance()) > Account.MAX_BALANCE) {
						System.out.println("�ܾ��� ������ �ʰ��մϴ�. �ܾ��� Ȯ���ϼ���.");
						count2++;
						break;
					} else {
						accountArray[i].setBalance(deposit + accountArray[i].getBalance());
						System.out.println("���ݿϷ�");
						count2++;
						break;
					}
				}

			}
			if (count2 == 0) {
				System.out.println("���¹�ȣ�� ��ġ���� �ʽ��ϴ�. �ٽ� �Է����ּ���.");
				continue;
			}
			break;

		}
	}

	private static void withdraw() {
//		��ݸ޼ҵ�. �뷱���� �����ͼ� -�� �ȵ�.(input = getbalance���� ũ�� �ȵ�) �Է��� �ƿ� -�� �ȵ�
		System.out.println("-------");
		System.out.println("���");
		System.out.println("-------");
		boolean runWithdraw = true;
		int count3 = 0;
		for (int i = 0; i < accountArray.length; i++) {
			if (accountArray[i] != null) {
				count3++;
			}
		}
		if (count3 == 0) {
			System.out.println("���������� �����ϴ�. ���»��� ���� ���ּ���.");
			runWithdraw = false;
		}
		while (runWithdraw) {
			int count4 = 0;
			System.out.println("���¹�ȣ :");
			String inputAccount = sc.nextLine();
			System.out.println("��ݾ�");
			int withdraw = sc.nextInt();
			sc.nextLine();

			if (withdraw < 0) {
				System.out.println("�߸��� �ݾ��Դϴ�.(10~)");
				continue;
			}

			for (int i = 0; i < accountArray.length; i++) {
				if (accountArray[i] != null && inputAccount.equals(accountArray[i].getAccount())) {
					// return���� 0�� 1�ۿ�����. input���� �����ߺ�, deposit���� ���°� �ƿ��������� ���������.
					if ((accountArray[i].getBalance() - withdraw) < Account.MIN_BALANCE) {
						System.out.println("��ݺҰ�. �ܾ��� Ȯ���ϼ���.");
						count4++;
						break;
					} else {
						accountArray[i].setBalance(accountArray[i].getBalance() - withdraw);
						System.out.println(accountArray[i].getBalance());
						System.out.println("����� �����Ǿ����ϴ�.");
						count4++;
						break;
					}
				}

			}
			if (count4 == 0) {
				System.out.println("���¹�ȣ �����Դϴ�. �ٽ� �Է����ּ���.");
				continue;
			}
			break;

		}
	}

}
