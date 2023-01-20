package ch03.sec01;

import java.util.Scanner;

public class OperandEx01 {

	public static void main(String[] args) {
		// ������ ++a ���� ���� ������, a-- ���� ���� ������
		// ������2 (a=a+1 a+=1) (a=a+2 a+=2) (a=a+b a+=b) (a=a-10 a-=10) (a=a*b a*=b)
		int a = 10;
		System.out.println(a + 1); // 11�� ���

		// a = a+1;
		// a++;
		// ++a;
		System.out.println(a);

		// a = a-1;
		// a--;
		// --a;
		// a--;
		System.out.println(a); // 9����ϱ�

		int b;
		// b������ 11�� �־ ���
		// b= a++ �ϸ� 10�� ��µ�
		// b = ++a;
		// b = ++a�� a = a+1, b = a, 11 10
		// b = a++;
		// b = a++�� b = a, a = a+1, 10 11
		b = a++;
		System.out.println(a);
		System.out.println(b);

		int d = 20;
		System.out.println(++d); // d=d+1 ��� 21
		System.out.println(d++); // ����ϰ� d=d+1
		System.out.println(d);

		// ������2
		int e = 10;
		// e = e-8;
		e -= 8;
		System.out.println(e);

		// ������3
		// ������ 25/5=5 25/4 = 6.25
		int v1 = 25;
		int v2 = 4;

		System.out.println((double) v1 / v2); // 1. �ڷ����� �Ǽ��� �����

		v1 *= 100; // v1 = v1*100;
		v2 *= 100; // v2 = v2*100;

		System.out.println((v1 / v2) / 100);
		// 2. �ڷ����� ������ �״�� �ϰ� 2500/500 = 625�� ���ϰ� 625/100 ���.

		// >>���� ����Ʈ������, <<���� ����Ʈ ������ 2�� ����� ���ϰų� ���Ҷ�
		int v3 = 0b1011; // 10���� 11
		// v3 = v3 << 2; //2�������� 2bit �о��ش�. 2�� ����� ���ϰų� ������
		v3 = v3 >> 2; // �������� /2^2 11/4
		System.out.println(v3); // 1011

		// ���迬���� > �ʰ�, >= �̻�, < �̸�, <= ����, ==����, != ���� �ʴ�
		int v4 = 100;
		System.out.println(v4 != 200); // true or false

		// ��Ʈ������ - ���ко�, ���ںо� �ַ� ���
		int v5 = 0b01011; // 1 true, 0 false
		int v6 = 0b10111;
		System.out.println(Integer.toBinaryString(v5 & v6)); // 00011, ������ and
		System.out.println(Integer.toBinaryString(v5 | v6)); // | or
		System.out.println(Integer.toBinaryString(v5 ^ v6)); // ^ xor, �ٸ��� 1 ������ 0

		// ���Կ����� '=' �캯�� �ִ� ���� �º�(������ ���;� ��)�� ��������.
		int v7 = 100;
		// int 200 = v7; //����Ұ�
		int v8 = v2 + 200;
		// int v2 + 200 = v8; //����Ұ�

		// ���׿����� (����)? ��:����
		int v9 = 10;
		System.out.println((v9==10) ? "�հ�" : "���հ�");
		
		String type = "A";
		String result;
		result = (type.equals("B")) ? "VIP���Դϴ�" : "�Ϲݰ��Դϴ�";
		System.out.println(result);
		
		//���� ���� ������ 50�� �Է��ϰ� 25�̻��̸� "����Ʈ ���" �ƴϸ� "����Ʈ ����� �ƴմϴ�"
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���ڸ� �Է��ϼ���==>");
		int number = sc.nextInt();
		String result1;
		result1 = (25<=number) ? "����Ʈ ���" : "����Ʈ ����� �ƴմϴ�";
		System.out.println(result1);
		
		//���� ������ ������ "�ڹ�"��� �Է��ϰ� �ڹٰ� �ƴϸ� "B����,C�����Դϴ�." �ڹٸ� "A�����Դϴ�."��� ����ϱ�
		
		System.out.print("� �����Դϱ�?");
		String className = sc.nextLine();
		String result2;
		result2 = (className.equals("�ڹ�")) ? "B����, C�����Դϴ�" : "A�����Դϴ�";
		
		
	}

}
