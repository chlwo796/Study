package student.Management;

import java.util.Scanner;

public class Login {
	// �α��� ���� �ʵ�

	private static final String ID = "�����";
	private static final String PASSWORD = "123456";

	public static String getId() {
		return ID;
	}

	public static String getPassword() {
		return PASSWORD;
	}

	void login() {
		Scanner sc = new Scanner(System.in);
		boolean run = true; // �α��� ������ boolean ���������� ����ȭ�餡��
		int count = 0; // 3��Ʋ���� ����
		while (run) {
			System.out.println("-----------------------------");
			System.out.println("������ ���̵�� ��й�ȣ�� �Է����ּ���.");
			System.out.println("-----------------------------");
			System.out.print("���̵� > ");
			String inputId = sc.nextLine();
			System.out.print("��й�ȣ > ");
			String inputPassword = sc.nextLine();
			StudentManager sm = new StudentManager();

			if (inputId.equals(Login.getId()) && inputPassword.equals(Login.getPassword())) {
				count = 0; // Ȥ�ø��� �ʱ�ȭ��
				System.out.println("�α��� ����!");
				sm.studentRun(); // StudentManager Ŭ������ �޴� ���� �޼ҵ� ����!
				break; // ������ run�� �������� while�� ����
			} else {
				if (count == 2) {
					run = false;// 3��Ʋ���� �̼����� �ٷ� ����
					System.out.println("�α��� ����\n���α׷��� ����˴ϴ�.");
					break;
				}
				System.out.println("��ϵ��� ���� �����Դϴ�.\n�ٽ� �Է��ϼ���.");
				count++;
				continue; // continue�� Ʋ���� count++ ��� �ݺ�
			}
		}
	}
}