package ch04.sec01;

import java.util.Scanner;

public class ContinueEx2 {

	public static void main(String[] args) {
//		1~100���� for������ ����غ���

//		 for (int i = 1; i <= 100; i++) { System.out.print(i + " "); }
//		 
//		 1~100�� ���� ����ϱ�
//		 
//		 for (int i = 1; i <= 10; i++) { System.out.println(); for (int j = 1; j <=
//		 100; j++) System.out.print(j + " "); }
//		 
//		 System.out.println();
//		 
//		 ȫ�浿 20��
//		 
//		 for (int i = 1; i <= 20; i++) { System.out.print("ȫ�浿 "); }
//		 
//		 System.out.println();
//		 
//		 ȫ�浿 20�� ����� ���� 5�� �ݺ�
//		 
//		 for (int i = 1; i <= 5; i++) { System.out.println(); for (int j = 1; j <= 20;
//		 j++) { System.out.print("ȫ�浿 "); } }

//		1~50 ��

//		System.out.println();
//		
//		int sum = 0;
//		for(int i = 1; i<=50; i++) {
//			sum = sum + i;
//		}
//		System.out.println(sum);

//		1~50������ ���� ���ϴٰ� 500 �̻��� �Ǵ� ���� i���� ���ΰ���?

		int i = 1;
		int sum = 0;
		for (; i <= 50; i++) {
			sum = sum + i;
			if (sum >= 500)
				break; // 500 �̻��� �Ǵ� ���� {}���� Ż��
		}
		System.out.println("\nsum = " + sum + ", i = " + i); // for �ۿ��� i�� ȣ���ϰ� ������ main method���� i�� ���� �����Ѵ�.

//		1~100���� ����ϰ� 55�� �� break �ݺ� Ż���ϱ�

		System.out.println();

		for (int j = 1; j <= 100; j++) {
			System.out.print(j + " ");
			if (j == 55)
				break;
		}

//		10,20,30~1000 20��°�� �� Ż���Ͽ� �ش��׸� ���
		
		System.out.println();
		
		int k = 1;
		int a=0;
		for(; k<=100; k++) {
			a = k*10;
			System.out.print(a + " ");
			if(k == 20) break;
		}
		System.out.println("a = " + a);
		
//		int cnt=0;
//		int k = 10;
//		for(; k<=100; k+=10) {
//			System.out.print(k + " ");
//			cnt++;
//			if(cnt == 20) break;
//		}
//		System.out.println("k = " + k);		// cnt Ƚ���� �����ؼ� �ڵ��� ��.
		
//		������ �Է��� ��� �޴ٰ� 0�� �Ǹ� �ݺ��� ������
		
		System.out.println();
		
		Scanner sc = new Scanner(System.in);
		
//		int number = 0;
//		while(number!=0) {
//			System.out.print("���ڸ� �Է����ּ���.");
//			number = sc.nextInt();
//			System.out.print("/n�Է��Ͻ� ���ڴ� " + number + "�Դϴ�.");
//			if(number == 0) break;
//				}
//		System.out.println("����");		// �����߻�
		
		while(true) {		// while(true), (false) => true�� ��� ����, false�� ����x
			int number = sc.nextInt();
			if(number == 0) break;
		}
		
//		do-while, ���ڷ� �ܾ ��� �Է¹޴ٰ� no�Ǵ� NO�� �ԷµǸ� �ݺ��� ����
//		
		
		System.out.println();
		
		do{
			String str = sc.nextLine();
			if(str.toLowerCase().equals("no")) break;	// no,NO,No,oN �� ��� �����ϰ� �ʹٸ� ��� �ҹ���, �빮�ڷ� �ٲ� �� �� ����
		}while(true);
		
	}

}
