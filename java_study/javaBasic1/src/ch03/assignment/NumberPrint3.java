package ch03.assignment;

import java.util.Scanner;

public class NumberPrint3 {

	public static void main(String[] args) {
		// ���� 3���� �Է¹޾Ƽ� �߰� ���ڸ� ����ϱ�

		Scanner sc = new Scanner(System.in);
		System.out.print("ù��° ���ڸ� �Է��ϼ��� : ");
		int number1 = sc.nextInt();
		System.out.print("�ι�° ���ڸ� �Է��ϼ��� : ");
		int number2 = sc.nextInt();
		System.out.print("����° ���ڸ� �Է��ϼ��� : ");
		int number3 = sc.nextInt();

		int result1 = (number1 <= number2) ? number1 : number2;
		int min = (result1 <= number3) ? result1 : number3;
		
		int result2 = (number1 >= number2) ? number1 : number2;
		int max = (result2 >= number3) ? result2 : number3;
		int mid = (number1 != min && number1 != max) ? number1 : ((number2 != min && number2 != max) ? number2 : number3);
		
		System.out.println(mid);
		
//		if (number1 != min && number1 != max) {
//			System.out.println("�߰� ���ڴ� " + number1 + "�Դϴ�.");
//		} else if (number2 != min && number3 != max) {
//			System.out.println("�߰� ���ڴ� " + number2 + "�Դϴ�.");
//		} else {
//			System.out.println("�߰� ���ڴ� " + number3 + "�Դϴ�.");
//		}
		
//		���׿����� 3��ø () ? () : ()
//		System.out.println("����1 �Է�:");
//        int e6 = sc.nextInt();
//        System.out.println("����2 �Է�:");
//        int e7 = sc.nextInt();
//        System.out.println("����3 �Է�:");
//        int e8 = sc.nextInt();	
//        System.out.println((e6>=e7)?((e6>=e8)?((e7>=e8)?e7:e8):e6):((e6>=e8)?e6:((e7>=e8)?e8:e7))); 

//		������ �ڵ�
//		Scanner Scr = new Scanner(System.in);
//		System.out.print("ù��° ���ڸ� �Է�==>");
//		int number6=Scr.nextInt();//   300
//		System.out.print("�ι�° ���ڸ� �Է�==>");
//		int number7=Scr.nextInt();//	  150
//		System.out.print("����° ���ڸ� �Է�==>");
//		int number8=Scr.nextInt();//	  250
//		
//		int middleNumber = (number6>=number7)? number6:number7;
//		middleNumber = (number8>=middleNumber)? number6:number8;
//		System.out.println(middleNumber);

	}
}
