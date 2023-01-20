package ch04.jhc;

import java.util.Scanner;

public class BackjoonEx1 {

	public static void main(String[] args) {
//		구구단
		
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			System.out.print("구구단 : 숫자를 입력하세요=> ");
			int a = scanner.nextInt();
		for(int i = 1; i<=9; i++) {
			int b = a*i;
			System.out.println(a + " * " + i + " = " + b);
		}
		break;
		}

	}

}
