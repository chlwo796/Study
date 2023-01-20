package ch05.day06;

import java.util.Scanner;

public class Ex09Again {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		boolean flage = true;
		int scount = 0; // �ʱⰪ
		int[] scores = null; // ����Ǵ� �迭���� ����

		while (flage) {
			System.out.println("-------------------------------------------------");
			System.out.println("1. �л��� | 2. �����Է� | 3. ��������Ʈ : 4. �м� | 5. ����");
			System.out.println("-------------------------------------------------");
			System.out.print("���� > ");
			String menu = sc.nextLine();

			switch (menu) {
			case "1":
				scount = studentCount();
				break;
			case "2":
				scores = input(scount);
				break;
			case "3":
				jumsulist(scores);
				break;
			case "4":
				analyze(scores);
				break;
			case "5":
				flage = false;
				break;
			default:
				System.out.println("�޴��� �߸��ƽ��ϴ�(1~5)");
			}
		}
		;

	}

	private static void analyze(int[] scores) {
		int sum = 0;
		double avg = 0.0;
		int max = 0;
		for (int i = 0; i < scores.length; i++) {
			sum += scores[i];
			if (max < scores[i]) {
				max = scores[i];
			}
		}
		avg = sum / scores.length;
		System.out.println("�ְ����� : " + max);
		System.out.println("������� : " + avg);

	}

	private static void jumsulist(int[] scores) {
		// TODO Auto-generated method stub
		for (int i = 0; i < scores.length; i++) {
			System.out.print("scores[" + i + "] : " + scores[i]);
		}

	}

	private static int[] input(int scount) {
		System.out.println();
		int[] scores = new int[scount];
		for (int i = 0; i < scount; i++) { // i=0,1,2
			System.out.print("scores[" + i + "]>");
			scores[i] = sc.nextInt();
			sc.nextLine();
		}
		return scores;
	}

	private static int studentCount() {
		// �л���
		System.out.print("�л���>");
		int scount = sc.nextInt();
		sc.nextLine();
		return scount;
	}

}
