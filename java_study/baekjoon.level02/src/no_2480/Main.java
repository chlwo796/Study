package no_2480;

//1에서부터 6까지의 눈을 가진 3개의 주사위를 던져서 다음과 같은 규칙에 따라 상금을 받는 게임이 있다. 
//같은 눈이 3개가 나오면 10,000원+(같은 눈)×1,000원의 상금을 받게 된다. 
//같은 눈이 2개만 나오는 경우에는 1,000원+(같은 눈)×100원의 상금을 받게 된다. 
//모두 다른 눈이 나오는 경우에는 (그 중 가장 큰 눈)×100원의 상금을 받게 된다.  
//예를 들어, 3개의 눈 3, 3, 6이 주어지면 상금은 1,000+3×100으로 계산되어 1,300원을 받게 된다. 
//또 3개의 눈이 2, 2, 2로 주어지면 10,000+2×1,000 으로 계산되어 12,000원을 받게 된다. 
//3개의 눈이 6, 2, 5로 주어지면 그중 가장 큰 값이 6이므로 6×100으로 계산되어 600원을 상금으로 받게 된다.
//3개 주사위의 나온 눈이 주어질 때, 상금을 계산하는 프로그램을 작성 하시오.

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int a, b, c;
		int getMoney = 0;
		Scanner sc = new Scanner(System.in);
		a = sc.nextInt();
		b = sc.nextInt();
		c = sc.nextInt();

		if (a == b && b == c) {
			getMoney = 10000 + (a * 1000);
		} else if (a == b) {
			getMoney = 1000 + (a * 100);
		} else if (b == c) {
			getMoney = 1000 + (b * 100);
		} else if (a == c) {
			getMoney = 1000 + (c * 100);
		} else if (a != b && b != c && c != a) {
			if (a > b && a > c) {
				getMoney = a * 100;
			} else if (b > c && b > a) {
				getMoney = b * 100;
			} else {
				getMoney = c * 100;
			}
		}
		System.out.println(getMoney);
	}
}
