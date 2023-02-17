package student.Management;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean run = true;	// �α��� ������ boolean ���������� ����ȭ�餡��
		int count = 0;	// 3��Ʋ���� ����
		System.out.println("-----------------");
		System.out.println("�����п� ���� ���α׷�");
		System.out.println("-----------------");
		while (run) {

			System.out.print("���̵�>");
			String inputId = sc.nextLine();
			System.out.println("��й�ȣ>");
			String inputPassword = sc.nextLine();
			if (inputId.equals(Login.getId()) && inputPassword.equals(Login.getPassword())) {
				count=0;  // Ȥ�ø��� �ʱ�ȭ��
				break;	// ������ run�� �������� while�� ���� 
			} else {
				if(count==2) {	
					run = false;// 3��Ʋ���� �̼����� �ٷ� ����
					break;
				}
				System.out.println("�ٽ� �Է��ϼ���.");
				count++;
				continue;	// continue�� Ʋ���� count++ ��� �ݺ�
			}
		}
		while (run) {
			System.out.println("-----------------------------------------------");
			System.out.printf("%-8s%-8s%-8s%-8s%-8s\n", "1. �л�����", "2. ���ǰ���", "3. ��������", "4. ������", "5. ����");
			System.out.println("-----------------------------------------------");
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
				LectureManagement.main(args);
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
