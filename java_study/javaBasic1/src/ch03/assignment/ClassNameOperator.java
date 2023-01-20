package ch03.assignment;

import java.util.Scanner;

public class ClassNameOperator {

	public static void main(String[] args) {
		//문제 문자형 변수에 "자바"라고 입력하고 자바가 아니면 "B교실,C교실입니다." 자바면 "A교실입니다."라고 출력하기
		
		Scanner sc = new Scanner(System.in);
		System.out.print("어떤 수업입니까?");
		String className = sc.nextLine();
		String result2;
		result2 = (className.equals("자바")) ? "A교실입니다" : "B교실, C교실입니다";
		System.out.println(result2);
		
//		if(className.equals("자바")) {
//			System.out.println("A교실입니다");
//		}else
//			System.out.println("B, C교실입니다");

		
	}

}
