package no_1330;

//두 정수 A와 B가 주어졌을 때, A와 B를 비교하는 프로그램을 작성하시오.

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int a, b;
		a = sc.nextInt();
		b = sc.nextInt();

		if (a > b) {
			System.out.println(">");
		} else if (a < b) {
			System.out.println("<");
		} else {
			System.out.println("==");
		}
	}
}
