package ch02.sec03;

import java.util.Scanner;

public class Example {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
			System.out.print("�̸���-->");
			String name = sc.nextLine();
			System.out.print("��������-->");
			int a = sc.nextInt();
			System.out.print("��������-->");
			int b = sc.nextInt();
			System.out.print("��������-->");
			int c = sc.nextInt();
			
			int total = a + b + c;
			double avg = total/3.00;
			
			System.out.println("----------------------");
			System.out.println("���� �б� ����ǥ");
			System.out.println("----------------------");
			System.out.print(name + " ");
			System.out.print(a + " ");
			System.out.print(b + " ");
			System.out.print(c + " ");
			System.out.print(total + " "); //�հ� int total = a + b + c;
			System.out.print(avg);//��� int avg = total /3;
			System.out.println("1��");
			System.out.println("----------------------");
	}

}
/*��� = �Ҽ��� 2°�ڸ����� ǥ��
total(����) / 3.00(�Ǽ�) = �Ǽ���
Ȥ�� System.out.printf("%.2f", avg);*/