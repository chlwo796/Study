package javaMid9.ex09;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Score score = new Score();
//		boolean run = true;
		while (true) {
			System.out.println("���������� ġ����");
			score.setScore(sc.nextInt());
			sc.nextLine();
			try {
				score.check();

			} catch (ScoreMaxException | ScoreMinException e) {
				System.out.println(e.getMessage());
				break;
			}
			String choice = sc.nextLine();
			if (choice.equals("y") || choice.equals("Y")) {
				continue;
			} else if (choice.equals("n") || choice.equals("N")) {
				break;
			}
		}
	}
}
