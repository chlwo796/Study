package ch03.assignment;

import java.util.Scanner;

public class PointOperator {

	public static void main(String[] args) {
		// 문제 숫자 변수에 50을 입력하고 25이상이면 "포인트 대상" 아니면 "포인트 대상이 아닙니다"
		Scanner sc = new Scanner(System.in);

		System.out.print("숫자를 입력하세요==>");
		int number = sc.nextInt();
		String result1;
		result1 = (25 <= number) ? "포인트 대상" : "포인트 대상이 아닙니다";
		System.out.println(result1);
	}

}
