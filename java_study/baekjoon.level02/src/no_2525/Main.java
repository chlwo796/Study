package no_2525;

//KOI ���ڿ����� �ǰ��� ���� ���ִ� ������������ �丮�� �����ϰ� ����� �ΰ����� ������ �����Ϸ��� �Ѵ�. 
//�ΰ����� ������ ����ϴ� ����� ������ ���� ���� ���� ��Ḧ �ΰ����� ���쿡 ������ �ȴ�. 
//�׷��� �ΰ����� ������ ���챸�̰� ������ �ð��� �� ������ �ڵ������� ����Ѵ�. 
//����, KOI ������ �ΰ����� ���� �ո鿡�� ����ڿ��� ������������ �丮�� ������ �ð��� �˷� �ִ� ������ �ð谡 �ִ�. 
//�����������̸� �����ϴ� �ð��� ���챸�̸� �ϴ� �� �ʿ��� �ð��� �д����� �־����� ��, 
//���챸�̰� ������ �ð��� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int A, B, C;

		Scanner sc = new Scanner(System.in);

		A = sc.nextInt();
		B = sc.nextInt();
		C = sc.nextInt();

		int totalMin = (A * 60) + B + C;
		int hour = (totalMin / 60) % 24;
		int minute = totalMin % 60;

		System.out.println(hour);
		System.out.println(minute);

	}
}
