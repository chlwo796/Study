package ch04.sec06;

import java.util.Scanner;

public class DoWhileExample {

	public static void main(String[] args) {
//		do-while을 이용한 키보드 입출력 프로그램
		
		Scanner sc = new Scanner(System.in);
		System.out.println("메시지를 입력하세요.\n프로그램을 종료하시려면 q를 입력하세요.");
		String inputStr = null;
		
		do {
			System.out.print(">");
			inputStr = sc.nextLine();
			System.out.println(inputStr);
		}while(!inputStr.equals("q"));
		System.out.println("프로그램종료");
		
//		inputStr == "q"라는 조건식은 성립하지 않는다. 문자열의 비교의 경우 .equals()라는 API를 이용한다.
//		while(조건식)에서 조건식이 true일 경우, do{}의 반복식을 다시 실행한다.
		
	}

}
