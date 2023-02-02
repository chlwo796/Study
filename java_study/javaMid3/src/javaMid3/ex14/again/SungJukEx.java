package javaMid3.ex14.again;

import java.util.Scanner;

public class SungJukEx {

	static Scanner sc = null;
	static String choice = null;
	static SungjukBusiness sb;

	public static void main(String[] args) {
		boolean run = false;
		sc = new Scanner(System.in);
		SungJuk e1 = new ElemantaryStudent();
		SungJuk m1 = new MiddleSchooler();
		SungJuk h1 = new HighSchoolStudent();
		sb = new SungjukBusiness();
		do {
			System.out.println("----------------------------------------");
			System.out.println("1. �ʵ��б� | 2. ���б� | 3. ����б� | 4. ����");
			System.out.println("----------------------------------------");
			System.out.println("����>");
			choice = sc.nextLine();
			switch (choice) {
			case "1":
				elementaryStudent(e1);
				break;
			case "2":
				middleSchooler(m1);

				break;
			case "3":
				HischoolStudent(h1);
				break;
			case "4":
				run = true;
				break;
			default:
				System.out.println("�߸��Է��ϼ̽��ϴ�.(1~3)");
				break;
			}

		} while (!run);
	}

	private static void HischoolStudent(SungJuk h1) {
		choice = null;
		boolean run = false;
		do {
			System.out.println("-------------------");
			System.out.println("����б� �������� ���α׷�");
			System.out.println("--------------------");
			System.out.println("1. �Է� | 2. ��� | 3. ���ε��ư���");
			choice = sc.nextLine();
			switch (choice) {
			case "1":
				sb.input(h1);
				break;
			case "2":
				sb.output(h1);
				break;
			case "3":
				run = true;
				break;

			default:
				System.out.println("�߸��Է��ϼ̽��ϴ�.(1~2)");
				break;
			}

		} while (!run);
	}

	private static void middleSchooler(SungJuk m1) {
		choice = null;
		boolean run = false;
		do {
			System.out.println("-------------------");
			System.out.println("���б� �������� ���α׷�");
			System.out.println("--------------------");
			System.out.println("1. �Է� | 2. ��� | 3. ���ε��ư���");
			choice = sc.nextLine();
			switch (choice) {
			case "1":
				sb.input(m1);
				break;
			case "2":
				sb.output(m1);
				break;
			case "3":
				run = true;
				break;

			default:
				System.out.println("�߸��Է��ϼ̽��ϴ�.(1~2)");
				break;
			}

		} while (!run);

	}

	private static void elementaryStudent(SungJuk sj) {
		choice = null;
		boolean run = false;
		do {
			System.out.println("-------------------");
			System.out.println("�ʵ��б� �������� ���α׷�");
			System.out.println("--------------------");
			System.out.println("1. �Է� | 2. ��� | 3. ���ε��ư���");
			choice = sc.nextLine();
			switch (choice) {
			case "1":
				sb.input(sj);
				break;
			case "2":
				sb.output(sj);
				break;
			case "3":
				run = true;
				break;

			default:
				System.out.println("�߸��Է��ϼ̽��ϴ�.(1~2)");
				break;
			}

		} while (!run);

	}
}