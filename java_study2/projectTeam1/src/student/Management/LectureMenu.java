package student.Management;

import java.util.Scanner;

public class LectureMenu {

	public static void main(String[] args) {
		LectureManagement cont = new LectureManagement();
		boolean flage = true;
		Scanner sc = new Scanner(System.in);

		while (flage) {
			System.out.println(" ");
			System.out.println("-----------------------------------------------------------");
			System.out.println("1.���� �˻� | 2.��ü ���� ��� | 3.������ �˻� | 4. ����ȭ������");
			System.out.println("-----------------------------------------------------------");
			System.out.print("1�� ~ 4���� ���ϴ� ��ȣ�� �Է��ϼ��� -> ");
			String menu = sc.nextLine();
			System.out.println(" ");

			switch (menu) {

			case "1":
				cont.serch(); // ���� �˻�����
				break;
			case "2":
				cont.serchAll(); // ��ü ���� �������
				break;
			case "3":
				cont.thserch(); // ������ �˻�����
				break;
			case "4":
				System.out.println("����ȭ������");
				flage = false;
				break;
			default:
				System.out.println("�߸��Է��ϼ̽��ϴ�. 1�� ~ 4���� ���ϴ� ��ȣ�� �Է��ϼ���. ");
			}
		}

	}

}