package ch05.sec05;

import java.util.Scanner;

public class CharAtExample {

	public static void main(String[] args) {
//		�������� = .charAt() method
//		
//		String strA = "�ڹ� ���α׷���";	// [0][1][2][3][4][5][6][7]�� �迭�� ���� char�� ����
//										// [��][��][ ][��][��][��][��][��]
//		System.out.println(strA.charAt(2));	//()��° char ����
		
//		�ֹε�Ϲ�ȣ = 123456-1234567 -> ������ �ľ� -> 7��° ���ڰ� 1 or 2 �̸� ����, ����
		
		Scanner sc = new Scanner(System.in);
		System.out.println("�ֹε�Ϲ�ȣ�� �Է��ϼ���(\"-\"����)>");
		
		String number = sc.nextLine();
		
		char sex = number.charAt(7);
		
		if(sex == '1') {
			System.out.println("�����Դϴ�");
		}else {
			System.out.println("�����Դϴ�");
		}
		
	}

}
