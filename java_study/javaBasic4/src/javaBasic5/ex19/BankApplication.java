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
			System.out.println("1. 계좌생성 | 2. 계좌목록 | 3. 예금 | 4. 출금 | 5. 종료");
			System.out.println("-----------------------------------------------");
			System.out.println("선택>");
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
				System.out.println("잘못입력하셨습니다.");
				break;

			}

		}

	}

	public static void input() {
		Account account = new Account();
		System.out.println("-------");
		System.out.println("계좌생성");
		System.out.println("-------");
		while (true) {
			int count = 0;
			System.out.println("계좌번호 : ");
			String temp = sc.nextLine(); // 계좌번호 String 중복 검사를 위한 임시변수

			for (int i = 0; i < accountArray.length; i++) {
				if (accountArray[i] != null && temp.equals(accountArray[i].getAccount())) {
					count++; // 배열 전체 검사 후 변하는 count 숫자로 조건문 컨트롤
					System.out.println("계좌번호 중복입니다. 다시 입력해주세요.");
					break;
				} // end if
			} // end for
				// end if(초기값 있을때만 실행)
			if (count == 0) {
				account.setAccount(temp);
				break;
			}
		} // end while

		System.out.println("계좌주 : ");
		account.setName(sc.nextLine());

		while (true) {
			System.out.println("초기입금액 : ");
			int numberCheck = sc.nextInt();
			sc.nextLine();
			if (numberCheck < Account.MIN_BALANCE) {
				System.out.println("입력값은 0이상의 숫자입니다. 다시 입력해주세요");
				continue;
			} else {
				account.setBalance(numberCheck);
				break;
			}
		}
		// setBalance에서 음수면 리턴을 안한다.

		for (int i = 0; i < accountArray.length; i++) {

			if (accountArray[i] == null) {

				accountArray[i] = account;
				break;
			}

		}
		System.out.println("계좌가 생성되었습니다.");

	}

	public static void list() {
		System.out.println("-------");
		System.out.println("계좌목록");
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
		System.out.println("예금");
		System.out.println("-------");
		boolean runDeposit = true; // 초기 계좌생성을 안했다면 main method 로 탈출
//		예금 정수를 입력받고 getbalance 후 그 정수를 더한걸 리턴->다시 set. 안되는 경우를 생각해보자. -정수인경우 제외(Account class에서 제어중)
		int count1 = 0;
		for (int i = 0; i < accountArray.length; i++) {
			if (accountArray[i] != null) {
				count1++;
			}
		}
		if (count1 == 0) {
			System.out.println("계좌정보가 없습니다. 계좌생성 먼저 해주세요.");
			runDeposit = false;
		}
		while (runDeposit) {
			int count2 = 0;
			System.out.println("계좌번호 :");
			String inputAccount = sc.nextLine();
			System.out.println("예금액");
			int deposit = sc.nextInt();
			sc.nextLine();

			if (deposit <= 0) {
				System.out.println("잘못된 금액입니다(10~)");
				continue;
			}

			for (int i = 0; i < accountArray.length; i++) {
				if (accountArray[i] != null && inputAccount.equals(accountArray[i].getAccount())) {
					// count2 의 return값은 0과 1밖에없다. input에서 계좌중복, deposit에서 계좌가 아예없을때를 제어해줬다.
					if ((deposit + accountArray[i].getBalance()) > Account.MAX_BALANCE) {
						System.out.println("잔액이 범위를 초과합니다. 잔액을 확인하세요.");
						count2++;
						break;
					} else {
						accountArray[i].setBalance(deposit + accountArray[i].getBalance());
						System.out.println("예금완료");
						count2++;
						break;
					}
				}

			}
			if (count2 == 0) {
				System.out.println("계좌번호가 일치하지 않습니다. 다시 입력해주세요.");
				continue;
			}
			break;

		}
	}

	private static void withdraw() {
//		출금메소드. 밸런스를 가져와서 -면 안됨.(input = getbalance보다 크면 안됨) 입력이 아예 -면 안됨
		System.out.println("-------");
		System.out.println("출금");
		System.out.println("-------");
		boolean runWithdraw = true;
		int count3 = 0;
		for (int i = 0; i < accountArray.length; i++) {
			if (accountArray[i] != null) {
				count3++;
			}
		}
		if (count3 == 0) {
			System.out.println("계좌정보가 없습니다. 계좌생성 먼저 해주세요.");
			runWithdraw = false;
		}
		while (runWithdraw) {
			int count4 = 0;
			System.out.println("계좌번호 :");
			String inputAccount = sc.nextLine();
			System.out.println("출금액");
			int withdraw = sc.nextInt();
			sc.nextLine();

			if (withdraw < 0) {
				System.out.println("잘못된 금액입니다.(10~)");
				continue;
			}

			for (int i = 0; i < accountArray.length; i++) {
				if (accountArray[i] != null && inputAccount.equals(accountArray[i].getAccount())) {
					// return값은 0과 1밖에없다. input에서 계좌중복, deposit에서 계좌가 아예없을때를 제어해줬다.
					if ((accountArray[i].getBalance() - withdraw) < Account.MIN_BALANCE) {
						System.out.println("출금불가. 잔액을 확인하세요.");
						count4++;
						break;
					} else {
						accountArray[i].setBalance(accountArray[i].getBalance() - withdraw);
						System.out.println(accountArray[i].getBalance());
						System.out.println("출금이 성공되었습니다.");
						count4++;
						break;
					}
				}

			}
			if (count4 == 0) {
				System.out.println("계좌번호 오류입니다. 다시 입력해주세요.");
				continue;
			}
			break;

		}
	}

}
