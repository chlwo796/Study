package no_9498;

// ���� ������ �Է¹޾� 90 ~ 100���� A, 80 ~ 89���� B, 70 ~ 79���� C, 60 ~ 69���� D, ������ ������ F�� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a;
		a = sc.nextInt();

		if (90 <= a && a <= 100) {
			System.out.println("A");
		} else if (80 <= a && a <= 89) {
			System.out.println("B");
		} else if (70 <= a && a <= 79) {
			System.out.println("C");
		} else if (60 <= a && a <= 69) {
			System.out.println("D");
		} else {
			System.out.println("F");
		}

	}
}
