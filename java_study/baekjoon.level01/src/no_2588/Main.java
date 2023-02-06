package no_2588;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		알고리즘
//		첫번째 세자리 자연수 * 두번째 세자리 자연수의 1의 자리 수 곱, 10의자리,100의자리
//		자리수에 대한 로직 1의자리 = 10으로 나누었을때 나머지가 1의자리수.->1의자리수를 자연수에서 뺀 후 100으로 나눈다. ->100의자리수
		int a, b, c, d, e, f;
		a = sc.nextInt();
		b = sc.nextInt();
		c = a * (b % 10);
		d = a * ((b / 10) % 10);
		e = a * ((b / 100) % 10);
		f = c + (d * 10) + (e * 100);
		System.out.println(c);
		System.out.println(d);
		System.out.println(e);
		System.out.println(f);

	}
}
