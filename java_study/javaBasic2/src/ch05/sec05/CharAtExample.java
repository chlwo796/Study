package ch05.sec05;

import java.util.Scanner;

public class CharAtExample {

	public static void main(String[] args) {
//		문자추출 = .charAt() method
//		
//		String strA = "자바 프로그래밍";	// [0][1][2][3][4][5][6][7]의 배열로 각각 char이 저장
//										// [자][바][ ][프][로][그][래][밍]
//		System.out.println(strA.charAt(2));	//()번째 char 추출
		
//		주민등록번호 = 123456-1234567 -> 성별을 파악 -> 7번째 숫자가 1 or 2 이면 남자, 여자
		
		Scanner sc = new Scanner(System.in);
		System.out.println("주민등록번호를 입력하세요(\"-\"포함)>");
		
		String number = sc.nextLine();
		
		char sex = number.charAt(7);
		
		if(sex == '1') {
			System.out.println("남자입니다");
		}else {
			System.out.println("여자입니다");
		}
		
	}

}
