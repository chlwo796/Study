package ch04.sec03;

import java.util.Scanner;

public class SwitchValueExample {

	public static void main(String[] args) {
//		grade�� ���� switch�� ������ score �� �����ϴ� ����
//		score1 : 80
//		score2 : 80

		Scanner sc = new Scanner(System.in);

		System.out.println("����� �Է��ϼ���>");
		String grade = sc.nextLine();

		while (true) {
			int score = 0;
			switch (grade) {
			case "a":
			case "A":
				score = 80;
				System.out.println(grade + "����� " + score + "���Դϴ�.");
				break;
			case "b":
			case "B":
				score = 70;
				System.out.println(grade + "����� " + score + "���Դϴ�.");
				break;
			case "c":
			case "C":
				score = 60;
				System.out.println(grade + "����� " + score + "���Դϴ�.");
				break;
			default:
				System.out.println("�߸��Է��ϼ̽��ϴ�");
				System.out.println("�ٽ� �Է����ּ���, Ȥ�� ���Ḧ ���Ͻø� \"����\"�� �Է��ϼ���.");
				String choice = sc.nextLine();
				if (choice.equals("����")) {
					break;
				} else grade = choice;
						continue;
			}break;
			
		}
//		grade�� ���ڿ� ��(���)�� ���� case �ȿ� �� ������ �����ϰ� ��°��� ������ �� �ִ�.
//		default ���� = �Է°��� ����� �ƴ϶�� �Է°��� �ٽ� ���� �� �ְ� �ϰ�
//		�� �Է°��� ���� �ٽ� while�� ��������, ���α׷��� �������� ������ �� �ְ� �ߴ�. if-else ������ ������ �����ϴ� ���� ����Ʈ
	}
}

