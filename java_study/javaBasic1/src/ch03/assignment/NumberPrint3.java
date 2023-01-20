package ch03.assignment;

import java.util.Scanner;

public class NumberPrint3 {

	public static void main(String[] args) {
		// 숫자 3개를 입력받아서 중간 숫자를 출력하기

		Scanner sc = new Scanner(System.in);
		System.out.print("첫번째 숫자를 입력하세요 : ");
		int number1 = sc.nextInt();
		System.out.print("두번째 숫자를 입력하세요 : ");
		int number2 = sc.nextInt();
		System.out.print("세번째 숫자를 입력하세요 : ");
		int number3 = sc.nextInt();

		int result1 = (number1 <= number2) ? number1 : number2;
		int min = (result1 <= number3) ? result1 : number3;
		
		int result2 = (number1 >= number2) ? number1 : number2;
		int max = (result2 >= number3) ? result2 : number3;
		int mid = (number1 != min && number1 != max) ? number1 : ((number2 != min && number2 != max) ? number2 : number3);
		
		System.out.println(mid);
		
//		if (number1 != min && number1 != max) {
//			System.out.println("중간 숫자는 " + number1 + "입니다.");
//		} else if (number2 != min && number3 != max) {
//			System.out.println("중간 숫자는 " + number2 + "입니다.");
//		} else {
//			System.out.println("중간 숫자는 " + number3 + "입니다.");
//		}
		
//		삼항연산자 3중첩 () ? () : ()
//		System.out.println("숫자1 입력:");
//        int e6 = sc.nextInt();
//        System.out.println("숫자2 입력:");
//        int e7 = sc.nextInt();
//        System.out.println("숫자3 입력:");
//        int e8 = sc.nextInt();	
//        System.out.println((e6>=e7)?((e6>=e8)?((e7>=e8)?e7:e8):e6):((e6>=e8)?e6:((e7>=e8)?e8:e7))); 

//		간단한 코드
//		Scanner Scr = new Scanner(System.in);
//		System.out.print("첫번째 숫자를 입력==>");
//		int number6=Scr.nextInt();//   300
//		System.out.print("두번째 숫자를 입력==>");
//		int number7=Scr.nextInt();//	  150
//		System.out.print("세번째 숫자를 입력==>");
//		int number8=Scr.nextInt();//	  250
//		
//		int middleNumber = (number6>=number7)? number6:number7;
//		middleNumber = (number8>=middleNumber)? number6:number8;
//		System.out.println(middleNumber);

	}
}
