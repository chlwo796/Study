package ch03.assignment;

import java.util.Scanner;

public class NumberPrint2 {

	public static void main(String[] args) {
		// ���� 3���� �Է¹޾Ƽ� ���� ���ڸ� ����ϱ�

		Scanner sc = new Scanner(System.in);
		System.out.print("ù��° ���ڸ� �Է��ϼ��� : ");
		int number1 = sc.nextInt();
		System.out.print("�ι�° ���ڸ� �Է��ϼ��� : ");
		int number2 = sc.nextInt();
		System.out.print("����° ���ڸ� �Է��ϼ��� : ");
		int number3 = sc.nextInt();

		// ������ 3���� ���.

		// 1�� 2�� ���� �� ������� 3�̶� ���Ѵ�. 1�� 2���� �۴�, �� : �׷� 1�� 3���� �۾�? ���� : 2 ��. 1���. �ƴϿ�
		// 3���

		int result1 = (number1 < number2) ? number1 : number2; // 1�� 2�߿� �������ڸ� 3�� ���غ���.
		int result2 = (result1 < number3) ? result1 : number3;

//		System.out.println("���� ���� ���ڴ� " + result2 + "�Դϴ�.");
//
//		if (number1 <= number2 && number2 <= number3) {
//			System.out.println("���� ���� ���ڴ� " + number1 + "�Դϴ�.");
//		} 
//		else if (number2 <= number3 && number3 <= number1) {
//			System.out.println("���� ���� ���ڴ� " + number2 + "�Դϴ�.");
//		} 
//		else {
//			System.out.println("���� ���� ���ڴ� " + number3 + "�Դϴ�.");
//		}
	}
}
