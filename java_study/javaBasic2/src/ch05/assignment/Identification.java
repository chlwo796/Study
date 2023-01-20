package ch05.assignment;

import java.util.Scanner;

public class Identification {

	public static void main(String[] args) {
//		주민등록번호에서 7번째 자리 (1,3 -> 남자), (2, 4 -> 여자)
//		생년월일을 잘라서 년도 구하기, 월 구하기, 일구하기

		Scanner sc = new Scanner(System.in);
		System.out.println("주민등록번호를 입력하세요.(\'-\'포함)");

		while (true) {

			String number = sc.nextLine();
			char gender = number.charAt(7);
			String year = number.substring(0, 2);
//			System.out.println(year);
			String month = number.substring(2, 4);
//			System.out.println(month);
			String day = number.substring(4, 6);
			if (number.length() != 14) {
				System.out.println("다시 입력하세요.>");
				continue;
			} else {
//			System.out.println(day);
				switch (gender) {
				case '1':
				case '3':
					System.out.println(year + "년 " + month + "월 " + day + "일생 남자입니다.");
					break;
				case '2':
				case '4':
					System.out.println(year + "년 " + month + "월 " + day + "일생 여자입니다.");
				default:
					System.out.print("잘못입력하셨습니다. 다시 입력하시겠습니까?(y/n)");
					String yn = sc.nextLine();
					if (yn.equals("y")) {
						continue;
					} else
						break;
				}
				System.out.println("종료합니다.");
				break;

			}
		}
		
//		수업시간에 한 것
		
//		String ssn = "880815-1234567";
//		String year = ssn.substring(0, 2);
//		String month = ssn.substring(2, 4);
//		String day = ssn.substring(4, 6);
//		System.out.println(year + "년 " + month + "월 " + day + "일");
//
//		String gender = ssn.substring(7);
//
//		int gValue = Integer.parseInt(gender);
//		if (gValue == 1 || gValue == 3) {
//			System.out.println("남자");
//		}
//		if (gValue == 2 || gValue == 4) {
//			System.out.println("여자");
//		}
//		if (gender.equals("1") || gender.equals("3")) {
//			System.out.println("남자");
//		}
//		if (gender.equals("2") || gender.equals("4")) {
//			System.out.println("여자");
//		}
	}
}