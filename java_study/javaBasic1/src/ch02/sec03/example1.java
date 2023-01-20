package ch02.sec03;

import java.util.Scanner;

public class example1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("당신의 몸무게는?");
		double weight = sc.nextDouble();
		System.out.print("당신의 키는?");
		double heightCm = sc.nextDouble();
		System.out.print("당신의 성별은 (남자면 true, 여자면 false) 입력하세요.");
		boolean gender = sc.nextBoolean();

		if (true)
			System.out.println("남자");
		else 
			System.out.println("여자");

		double bmi = weight/(heightCm*heightCm*0.0001);

		System.out.println("-----------------------");
		System.out.println("bmi = "+bmi);

		/*
		 * if(bmi>=25) { //논리연산 = 한번에 하나 연산 System.out.println("비만입니다."); } else
		 * if(bmi>=23) { System.out.println("과체중입니다."); } else if(bmi>=18.5) {
		 * System.out.println("정상입니다."); } else { System.out.println("저체중입니다."); }
		 */

		/*
		 * if(bmi < 18.5) { System.out.println("저체중입니다."); } if(18.5 <= bmi && bmi < 23)
		 * { //&& = 그리고,and System.out.println("정상입니다."); } if(23 <= bmi && bmi < 25 ) {
		 * System.out.println("과체중입니다."); } if(25 <= bmi) {
		 * System.out.println("비만입니다."); }
		 */ 
		//if문을 연속해서 사용하는 경우 true인 경우라도 계속 if문을 실행한다. 비효율적
		//else if로 중첩한다.
		if(bmi < 18.5) {
			System.out.println("저체중입니다.");
		}
		else if(18.5 <= bmi && bmi < 23) { //&& = 그리고,and
			System.out.println("정상입니다.");
		}
		else if(23 <= bmi && bmi < 25 ) {
			System.out.println("과체중입니다.");
		}
		else if(25 <= bmi) {
			System.out.println("비만입니다.");
		}

	}

}
