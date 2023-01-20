package ch03.assignment;

import java.util.Scanner;

public class NumberPrint2 {

	public static void main(String[] args) {
		// 숫자 3개를 입력받아서 작은 숫자를 출력하기

		Scanner sc = new Scanner(System.in);
		System.out.print("첫번째 숫자를 입력하세요 : ");
		int number1 = sc.nextInt();
		System.out.print("두번째 숫자를 입력하세요 : ");
		int number2 = sc.nextInt();
		System.out.print("세번째 숫자를 입력하세요 : ");
		int number3 = sc.nextInt();

		// 조건이 3개인 경우.

		// 1과 2를 비교한 후 결과값을 3이랑 비교한다. 1이 2보다 작다, 참 : 그럼 1이 3보다 작아? 거짓 : 2 네. 1출력. 아니오
		// 3출력

		int result1 = (number1 < number2) ? number1 : number2; // 1과 2중에 작은숫자를 3과 비교해보기.
		int result2 = (result1 < number3) ? result1 : number3;

//		System.out.println("가장 작은 숫자는 " + result2 + "입니다.");
//
//		if (number1 <= number2 && number2 <= number3) {
//			System.out.println("가장 작은 숫자는 " + number1 + "입니다.");
//		} 
//		else if (number2 <= number3 && number3 <= number1) {
//			System.out.println("가장 작은 숫자는 " + number2 + "입니다.");
//		} 
//		else {
//			System.out.println("가장 작은 숫자는 " + number3 + "입니다.");
//		}
	}
}
