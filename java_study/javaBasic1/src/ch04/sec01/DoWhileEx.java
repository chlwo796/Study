package ch04.sec01;

import java.util.Scanner;

public class DoWhileEx {

	public static void main(String[] args) {
		// Do-While

//		do {
//			// 반복할 내용쓰기
//		}while(조건문);

		// 문제 1, 2, 3, 4...10

		int a = 1;
		do {
			System.out.print(a + " ");
			a++;
		} while (a <= 10);

		System.out.println();

		// 문제2 100 95 90 ...0

		int b = 100;
		do {
			System.out.print(b + " ");
			b = b - 5;
		} while (b >= 0); // b가 0보다 크거나 같을동안만 do 실행

		System.out.println();

		// 문제3 1~100까지의 합 5050 출력하기

		int c = 0;
		int sum = 0;
		do {
			c++;
			sum = sum + c;
		} while (c < 100);
		System.out.println(sum);

		// 문제4 짝수의 합을 구하기

		int d = 0;
		int sum1 = 0;
		do {
			d = d + 2;
			sum1 = sum1 + (d);
		} while (d < 100);
		System.out.println(sum1);

		// 문제5 1 1 2 3 5 피보나치

		int e = 1;
		int f = 1;
		int sum2 = e + f;
		System.out.print(e + " " + f + " " + sum2 + " ");
		do {
			e = f;
			f = sum2;
			sum2 = e + f;
			System.out.print(sum2 + " ");

		} while (sum2 < 34);

		// 문제6 이름을 계속 받아서 출력하는데 이름이 y면 종료

		Scanner sc = new Scanner(System.in);
		String name = null;

		do {
			System.out.print("이름을 입력하세요 ==>");
			name = sc.next();
			System.out.print(name);
		} while (!name.equals("y"));		// 입력값이 y가 아닐동안 do 실행
		
	}

}
