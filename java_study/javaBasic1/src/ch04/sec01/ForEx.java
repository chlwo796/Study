package ch04.sec01;

import java.util.Scanner;

public class ForEx {

	public static void main(String[] args) {
//		For
//		����
//		for (�����ʱⰪ ; ���ǽ� ; ������) {
//			�ݺ��� ����
//		}
		for (int i = 1; i <= 10; i++) { // i�� 1���� ����, i�� 10���� ���ų� ����������, �ݺ��� i++
			System.out.print(i + " ");
		}

		System.out.println();

		for (int i = 10; i >= 0; i--) { // i��� ������ �� for���� ����Ǿ��⶧���� �ݺ���� ����
			System.out.print(i + " ");
		}

		System.out.println();

//		����1 10, 20 30 40 ..100 ����ϱ�

		for (int i = 1; i <= 10; i++) { // �����ʱⰪ�� ��������, ������ ������ �� ����.
			int i2 = i * 10;
			System.out.print(i2 + " ");
		}

		System.out.println();

//		����2 1~100���� �� ���ϱ�

		int i = 0;
		int sum = 0;

		for (; i <= 100; i++) {
			sum = sum + i;
		}
		System.out.println(sum + " ");

//		����3 0~100���� Ȧ���� ��, Ȧ���� ����

		int i1 = 1;
		int sum1 = 0;
		int sum2 = 0;
		int count1 = 0;
		for (; i1 <= 100; i1++) { // Ȧ���� ���� count = count + 1;�ε� �����ϴ�.
			sum1 = sum1 + i1;
			count1 = (i1 % 2);
			sum2 = sum2 + count1;
			i1 = i1 + 1;

		}
		System.out.println(sum1 + " ");
		System.out.println(sum2 + " ");

//		����4 1~100���� ����ϵ� 1�ٿ� 10����
//		�Ʒ��� ���� �ϴٰ� ����
//		int i2 = 1;
//		int i3 = i2+9;
//		for (; i2<=i3; i2++) {
//			System.out.print(i2 +" ");
//		}
//		System.out.println();
//		
//		i2 = i2 + 10;
//		i3 = i3 + 9;
//		for (i2 = i2 +10; i2<=i3; i2++) {
//			System.out.print(i2 +" ");
//	}

//		���1 ������ 10���� ��� 10�� �ٹٲ��ϱ�

		int cnt = 0;
		for (int i2 = 1; i2 <= 100; i2++) {
			System.out.print(i2 + " ");
			cnt++;
			if (cnt == 10) {
				System.out.println();
				cnt = 0; // �ٽ� �ʱ�ȭ �ϴ°��� point!!
			}
		}

//		���2 10�� ���(������ = 0)�� Ȱ��

		for (int i2 = 1; i2 <= 100; i2++) {
			System.out.print(i2 + " ");

			if (i2 % 10 == 0) {
				System.out.println(); // ���� �Ѱ��ε� �����ϰ� ����!
			}
		}
//		����5 while �Ʒ��� ���� ����غ�����. (12345)�� �Է��� ����.
//		���ȭ��
//		���ڸ� �Է��ϼ���. (��.12345) ==> (12345)
//		sum 5 number = 12345
//		sum 9 number = 1234
//		sum 12 number = 123
//		sum 14 number = 12
//		sum 15 number = 1
//		�� �ڸ����� �� : 15

		Scanner sc = new Scanner(System.in);
		System.out.print("���ڸ� �Է��ϼ���. (��:12345) ==> ");
		int number = sc.nextInt();
		int number1 = 0;	// �ǵ��ڸ��� ���ֱ� ���� ����
		int temp = 0;
		int s = 0;
		while(number > 0) {
			number1 = number / 10;
			temp = number1 * 10;
			s = s + number - temp;
			System.out.println("sum = " + s + " number = " + number);
			number = number1;
		}
//		sum������ 5�� �־��ֱ� 12345 - 12340 = 5, 12340 = 1234 * 10, 1234 = 12345 / 10
//		�˰��� ���ݾ� �����ϱ�. �ݺ������� �����ؼ� ���޽�Ű��.

//		int number1 = number / 10;	// number1 = 1234
//		System.out.println(number1);
//		int temp = number1 * 10;	// temp = 12340
//		System.out.println(temp);
//		int s = number - temp;	// s = 12345 - 12340 = 5
//		System.out.println("sum = " + s + " number = " + number);
//		number = number1; // 1234
//		number1 = number / 10; // 123
//		System.out.println(number1);
//		temp = number1 * 10; // 1230
//		s = s + (number - temp); // 1234 - 1230 = 4
//		System.out.println("sum = " + s + " number = " + number);
		
//		����6 do~while ���ڸ� ��� �Է¹޴´�. 0�� �Է��ϸ� ���ݱ��� �Է��� ���ڸ� ��� ���� ���� ����Ѵ�.
//		�հ踦 ���� ���ڸ� �Է��ϼ���(�������� 0�� �Է�)
//		100 //(�Է¼�)
//		200 //(�Է¼�)
//		300 //(�Է¼�)
//		400 //(�Է¼�)
//		0 //(�Է¼�)
//		�հ� : 100 //(���)
		int n6;
		int sum6 = 0;
		do {
			System.out.println("����6�� ���ڸ� �Է��ϼ���");
			n6 = sc.nextInt();
			sum6 = sum6 + n6;
		}while(n6 !=0);
		System.out.println("�հ�: " + sum6);
}

}
