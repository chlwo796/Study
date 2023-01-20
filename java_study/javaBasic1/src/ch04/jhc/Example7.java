package ch04.jhc;

import java.util.Scanner;

public class Example7 {

	public static void main(String[] args) {
//		while, Scanner, nextLine() 키보드로 입력된 데이터로 예금, 출금, 조회, 종료 기능을 제공하는 코드

		Scanner scanner = new Scanner(System.in);
		int balance = 0;	// 잔고는 계속 누적되어야 한다.
		while (true) {
			System.out.println("----------------------------------");
			System.out.println("1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료 ");
			System.out.println("----------------------------------");
			System.out.print("선택> ");
			String str = scanner.nextLine();

			if (str.equals("1")) {
				System.out.print("예금액> ");
				String str1 = scanner.nextLine();
				int str1Int = Integer.parseInt(str1);
				balance = balance + str1Int;
				System.out.println("예금액 " + str1Int + "원 입니다.");
				continue;
			}
			if (str.equals("2")) {
				System.out.print("출금액> ");
				String str2 = scanner.nextLine();
				int str2Int = Integer.parseInt(str2);
				if (balance < str2Int) {
					System.out.println("잔액부족입니다.");
				} else {
					balance = balance - str2Int;
					System.out.println("출금액 " + str2Int + "원 입니다.");
				}
				continue;

			}
			if (str.equals("3")) {
				System.out.print("잔고> ");
				System.out.println("잔고 " + balance + "원 입니다.");
				continue;
			}
			if (str.equals("4")) {
				System.out.println();
				System.out.println("프로그램 종료");
				break;	// 반복문 밖으로 나간다.
			}

		}

	}

}
