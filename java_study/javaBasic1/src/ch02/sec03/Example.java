package ch02.sec03;

import java.util.Scanner;

public class Example {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
			System.out.print("이름은-->");
			String name = sc.nextLine();
			System.out.print("국어점수-->");
			int a = sc.nextInt();
			System.out.print("영어점수-->");
			int b = sc.nextInt();
			System.out.print("수학점수-->");
			int c = sc.nextInt();
			
			int total = a + b + c;
			double avg = total/3.00;
			
			System.out.println("----------------------");
			System.out.println("이젠 학교 성적표");
			System.out.println("----------------------");
			System.out.print(name + " ");
			System.out.print(a + " ");
			System.out.print(b + " ");
			System.out.print(c + " ");
			System.out.print(total + " "); //합계 int total = a + b + c;
			System.out.print(avg);//평균 int avg = total /3;
			System.out.println("1등");
			System.out.println("----------------------");
	}

}
/*평균 = 소수점 2째자리까지 표시
total(정수) / 3.00(실수) = 실수형
혹은 System.out.printf("%.2f", avg);*/