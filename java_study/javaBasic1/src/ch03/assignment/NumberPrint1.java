package ch03.assignment;

import java.util.Scanner;

public class NumberPrint1 {

	public static void main(String[] args) {
		// ���� 2���� �Է� �޾Ƽ� ū ���ڸ� ����ϱ�

		Scanner sc = new Scanner(System.in);
		System.out.print("ù��° ���ڸ� �Է��ϼ��� : ");
		int number1 = sc.nextInt();
		System.out.print("�ι�° ���ڸ� �Է��ϼ��� : ");
		int number2 = sc.nextInt();

		int result = (number1 < number2) ? number2 : number1;
		System.out.println("�� �� ū ���ڴ� " + result + "�Դϴ�.");
		
//		if(number1<=number2) {
//			System.out.println("�� �� ū ���ڴ� " + number2 + "�Դϴ�.");
//		} else
//			System.out.println("�� �� ū ���ڴ� " + number1 + "�Դϴ�.");
		
	}

}
