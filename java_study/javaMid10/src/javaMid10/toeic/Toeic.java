package javaMid10.toeic;

import java.util.Scanner;

public class Toeic {
	Scanner sc = new Scanner(System.in);
	int toeicScore;
//	boolean flag = true;
	String choice;
	void input() throws ScoreMinException, ScoreMaxException {
		// ������ �����ϰ� �ϴ� ���� ����.
		while (true) {
			System.out.println("����� ����������?");
			toeicScore = sc.nextInt();

			if (toeicScore < 0) {
				throw new ScoreMinException("0�� �̸��� ���������� ���� �� �����ϴ�.");
			} else if (toeicScore > 990) {
				throw new ScoreMaxException("990�� �ʰ��� ���������� ���� �� �����ϴ�.");
			} else {
				System.out.println("����� ���������� " + toeicScore + "�� �Դϴ�.");
			}
			sc.nextLine();
			System.out.println("����Ͻðڽ��ϱ�?(y/n)");
			choice = sc.nextLine();
			if(choice.equalsIgnoreCase("n")) {
				break;
			}
		}
	}
}
