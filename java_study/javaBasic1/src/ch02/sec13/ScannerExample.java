package ch02.sec13;

import java.util.Scanner;

public class ScannerExample {

	public static void main(String[] args) throws Exception {
		// Ű���� �Է� �����͸� ������ ����

		Scanner scanner = new Scanner(System.in);
		System.out.printf("x �� �Է�: ");
		String strX = scanner.nextLine();
		int x = Integer.parseInt(strX);

		System.out.printf("y �� �Է�: ");
		String strY = scanner.nextLine();
		int y = Integer.parseInt(strY);

		int result = x + y;
		System.out.println("x + y: " + result);
		System.out.println();

		while (true) {
			System.out.printf("�Է� ���ڿ�: ");
			String data = scanner.nextLine();
			if (data.equals("q")) {
				break;
			}
			System.out.println("��� ���ڿ�: " + data);
			System.out.println();
		}
		System.out.println("����");
	}

}
