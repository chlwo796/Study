package javaBasic5.ex19;

import java.util.Scanner;

public class BankApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Account[] account = new Account[100];
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			System.out.println("-----------------------------------------------");
			System.out.println("1. 계좌생성 | 2. 계좌목록 | 3. 예금 | 4. 출금 | 5. 종료");
			System.out.println("-----------------------------------------------");
			System.out.println("선택>");
			String choice = sc.nextLine();
			switch (choice) {
			case "1": {System.out.println("계좌번호 : ");
			
			}
			case "2":
			case "3":
			case "4":
			case "5":
			default:
			}
		}
	}

}
