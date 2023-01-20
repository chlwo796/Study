package ch05.day06;

import java.util.Scanner;

public class Ex09Again {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		boolean flage = true;
		int scount = 0; // 초기값
		int[] scores = null; // 공용되는 배열변수 선언

		while (flage) {
			System.out.println("-------------------------------------------------");
			System.out.println("1. 학생수 | 2. 점수입력 | 3. 점수리스트 : 4. 분석 | 5. 종료");
			System.out.println("-------------------------------------------------");
			System.out.print("선택 > ");
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
				System.out.println("메뉴가 잘못됐습니다(1~5)");
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
		System.out.println("최고점수 : " + max);
		System.out.println("평균점수 : " + avg);

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
		// 학생수
		System.out.print("학생수>");
		int scount = sc.nextInt();
		sc.nextLine();
		return scount;
	}

}
