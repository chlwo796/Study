package ch02.sec03;

import java.util.Scanner;

public class Example2 {

	public static void main(String[] args) {

		// �̸� �⵵ �Է� -> ���̸� ����ϴ� ���α׷�

		Scanner sc = new Scanner(System.in);
		System.out.println("----------------");
		System.out.println("���� ��� ���α׷�");
		System.out.println("----------------");
		System.out.print("�̸���==>");
		String naming = sc.next();
		System.out.print("�¾ �⵵��?==>");
		int birthDay = sc.nextInt();
		int age = 2023 - birthDay;

		System.out.println("���� " + naming + "�� ���̴� " + age + "�� �̽ʴϴ�.");

		/*
		 * if(age <= 7) {//{}��� ó���� ���� �� true��� ���ٸ� �ڵ� ���� System.out.print("�����Դϴ�.");
		 * System.out.println(" ������ 100������ ��������."); } else if(8 <= age && age < 14) {
		 * System.out.print("����Դϴ�."); System.out.println(" ������ 30������ ��������."); } else
		 * if(14 <= age && age < 20) { System.out.print("û�ҳ��Դϴ�.");
		 * System.out.println(" ������ 20������ ��������."); } else if(20 <= age && age <61) {
		 * System.out.print("��Դϴ�."); System.out.println(" ������ 20������ ������."); } else {
		 * //������ ������ if�� �����ص��ȴ�. System.out.print("�����Դϴ�.");
		 * System.out.println(" ������ 30������ ��������."); }
		 */

		// ageType = ���̺� Ÿ��(����, ���, ..) subsidy = 100, -20, ������ �޴°� +, ���°� -

		String ageType; // ���̺� Ÿ�� ����
		int subsidy; // ������ ����
		// String ageType = null; ��ü �ȿ� ���� ���� ���� �ʾҴ�. ���߿� ���� �ž�.
		// int subsidy = 0;

		/*
		 * if (age <= 7) { ageType = "����"; subsidy = 100; } else if (8 <= age && age <
		 * 14) { ageType = "���"; subsidy = 30; } else if (14 <= age && age < 20) {
		 * ageType = "û�ҳ�"; subsidy = 20; } else if (20 <= age && age < 61) { ageType =
		 * "�"; subsidy = -20;
		 * 
		 * } else { ageType = "����"; subsidy = 30; }
		 */

		/*
		 * // int absSubsidy = Math.abs(subsidy);
		 * 
		 * // System.out.println("����� " + ageType + "�Դϴ�.");
		 * 
		 * // if (0<=subsidy) { // System.out.println("���� ������ " + absSubsidy +
		 * "������ ��������."); // } // else { // System.out.println("���� ������ " + absSubsidy +
		 * "������ ������."); // }
		 */

		if (age <= 7) {
			ageType = "����";
			subsidy = 100;
		} else if (8 <= age && age < 14) {
			ageType = "���";
			subsidy = 30;
		} else if (14 <= age && age < 20) {
			ageType = "û�ҳ�";
			subsidy = 20;
		} else if (20 <= age && age < 61) {
			ageType = "�";
			subsidy = -20;

		} else {
			ageType = "����";
			subsidy = 30;
		}

		int absSubsidy = Math.abs(subsidy); // ���밪 Math Class
		
		System.out.println("����� " + ageType + "�Դϴ�.");

		/*
		 * ���ǹ��� ������ ���ڿ��� ����ϰ� ���� ��� if (ageType.equals("�")) {
		 * System.out.println("���� ������ " + absSubsidy + "������ ������."); } else {
		 * System.out.println("���� ������ " + absSubsidy + "������ ��������."); }
		 */
		if (0 <= subsidy) {
			System.out.println("���� ������ " + absSubsidy + "������ ��������.");
		} else {
			System.out.println("���� ������ " + absSubsidy + "������ ������.");
		}

		// ��� ���θ� ������� ���� �ֽ��ϱ�?
		// ���� ������ true, ������ false,
		// ��� ���� �ִ� ����� 10% �� ����. ���� ���� ������ 10% �� �ޱ�
		// �Ǵ� = || 
		boolean house = true; //�� ���� ����

		if (ageType.equals("�") || ageType.equals("����")) {
			System.out.println("���� �ֽ��ϱ�?");
			house = sc.nextBoolean();
		}
		if(ageType.equals("�") && house) {
			//��̸鼭 ���� ������
			absSubsidy = (int)(absSubsidy*1.1);
			
			System.out.println("���� ������ " + absSubsidy + "������ ������.");
		}
		else if(ageType.equals("����") && house) {
			absSubsidy = (int) (absSubsidy*0.9);
			System.out.println("���� ������ " + absSubsidy + "������ ��������.");
		}
	}
}
