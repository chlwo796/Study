package tempMemo;

import java.util.Scanner;

public class TestMain02 {
	public static void main(String[] args) {
		String name;
		int[] scoreArray = new int[4];
		int sum = 0;
		double ave = 0;
		Scanner sc = new Scanner(System.in);
		System.out.print("이름>");
		name = sc.nextLine();
		System.out.print("국어>");
		scoreArray[0] = sc.nextInt();
		System.out.print("영어>");
		scoreArray[1] = sc.nextInt();
		System.out.print("수학>");
		scoreArray[2] = sc.nextInt();
		System.out.print("과학>");
		scoreArray[3] = sc.nextInt();
		System.out.println("이름 : " + name);
		System.out.println("국어 : " + scoreArray[0]);
		System.out.println("영어 : " + scoreArray[1]);
		System.out.println("수학 : " + scoreArray[2]);
		System.out.println("과학 : " + scoreArray[3]);

		for (int i = 0; i < scoreArray.length; i++) {
			sum += scoreArray[i];
		}
		ave = (double) sum / (double) scoreArray.length;
		double resultAve = Math.round(ave*100)/100.00;
		System.out.println("총점 : " + sum);
		System.out.println("평균 : " + resultAve);
	}
}
