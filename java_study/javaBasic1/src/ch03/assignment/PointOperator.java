package ch03.assignment;

import java.util.Scanner;

public class PointOperator {

	public static void main(String[] args) {
		// ���� ���� ������ 50�� �Է��ϰ� 25�̻��̸� "����Ʈ ���" �ƴϸ� "����Ʈ ����� �ƴմϴ�"
		Scanner sc = new Scanner(System.in);

		System.out.print("���ڸ� �Է��ϼ���==>");
		int number = sc.nextInt();
		String result1;
		result1 = (25 <= number) ? "����Ʈ ���" : "����Ʈ ����� �ƴմϴ�";
		System.out.println(result1);
	}

}
