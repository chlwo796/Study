package ch05.sec05;

import java.util.Scanner;

public class LengthExample {

	public static void main(String[] args) {
//		���ڿ��� ���� = .length(); 

//		String strA = "�ڹ� ���α׷���";
//		int length = strA.length();	// ���� ����, String -> int
//		
//		System.out.println(length);

		Scanner sc = new Scanner(System.in);

		System.out.println("�ֹε�Ϲ�ȣ�� �Է��ϼ���(\"-\"����)");
		String number = sc.nextLine();

		int lengthNumber = number.length();
		switch (lengthNumber) {
		case 14: {
			System.out.println("�°� �Է��ϼ̽��ϴ�.");
			break;
		}
		default: {
			System.out.println("�߸� �Է��ϼ̽��ϴ�.");
			break;
		}
		}

	}

}
