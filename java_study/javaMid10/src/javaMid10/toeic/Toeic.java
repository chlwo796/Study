package javaMid10.toeic;

import java.util.Scanner;

public class Toeic {
	Scanner sc = new Scanner(System.in);
	int toeicScore;
//	boolean flag = true;
	String choice;
	void input() throws ScoreMinException, ScoreMaxException {
		// 메인은 간단하게 하는 것이 좋다.
		while (true) {
			System.out.println("당신의 토익점수는?");
			toeicScore = sc.nextInt();

			if (toeicScore < 0) {
				throw new ScoreMinException("0점 미만의 토익점수는 나올 수 없습니다.");
			} else if (toeicScore > 990) {
				throw new ScoreMaxException("990점 초과한 토익점수는 나올 수 없습니다.");
			} else {
				System.out.println("당신의 토익점수는 " + toeicScore + "점 입니다.");
			}
			sc.nextLine();
			System.out.println("계속하시겠습니까?(y/n)");
			choice = sc.nextLine();
			if(choice.equalsIgnoreCase("n")) {
				break;
			}
		}
	}
}
