package no_25304;

//�ؿ��̴� ���� �ֿ� ��鼭 ó������ �ڽ�Ʈ�ڸ� �� �ô�. ���� ������. 
//�׷���, �� �� ������ �ʾҴµ� �����ϰ� ���� �ݾ��� ������ ���̴�! 
//�ؿ��̴� �������� ���鼭 ��Ȯ�ϰ� ���� ���� �´��� Ȯ���غ��� �Ѵ�.
//�������� ����,
//������ �� ������ ���ݰ� ����
//������ ���ǵ��� �� �ݾ��� ����, 
//������ ������ ���ݰ� ������ ����� �� �ݾ��� �������� ���� �� �ݾװ� ��ġ�ϴ��� �˻��غ���.

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int totalPrice = sc.nextInt();
		int number = sc.nextInt();
		int[] priceList = new int[number];
		int[] priceNumberList = new int[number];
		int sum = 0;
		for (int i = 0; i < number; i++) {
			priceList[i] = sc.nextInt();
			priceNumberList[i] = sc.nextInt();
			sum += (priceList[i] * priceNumberList[i]);
		}
		if (totalPrice == sum) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
	}
}
