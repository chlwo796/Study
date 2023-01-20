package ch04.sec03;

import java.util.Scanner;

public class SwitchValueExample {

	public static void main(String[] args) {
//		grade에 따라 switch된 변수를 score 에 대입하는 예제
//		score1 : 80
//		score2 : 80

		Scanner sc = new Scanner(System.in);

		System.out.println("등급을 입력하세요>");
		String grade = sc.nextLine();

		while (true) {
			int score = 0;
			switch (grade) {
			case "a":
			case "A":
				score = 80;
				System.out.println(grade + "등급은 " + score + "점입니다.");
				break;
			case "b":
			case "B":
				score = 70;
				System.out.println(grade + "등급은 " + score + "점입니다.");
				break;
			case "c":
			case "C":
				score = 60;
				System.out.println(grade + "등급은 " + score + "점입니다.");
				break;
			default:
				System.out.println("잘못입력하셨습니다");
				System.out.println("다시 입력해주세요, 혹은 종료를 원하시면 \"종료\"를 입력하세요.");
				String choice = sc.nextLine();
				if (choice.equals("종료")) {
					break;
				} else grade = choice;
						continue;
			}break;
			
		}
//		grade의 문자열 값(등급)에 따라서 case 안에 각 변수를 대입하고 출력값을 조정할 수 있다.
//		default 설명 = 입력값이 등급이 아니라면 입력값을 다시 넣을 수 있게 하고
//		그 입력값에 따라 다시 while을 실행할지, 프로그램을 종료할지 선택할 수 있게 했다. if-else 변수에 변수를 대입하는 것이 포인트
	}
}

