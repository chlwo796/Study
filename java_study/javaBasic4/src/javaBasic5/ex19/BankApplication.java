package javaBasic5.ex19;

import java.util.Scanner;

public class BankApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Account[] account = new Account[100];
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			System.out.println("-----------------------------------------------");
			System.out.println("1. ���»��� | 2. ���¸�� | 3. ���� | 4. ��� | 5. ����");
			System.out.println("-----------------------------------------------");
			System.out.println("����>");
			String choice = sc.nextLine();
			switch (choice) {
			case "1": {System.out.println("���¹�ȣ : ");
			
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
