package ch02.sec03;

import java.util.Scanner;

public class example1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("����� �����Դ�?");
		double weight = sc.nextDouble();
		System.out.print("����� Ű��?");
		double heightCm = sc.nextDouble();
		System.out.print("����� ������ (���ڸ� true, ���ڸ� false) �Է��ϼ���.");
		boolean gender = sc.nextBoolean();

		if (true)
			System.out.println("����");
		else 
			System.out.println("����");

		double bmi = weight/(heightCm*heightCm*0.0001);

		System.out.println("-----------------------");
		System.out.println("bmi = "+bmi);

		/*
		 * if(bmi>=25) { //������ = �ѹ��� �ϳ� ���� System.out.println("���Դϴ�."); } else
		 * if(bmi>=23) { System.out.println("��ü���Դϴ�."); } else if(bmi>=18.5) {
		 * System.out.println("�����Դϴ�."); } else { System.out.println("��ü���Դϴ�."); }
		 */

		/*
		 * if(bmi < 18.5) { System.out.println("��ü���Դϴ�."); } if(18.5 <= bmi && bmi < 23)
		 * { //&& = �׸���,and System.out.println("�����Դϴ�."); } if(23 <= bmi && bmi < 25 ) {
		 * System.out.println("��ü���Դϴ�."); } if(25 <= bmi) {
		 * System.out.println("���Դϴ�."); }
		 */ 
		//if���� �����ؼ� ����ϴ� ��� true�� ���� ��� if���� �����Ѵ�. ��ȿ����
		//else if�� ��ø�Ѵ�.
		if(bmi < 18.5) {
			System.out.println("��ü���Դϴ�.");
		}
		else if(18.5 <= bmi && bmi < 23) { //&& = �׸���,and
			System.out.println("�����Դϴ�.");
		}
		else if(23 <= bmi && bmi < 25 ) {
			System.out.println("��ü���Դϴ�.");
		}
		else if(25 <= bmi) {
			System.out.println("���Դϴ�.");
		}

	}

}
