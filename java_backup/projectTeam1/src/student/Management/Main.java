package student.Management;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		boolean run = true;
		Scanner sc = new Scanner(System.in);
		while (run) {
			System.out.println("---------------------------------------");
			System.out.printf("%-8s%-8s%-8s%-8s%-8s\n", "1. �л�����", "2. ���ǰ���", "3. ��������", "4. ������", "5. ����");
			System.out.println("---------------------------------------");
			System.out.println("�޴�����>");
			String choice = sc.nextLine();
			switch (choice) {
			case "1": {
				System.out.println("�л����� �޴��� �����߽��ϴ�.");
				StudentManager.main(args);
				break;
			}
			case "2": {
				System.out.println("���ǰ��� �޴��� �����߽��ϴ�.");
				System.out.println("���ǰ���");
				break;
			}
			case "3": {
				System.out.println("�������� �޴��� �����߽��ϴ�.");
				new Score();
				break;
			}
			case "4": {
				System.out.println("������ �޴��� �����߽��ϴ�.");
				break;
			}
			case "5": {
				System.out.println("���α׷� ����!");
				run = false;
				break;
			}

			default: {
				System.out.println("�߸��Է��ϼ̽��ϴ�.");
				continue;
			}
			}
		}
	}
}
