package tempMemo;

import java.util.Scanner;

public class TestMain02 {
	public static void main(String[] args) {
		String name;
		int[] scoreArray = new int[4];
		int sum = 0;
		double ave = 0;
		Scanner sc = new Scanner(System.in);
		System.out.print("�̸�>");
		name = sc.nextLine();
		System.out.print("����>");
		scoreArray[0] = sc.nextInt();
		System.out.print("����>");
		scoreArray[1] = sc.nextInt();
		System.out.print("����>");
		scoreArray[2] = sc.nextInt();
		System.out.print("����>");
		scoreArray[3] = sc.nextInt();
		System.out.println("�̸� : " + name);
		System.out.println("���� : " + scoreArray[0]);
		System.out.println("���� : " + scoreArray[1]);
		System.out.println("���� : " + scoreArray[2]);
		System.out.println("���� : " + scoreArray[3]);

		for (int i = 0; i < scoreArray.length; i++) {
			sum += scoreArray[i];
		}
		ave = (double) sum / (double) scoreArray.length;
		double resultAve = Math.round(ave*100)/100.00;
		System.out.println("���� : " + sum);
		System.out.println("��� : " + resultAve);
	}
}
