package javaMid3.ex13;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
//		Scanner�� �Է¹ޱ�, input Ŭ������ setter.
		Scanner sc = new Scanner(System.in);
		SaleManager sm = new SaleManager();
		System.out.println("-----------------");
		System.out.println("�Ǹŷ����� ������Ʈ");
		System.out.println("-----------------");
		boolean run = true;
		while (run) {
			System.out.println("1. �Է�  2. ��� 3. ����");
			String choice = sc.nextLine();
			switch (choice) {
			case "1":
				sm.input();
				break;
			case "2":
				sm.output();
				break;
			case "3":
				run = false;
				break;
			default:
				continue;
			}
			if (run) {
				continue;
			} else
				break;
		}
	}

}
