package ch05.day05;

import java.util.Scanner;

public class Ex09Class {
	static int stNumber; // �ݵ�� �ٽú���!! static ������ static method!!
	static int[] score; // static void method ������ static ������ �����ؾ� ���������� ��밡���ϴ�.
	static Scanner sc = new Scanner(System.in);	// edited point2 = method���� scanner�� ȣ���ϴ� ���� �ƴ� class�Ҽ�field�� �����Ѵ�.

	public static void main(String[] args) {
//		Ȯ�ι��� 9�� �л����� �� ������ �Է�, while, Scanner, nextLine(), �ְ����� �� �������

		boolean flage = true;

		while (flage) {
			System.out.println("-----------------------------------------");
			System.out.println("1.�л���\t2.�����Է�\t3.��������Ʈ\t4.�м�\t5.����");
			System.out.println("-----------------------------------------");
			System.out.print("����>");
			String menu = sc.nextLine();

			switch (menu) {
			
			case "1":
				count();
				break;

			case "2":
				input();
				break;
			case "3":
				list();
				break;
			case "4":
				maxAve();
				break;
			case "5":
				flage = false;
				break;
			default:
				System.out.println("�߸��Է��ϼ̽��ϴ�.(1~5)");
			}
		}

	}

	public static void maxAve() {
		int max = 0;
		int sum = 0;
		double ave = 0.0;
		// TODO Auto-generated method stub
		for (int i = 0; i < score.length; i++) {
			if (max <= score[i]) {
				max = score[i];
			}
			sum = sum + score[i];
		}
		ave = sum / score.length;
		System.out.println("�ְ����� : " + max);
		System.out.println("������� : " + ave);
	}

	public static void list() {

		for (int i = 0; i < score.length; i++) {
			System.out.println("scores[" + i + "]: " + score[i]);
		}

	}

	public static void input() {

//		int[] score = new int[stNumber];	
//		Static ������ ���������� int[] score�� ���� ��� ���������� score�迭�� ���� �ʴ´�...list method����� nullpointerror..
//		�Ƹ� �׸��� �������� score�� ���� ���� �ʰ� �� �޼ҵ常�� ���ο� �迭�� ��������� ���� �ƴұ�..�޼ҵ尡 �������� �ʹ� ��ƴ�..������ score�� ���൵ �ȵǴ���
		score = new int[stNumber]; //
		for (int i = 0; i < stNumber; i++) {
			System.out.print("scores[" + i + "]>");
			score[i] = sc.nextInt();
		}
	}

	public static void count() {

		System.out.print("�л���>");
		stNumber = sc.nextInt();
	}
//	public static int count() {
//
//		System.out.print("�л���>");
//		stNumber = sc.nextInt();
//		return stNumber;
//	}
	

}
