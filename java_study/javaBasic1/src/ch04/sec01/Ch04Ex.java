package ch04.sec01;

import java.util.Scanner;

public class Ch04Ex {

	public static void main(String[] args) {
//		4장 확인문제4
//		while (true) {
//			int a1 = ((int) (Math.random() * 6) + 1);
//			int a2 = ((int) (Math.random() * 6) + 1);
//			System.out.println("(" + a1 + ", " + a2 + ")");
//			if (a1 + a2 == 5) {
//				System.out.println("(" + a1 + ", " + a2 + ")");
//				break;
//			}
//		}

//		4장 확인문제5

		for (int x = 1; x <= 10; x++) {
			for (int y = 1; y <= 10; y++) {
				if (4 * x + 5 * y == 60) {
					System.out.println("(" + x + ", " + y + ")");
				}
			}
		}

//		4장 확인문제6
//		System.out.println("*");를 반복한다.

		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

//		4장 확인문제7 매우중요.

		Scanner sc = new Scanner(System.in);
		String choice = null;
		int money = 0; // 입력받는 돈 = 누적되야함.
		int balance = 0; // 잔액변수
		while (true) {
			System.out.println("-----------------------------------------");
			System.out.println("1. 예금 | 2. 출금 | 3. 잔고 | 4. 이체 | 0. 종료");
			System.out.println("------------------------------------------");
			System.out.print("선택> ");
			choice = sc.nextLine();
			switch (choice) {
			case "1": {
				System.out.print("예금액>");
				money = sc.nextInt();
				sc.nextLine();
				balance = balance + money;
				break;
			}
			case "2": {
				System.out.print("출금액>");
				money = sc.nextInt();
				sc.nextLine();
				if (balance < money) {
					System.out.println("잔액부족");
				} else {
					balance = balance - money;
				}
				break;
			}
			case "3": {
				System.out.print("잔고>");
				System.out.println(balance);
				break;
			}
			case "4": {
				System.out.print("이체할 계좌번호>");
				String account = sc.nextLine();
				System.out.print("이체할 금액>");
				money = sc.nextInt();
				sc.nextLine();
				if (balance < money) {
					System.out.println("잔액부족");
				} else {
					balance = balance - money;
					System.out.println(account + "계좌로 " + money + "금액이 이체되었습니다.\n잔액은 " + balance + "입니다.");
				}
				break;
			}
			case "0":
				System.out.println("프로그램 종료");
				break;
			default:
				System.out.println("다시 입력하세요");
			}
			if (choice.equals("0"))
				break;

		}
	}
}
