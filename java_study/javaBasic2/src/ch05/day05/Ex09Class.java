package ch05.day05;

import java.util.Scanner;

public class Ex09Class {
	static int stNumber; // 반드시 다시보자!! static 변수와 static method!!
	static int[] score; // static void method 에서는 static 변수로 지정해야 전역변수로 사용가능하다.
	static Scanner sc = new Scanner(System.in);	// edited point2 = method마다 scanner를 호출하는 것이 아닌 class소속field로 선언한다.

	public static void main(String[] args) {
//		확인문제 9번 학생수와 각 점수를 입력, while, Scanner, nextLine(), 최고점수 및 평균점수

		boolean flage = true;

		while (flage) {
			System.out.println("-----------------------------------------");
			System.out.println("1.학생수\t2.점수입력\t3.점수리스트\t4.분석\t5.종료");
			System.out.println("-----------------------------------------");
			System.out.print("선택>");
			String menu = sc.nextLine();

			switch (menu) {
			
			case "1":
				count();
				break;

			case "2":
				input();
				break;
			case "3":
				list();
				break;
			case "4":
				maxAve();
				break;
			case "5":
				flage = false;
				break;
			default:
				System.out.println("잘못입력하셨습니다.(1~5)");
			}
		}

	}

	public static void maxAve() {
		int max = 0;
		int sum = 0;
		double ave = 0.0;
		// TODO Auto-generated method stub
		for (int i = 0; i < score.length; i++) {
			if (max <= score[i]) {
				max = score[i];
			}
			sum = sum + score[i];
		}
		ave = sum / score.length;
		System.out.println("최고점수 : " + max);
		System.out.println("평균점수 : " + ave);
	}

	public static void list() {

		for (int i = 0; i < score.length; i++) {
			System.out.println("scores[" + i + "]: " + score[i]);
		}

	}

	public static void input() {

//		int[] score = new int[stNumber];	
//		Static 변수로 지정됐지만 int[] score를 했을 경우 전역변수로 score배열이 들어가지 않는다...list method실행시 nullpointerror..
//		아마 그말은 전역변수 score에 값을 넣지 않고 이 메소드만의 새로운 배열이 만들어지는 것이 아닐까..메소드가 많아지니 너무 어렵다..리턴을 score로 해줘도 안되더라
		score = new int[stNumber]; //
		for (int i = 0; i < stNumber; i++) {
			System.out.print("scores[" + i + "]>");
			score[i] = sc.nextInt();
		}
	}

	public static void count() {

		System.out.print("학생수>");
		stNumber = sc.nextInt();
	}
//	public static int count() {
//
//		System.out.print("학생수>");
//		stNumber = sc.nextInt();
//		return stNumber;
//	}
	

}
