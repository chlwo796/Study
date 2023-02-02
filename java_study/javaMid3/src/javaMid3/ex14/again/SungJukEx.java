package javaMid3.ex14.again;

import java.util.Scanner;

public class SungJukEx {

	static Scanner sc = null;
	static String choice = null;
	static SungjukBusiness sb;

	public static void main(String[] args) {
		boolean run = false;
		sc = new Scanner(System.in);
		SungJuk e1 = new ElemantaryStudent();
		SungJuk m1 = new MiddleSchooler();
		SungJuk h1 = new HighSchoolStudent();
		sb = new SungjukBusiness();
		do {
			System.out.println("----------------------------------------");
			System.out.println("1. 초등학교 | 2. 중학교 | 3. 고등학교 | 4. 종료");
			System.out.println("----------------------------------------");
			System.out.println("선택>");
			choice = sc.nextLine();
			switch (choice) {
			case "1":
				elementaryStudent(e1);
				break;
			case "2":
				middleSchooler(m1);

				break;
			case "3":
				HischoolStudent(h1);
				break;
			case "4":
				run = true;
				break;
			default:
				System.out.println("잘못입력하셨습니다.(1~3)");
				break;
			}

		} while (!run);
	}

	private static void HischoolStudent(SungJuk h1) {
		choice = null;
		boolean run = false;
		do {
			System.out.println("-------------------");
			System.out.println("고등학교 성적관리 프로그램");
			System.out.println("--------------------");
			System.out.println("1. 입력 | 2. 출력 | 3. 메인돌아가기");
			choice = sc.nextLine();
			switch (choice) {
			case "1":
				sb.input(h1);
				break;
			case "2":
				sb.output(h1);
				break;
			case "3":
				run = true;
				break;

			default:
				System.out.println("잘못입력하셨습니다.(1~2)");
				break;
			}

		} while (!run);
	}

	private static void middleSchooler(SungJuk m1) {
		choice = null;
		boolean run = false;
		do {
			System.out.println("-------------------");
			System.out.println("중학교 성적관리 프로그램");
			System.out.println("--------------------");
			System.out.println("1. 입력 | 2. 출력 | 3. 메인돌아가기");
			choice = sc.nextLine();
			switch (choice) {
			case "1":
				sb.input(m1);
				break;
			case "2":
				sb.output(m1);
				break;
			case "3":
				run = true;
				break;

			default:
				System.out.println("잘못입력하셨습니다.(1~2)");
				break;
			}

		} while (!run);

	}

	private static void elementaryStudent(SungJuk sj) {
		choice = null;
		boolean run = false;
		do {
			System.out.println("-------------------");
			System.out.println("초등학교 성적관리 프로그램");
			System.out.println("--------------------");
			System.out.println("1. 입력 | 2. 출력 | 3. 메인돌아가기");
			choice = sc.nextLine();
			switch (choice) {
			case "1":
				sb.input(sj);
				break;
			case "2":
				sb.output(sj);
				break;
			case "3":
				run = true;
				break;

			default:
				System.out.println("잘못입력하셨습니다.(1~2)");
				break;
			}

		} while (!run);

	}
}