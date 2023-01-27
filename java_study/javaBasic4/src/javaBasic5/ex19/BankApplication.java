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
//			case "3":
//			case "4":
			case "5":
				run = false;
				break;
			default:
				System.out.println("잘못입력하셨습니다.");
				break;

			}

		}

	}

	public static void input() {

		int count = 0;
		Account account = new Account();
		System.out.println("-------");
		System.out.println("계좌생성");
		System.out.println("-------");
		while (true) {
			System.out.println("계좌번호 : ");
			String temp = sc.nextLine(); // 계좌번호 String 중복 검사를 위한 임시변수
			if (accountArray[0] != null) {
				for (int i = 0; i < accountArray.length; i++) {
					if ((accountArray[i].getAccount()).equals(temp)) {
						count++; // 배열 전체 검사 후 변하는 count 숫자로 조건문 컨트롤
						System.out.println("계좌번호 중복입니다. 다시 입력해주세요.");
						break;
					} // end if

				} // end for
			} // end if(초기값 있을때만 실행)
			if (count == 0) {
				account.setAccount(temp);
				break;
			}
		} // end while

		System.out.println("계좌주 : ");
		account.setName(sc.nextLine());
		System.out.println("초기입금액 : ");
		account.setBalance(sc.nextInt());
		sc.nextLine();

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
			System.out.printf("%-8s\t%s\t%d", accountArray[i].getAccount(), accountArray[i].getName(),
					accountArray[i].getBalance());
		}

	}
}
