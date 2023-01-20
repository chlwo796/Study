package ch02.sec03;

import java.util.Scanner;

public class Example2 {

	public static void main(String[] args) {

		// 이름 년도 입력 -> 나이를 출력하는 프로그램

		Scanner sc = new Scanner(System.in);
		System.out.println("----------------");
		System.out.println("나이 계산 프로그램");
		System.out.println("----------------");
		System.out.print("이름은==>");
		String naming = sc.next();
		System.out.print("태어난 년도는?==>");
		int birthDay = sc.nextInt();
		int age = 2023 - birthDay;

		System.out.println("귀하 " + naming + "의 나이는 " + age + "세 이십니다.");

		/*
		 * if(age <= 7) {//{}블록 처리를 안할 시 true라면 한줄만 코드 수행 System.out.print("유아입니다.");
		 * System.out.println(" 지원금 100만원을 받으세요."); } else if(8 <= age && age < 14) {
		 * System.out.print("어린이입니다."); System.out.println(" 지원금 30만원을 받으세요."); } else
		 * if(14 <= age && age < 20) { System.out.print("청소년입니다.");
		 * System.out.println(" 지원금 20만원을 받으세요."); } else if(20 <= age && age <61) {
		 * System.out.print("어른입니다."); System.out.println(" 지원금 20만원을 내세요."); } else {
		 * //마지막 조건은 if를 생략해도된다. System.out.print("노인입니다.");
		 * System.out.println(" 지원금 30만원을 받으세요."); }
		 */

		// ageType = 나이별 타입(유아, 어린이, ..) subsidy = 100, -20, 지원금 받는것 +, 내는것 -

		String ageType; // 나이별 타입 변수
		int subsidy; // 지원금 변수
		// String ageType = null; 객체 안에 아직 값을 넣지 않았다. 나중에 넣을 거야.
		// int subsidy = 0;

		/*
		 * if (age <= 7) { ageType = "유아"; subsidy = 100; } else if (8 <= age && age <
		 * 14) { ageType = "어린이"; subsidy = 30; } else if (14 <= age && age < 20) {
		 * ageType = "청소년"; subsidy = 20; } else if (20 <= age && age < 61) { ageType =
		 * "어른"; subsidy = -20;
		 * 
		 * } else { ageType = "노인"; subsidy = 30; }
		 */

		/*
		 * // int absSubsidy = Math.abs(subsidy);
		 * 
		 * // System.out.println("당신은 " + ageType + "입니다.");
		 * 
		 * // if (0<=subsidy) { // System.out.println("정부 지원금 " + absSubsidy +
		 * "만원을 받으세요."); // } // else { // System.out.println("정부 지원금 " + absSubsidy +
		 * "만원을 내세요."); // }
		 */

		if (age <= 7) {
			ageType = "유아";
			subsidy = 100;
		} else if (8 <= age && age < 14) {
			ageType = "어린이";
			subsidy = 30;
		} else if (14 <= age && age < 20) {
			ageType = "청소년";
			subsidy = 20;
		} else if (20 <= age && age < 61) {
			ageType = "어른";
			subsidy = -20;

		} else {
			ageType = "노인";
			subsidy = 30;
		}

		int absSubsidy = Math.abs(subsidy); // 절대값 Math Class
		
		System.out.println("당신은 " + ageType + "입니다.");

		/*
		 * 조건문에 변수를 문자열로 사용하고 싶은 경우 if (ageType.equals("어른")) {
		 * System.out.println("정부 지원금 " + absSubsidy + "만원을 내세요."); } else {
		 * System.out.println("정부 지원금 " + absSubsidy + "만원을 받으세요."); }
		 */
		if (0 <= subsidy) {
			System.out.println("정부 지원금 " + absSubsidy + "만원을 받으세요.");
		} else {
			System.out.println("정부 지원금 " + absSubsidy + "만원을 내세요.");
		}

		// 어른과 노인만 대상으로 집이 있습니까?
		// 집이 있으면 true, 없으면 false,
		// 어른이 집이 있는 사람은 10% 더 내기. 노인 집이 있으면 10% 덜 받기
		// 또는 = || 
		boolean house = true; //집 유무 변수

		if (ageType.equals("어른") || ageType.equals("노인")) {
			System.out.println("집이 있습니까?");
			house = sc.nextBoolean();
		}
		if(ageType.equals("어른") && house) {
			//어른이면서 집이 있으면
			absSubsidy = (int)(absSubsidy*1.1);
			
			System.out.println("정부 지원금 " + absSubsidy + "만원을 내세요.");
		}
		else if(ageType.equals("노인") && house) {
			absSubsidy = (int) (absSubsidy*0.9);
			System.out.println("정부 지원금 " + absSubsidy + "만원을 받으세요.");
		}
	}
}
