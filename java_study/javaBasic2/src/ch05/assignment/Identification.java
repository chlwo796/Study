package ch05.assignment;

import java.util.Scanner;

public class Identification {

	public static void main(String[] args) {
//		�ֹε�Ϲ�ȣ���� 7��° �ڸ� (1,3 -> ����), (2, 4 -> ����)
//		��������� �߶� �⵵ ���ϱ�, �� ���ϱ�, �ϱ��ϱ�

		Scanner sc = new Scanner(System.in);
		System.out.println("�ֹε�Ϲ�ȣ�� �Է��ϼ���.(\'-\'����)");

		while (true) {

			String number = sc.nextLine();
			char gender = number.charAt(7);
			String year = number.substring(0, 2);
//			System.out.println(year);
			String month = number.substring(2, 4);
//			System.out.println(month);
			String day = number.substring(4, 6);
			if (number.length() != 14) {
				System.out.println("�ٽ� �Է��ϼ���.>");
				continue;
			} else {
//			System.out.println(day);
				switch (gender) {
				case '1':
				case '3':
					System.out.println(year + "�� " + month + "�� " + day + "�ϻ� �����Դϴ�.");
					break;
				case '2':
				case '4':
					System.out.println(year + "�� " + month + "�� " + day + "�ϻ� �����Դϴ�.");
				default:
					System.out.print("�߸��Է��ϼ̽��ϴ�. �ٽ� �Է��Ͻðڽ��ϱ�?(y/n)");
					String yn = sc.nextLine();
					if (yn.equals("y")) {
						continue;
					} else
						break;
				}
				System.out.println("�����մϴ�.");
				break;

			}
		}
		
//		�����ð��� �� ��
		
//		String ssn = "880815-1234567";
//		String year = ssn.substring(0, 2);
//		String month = ssn.substring(2, 4);
//		String day = ssn.substring(4, 6);
//		System.out.println(year + "�� " + month + "�� " + day + "��");
//
//		String gender = ssn.substring(7);
//
//		int gValue = Integer.parseInt(gender);
//		if (gValue == 1 || gValue == 3) {
//			System.out.println("����");
//		}
//		if (gValue == 2 || gValue == 4) {
//			System.out.println("����");
//		}
//		if (gender.equals("1") || gender.equals("3")) {
//			System.out.println("����");
//		}
//		if (gender.equals("2") || gender.equals("4")) {
//			System.out.println("����");
//		}
	}
}