package ch04.sec01;

import java.util.Scanner;

public class ContinueEx {

	public static void main(String[] args) {
//		�ݺ���(while, do-while, for)�̳� ���ǹ�(if, switch-case)�� ����̶�� �Ѵ�.
//		break = ����� ��� �� ĭ ������ ���� ������, continue

		int a = 2;

		switch (a) {
		case 1:
			System.out.println("���Դϴ�");
			break;
		case 5:
			System.out.println("���Դϴ�");
			break;
		case 10:
			System.out.println("���Դϴ�");
			break;
		default:
			System.out.println("�� �� ���� ������ �� �Դϴ�");
		}

//		���� ȫ�浿 - �꿡 ��ϴ�. �̼��� - �ٴٿ� ��ϴ�. ������ - ������ ��ϴ�. �׿ܿ� ����� ���� ��ϴ�.

		String strA = "ȫ��";
		String strB = "�̼�";
		String strC = "����";

		switch (strA) {
		case "ȫ�浿":
			System.out.println("�꿡 ��ϴ�");
			break;
		}
		switch (strB) {
		case "�̼���":
			System.out.println("�ٴٿ� ��ϴ�");
			break;
		}
		switch (strC) {
		case "������":
			System.out.println("������ ��ϴ�");
			break;

		default:
			System.out.println("���� ��ϴ�");
			break; // �������� �ص� �ǰ� ���ص� �ȴ�.
		}
//		���� 3���� �Է¹޾Ƽ� ����� ���� �� 90�� �̻��̸� A, 80 B,.. F����ϱ�

		Scanner sc = new Scanner(System.in);
		int cnt = 0; // �Է� ���� ���� ���� ���� �ִ� ����
		int score;
		int sum = 0;
		while (cnt < 3) {
			System.out.print("������ �Է��ϼ���.");
			score = sc.nextInt();
			sum = sum + score;
			cnt++;
		}
		System.out.println("\n �հ�� " + sum);
		int avg = sum / cnt;
		System.out.println("\n ����� " + avg);
		System.out.println("\n ���� ������ " + cnt);

		String scoreStr = null; // �ſ� �߿�

		if (avg >= 90) {
			scoreStr = "A";
		} else if (80 <= avg) {
			scoreStr = "B";
		} else if (70 <= avg) {
			scoreStr = "C";
		} else {
			scoreStr = "F";
		}

		System.out.println(avg + "�����Դϴ�.");

		switch (avg / 10) { // ��������� 10���� ������ �������̶� �� 10�� �ڸ��� ��µȴ�.(�Ҽ�������) 90����, 80����, 70���� ..
		case 10:
			scoreStr = "A";
			break;
		case 9:
			scoreStr = "B";
			break;
		case 8:
			scoreStr = "C";
			break;
		default:
			scoreStr = "F";
		}

		System.out.println(scoreStr + "�����Դϴ�.");

		System.out.println("-------------------"); // ���� ó���� ¥�� ��
		System.out.print("ù��° ������ �Է��ϼ���.");
		int score1 = sc.nextInt();
		System.out.print("�ι�° ������ �Է��ϼ���.");
		int score2 = sc.nextInt();
		System.out.print("����° ������ �Է��ϼ���.");
		int score3 = sc.nextInt(); // �ݺ��� ��� ����

		int ave = (score1 + score2 + score3) / 3;
		String ave1 = null;

		if (ave >= 90) {
			ave1 = "A";
		} else if (80 <= ave && ave < 90) {
			ave1 = "B";
		} else if (70 <= ave && ave < 80) {
			ave1 = "C";
		} else {
			ave1 = "F";
		}

		System.out.println(ave1 + "�����Դϴ�.");

		switch (ave1) {
		case ("A"):
			System.out.println(ave1 + "�����Դϴ�.");
			break;
		}
		switch (ave1) {
		case ("A"):
			System.out.println(ave1 + "�����Դϴ�.");
			break;
		}
		switch (ave1) {
		case ("A"):
			System.out.println(ave1 + "�����Դϴ�.");
			break;
		}
		switch (ave1) {
		case ("A"):
			System.out.println(ave1 + "�����Դϴ�.");
			break;
		}

	}

}
