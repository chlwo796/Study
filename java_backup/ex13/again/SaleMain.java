package javaMid3.ex13.again;

import java.util.Scanner;

public class SaleMain {

	public static void main(String[] args) {
//		ex13.���� �� Ǯ���
		Scanner sc = new Scanner(System.in);
		int menuSelect = 0;
		SaleBusiness sa = new SaleBusiness();
		while (menuSelect != 3) { // �Է¹޴� ������ 3�϶��� while �����ϰڴ�.
			System.out.println("-------------------------");
			System.out.println("1. �Է� | 2. ��� | 3. ����");
			System.out.println("-------------------------");
			System.out.println("����>");
			menuSelect = sc.nextInt();

			switch (menuSelect) {
			case 1:
				sa.input(); // �̸� �̸��� �ۼ� �� ���콺 �÷��� �ڵ����� ����� �����ϴ�.
				break;
			case 2:
				sa.output();
				break;
			case 3:
				break;
			}
		}
	}
}
