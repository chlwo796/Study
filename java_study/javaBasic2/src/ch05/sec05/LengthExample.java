package ch05.sec05;

import java.util.Scanner;

public class LengthExample {

	public static void main(String[] args) {
//		문자열의 길이 = .length(); 

//		String strA = "자바 프로그래밍";
//		int length = strA.length();	// 공백 포함, String -> int
//		
//		System.out.println(length);

		Scanner sc = new Scanner(System.in);

		System.out.println("주민등록번호를 입력하세요(\"-\"포함)");
		String number = sc.nextLine();

		int lengthNumber = number.length();
		switch (lengthNumber) {
		case 14: {
			System.out.println("맞게 입력하셨습니다.");
			break;
		}
		default: {
			System.out.println("잘못 입력하셨습니다.");
			break;
		}
		}

	}

}
