package javaMid3.ex14;

import java.util.Scanner;

public class ScoreManager {
	// ������ �Է¹޾Ƽ� ������ �ڽ��ּҸ� ������ �θ�Ŭ������ ��üȭ�Ѵ�.
	School school; // ���� �θ� Ÿ�������ϴ� ������ ����
	Scanner sc = new Scanner(System.in);
	School[] scoreArray = new School[100];
	String choice;
	int i = 0;

	void input() {
//		�������� ���� �ʵ�,�ߵ�,��� ����,����,������ �迭 ���� -> �����ʹ� ��� calculator���� �����ǰ� �迭�� manager���� �����ȴ�.
//		1. �ʵ� -> new Elemantary(); 2. �ߵ� -> new Middle();
		System.out.println("1. �ʵ��б� | 2. ���б� | 3. ����б� | 4. �����ܰ�");
		choice = sc.nextLine();
		switch (choice) {
		case "1":
			school = new Elementary(); // �̰� �������̴�.
			System.out.println("�ʵ��л������Դϴ�.");
			System.out.println("�����>");
			school.subject = sc.nextLine();
			System.out.println("�߰��������>");
			school.midExam = sc.nextInt();
			sc.nextLine();
			System.out.println("�⸻�������>");
			school.finalExam = sc.nextInt();
			sc.nextLine();
			System.out.println("����������>");
			school.performTest = sc.nextInt();
			sc.nextLine();
			school.cal();
			System.out.println("�� ���� :" + school.totalScore);
			scoreArray[i++] = school;
			break;
		case "2":
			school = new Middle();
			System.out.println("���л� �����Դϴ�.");
			System.out.println("�����>");
			school.subject = sc.nextLine();
			System.out.println("�߰��������>");
			school.midExam = sc.nextInt();
			sc.nextLine();
			System.out.println("�⸻�������>");
			school.finalExam = sc.nextInt();
			sc.nextLine();
			System.out.println("����������>");
			school.performTest = sc.nextInt();
			sc.nextLine();
			System.out.println("�⼮����>");
			school.attendance = sc.nextInt();
			sc.nextLine();
			System.out.println("��������>");
			school.volunteer = sc.nextInt();
			sc.nextLine();

			school.cal();

			System.out.println("�� ���� :" + school.totalScore);
			scoreArray[i++] = school;
			break;
		case "3":
			school = new High();
			System.out.println("���л� �����Դϴ�.");
			System.out.println("�����>");
			school.subject = sc.nextLine();
			System.out.println("�߰��������>");
			school.midExam = sc.nextInt();
			sc.nextLine();
			System.out.println("�⸻�������>");
			school.finalExam = sc.nextInt();
			sc.nextLine();
			System.out.println("����������>");
			school.performTest = sc.nextInt();
			sc.nextLine();
			System.out.println("�⼮����>");
			school.attendance = sc.nextInt();
			sc.nextLine();
			System.out.println("��������>");
			school.volunteer = sc.nextInt();
			sc.nextLine();

			school.cal();
			System.out.println("�� ���� :" + school.totalScore);
			scoreArray[i++] = school;
			break;
		case "4":
			System.out.println("�����ܰ�");
			break;
		default:
		}

	}

	void output() {
//		�������� ���� ���. 1. �ʵ� 2. �ߵ� 3. ��� 4. �����ܰ�
		school = new Elementary();
		System.out.println("�ʵ��л� �����Դϴ�.");
		System.out.println();
	}

	void calculator() {
//		�� �ּ��� ������ �����ͼ� ��� �ջ�, ǥ������ ���� �� ��� ->Output�޼ҵ�γ�����?
	}
}
