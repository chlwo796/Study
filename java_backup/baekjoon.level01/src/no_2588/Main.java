package no_2588;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		�˰���
//		ù��° ���ڸ� �ڿ��� * �ι�° ���ڸ� �ڿ����� 1�� �ڸ� �� ��, 10���ڸ�,100���ڸ�
//		�ڸ����� ���� ���� 1���ڸ� = 10���� ���������� �������� 1���ڸ���.->1���ڸ����� �ڿ������� �� �� 100���� ������. ->100���ڸ���
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
