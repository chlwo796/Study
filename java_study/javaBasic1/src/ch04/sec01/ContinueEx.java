package ch04.sec01;

import java.util.Scanner;

public class ContinueEx {

	public static void main(String[] args) {
//		반복문(while, do-while, for)이나 조건문(if, switch-case)을 제어문이라고 한다.
//		break = 제어문의 블록 한 칸 밖으로 빠져 나가라, continue

		int a = 2;

		switch (a) {
		case 1:
			System.out.println("일입니다");
			break;
		case 5:
			System.out.println("오입니다");
			break;
		case 10:
			System.out.println("십입니다");
			break;
		default:
			System.out.println("일 오 십을 제외한 다 입니다");
		}

//		문자 홍길동 - 산에 삽니다. 이순신 - 바다에 삽니다. 강감찬 - 평지에 삽니다. 그외에 사람은 집에 삽니다.

		String strA = "홍길";
		String strB = "이순";
		String strC = "강감";

		switch (strA) {
		case "홍길동":
			System.out.println("산에 삽니다");
			break;
		}
		switch (strB) {
		case "이순신":
			System.out.println("바다에 삽니다");
			break;
		}
		switch (strC) {
		case "강감찬":
			System.out.println("평지에 삽니다");
			break;

		default:
			System.out.println("집에 삽니다");
			break; // 마지막은 해도 되고 안해도 된다.
		}
//		숫자 3개를 입력받아서 평균을 구한 후 90점 이상이면 A, 80 B,.. F출력하기

		Scanner sc = new Scanner(System.in);
		int cnt = 0; // 입력 받은 점수 갯수 세어 주는 변수
		int score;
		int sum = 0;
		while (cnt < 3) {
			System.out.print("점수를 입력하세요.");
			score = sc.nextInt();
			sum = sum + score;
			cnt++;
		}
		System.out.println("\n 합계는 " + sum);
		int avg = sum / cnt;
		System.out.println("\n 평균은 " + avg);
		System.out.println("\n 과목 개수는 " + cnt);

		String scoreStr = null; // 매우 중요

		if (avg >= 90) {
			scoreStr = "A";
		} else if (80 <= avg) {
			scoreStr = "B";
		} else if (70 <= avg) {
			scoreStr = "C";
		} else {
			scoreStr = "F";
		}

		System.out.println(avg + "학점입니다.");

		switch (avg / 10) { // 평균점수를 10으로 나누면 정수형이라 각 10의 자리가 출력된다.(소수점생략) 90점대, 80점대, 70점대 ..
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

		System.out.println(scoreStr + "학점입니다.");

		System.out.println("-------------------"); // 내가 처음에 짜본 것
		System.out.print("첫번째 점수를 입력하세요.");
		int score1 = sc.nextInt();
		System.out.print("두번째 점수를 입력하세요.");
		int score2 = sc.nextInt();
		System.out.print("세번째 점수를 입력하세요.");
		int score3 = sc.nextInt(); // 반복문 사용 가능

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

		System.out.println(ave1 + "학점입니다.");

		switch (ave1) {
		case ("A"):
			System.out.println(ave1 + "학점입니다.");
			break;
		}
		switch (ave1) {
		case ("A"):
			System.out.println(ave1 + "학점입니다.");
			break;
		}
		switch (ave1) {
		case ("A"):
			System.out.println(ave1 + "학점입니다.");
			break;
		}
		switch (ave1) {
		case ("A"):
			System.out.println(ave1 + "학점입니다.");
			break;
		}

	}

}
