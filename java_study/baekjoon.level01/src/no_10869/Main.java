package no_10869;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
//		�� �ڿ��� A�� B�� �־�����. �̶�, A+B, A-B, A*B, A/B(��), A%B(������)�� ����ϴ� ���α׷��� �ۼ��Ͻÿ�. 
		Scanner sc = new Scanner(System.in);
		int a, b;
		a = sc.nextInt();
		b = sc.nextInt();
		if (1 <= a && a <= 10000) {
			if (1 <= b && b <= 10000) {
				System.out.println(a + b);
				System.out.println(a - b);
				System.out.println(a * b);
				System.out.println(a / b);
				System.out.println(a % b);
			}
		}

	}

}
