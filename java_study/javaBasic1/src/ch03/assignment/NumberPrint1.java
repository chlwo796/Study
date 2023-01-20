package ch03.assignment;

import java.util.Scanner;

public class NumberPrint1 {

	public static void main(String[] args) {
		// 숫자 2개를 입력 받아서 큰 숫자를 출력하기

		Scanner sc = new Scanner(System.in);
		System.out.print("첫번째 숫자를 입력하세요 : ");
		int number1 = sc.nextInt();
		System.out.print("두번째 숫자를 입력하세요 : ");
		int number2 = sc.nextInt();

		int result = (number1 < number2) ? number2 : number1;
		System.out.println("둘 중 큰 숫자는 " + result + "입니다.");
		
//		if(number1<=number2) {
//			System.out.println("둘 중 큰 숫자는 " + number2 + "입니다.");
//		} else
//			System.out.println("둘 중 큰 숫자는 " + number1 + "입니다.");
		
	}

}
