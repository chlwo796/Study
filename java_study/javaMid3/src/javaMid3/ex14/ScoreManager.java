package javaMid3.ex14;

import java.util.Scanner;

public class ScoreManager {
	// ������ �Է¹޾Ƽ� ������ �ڽ��ּҸ� ������ �θ�Ŭ������ ��üȭ�Ѵ�.
	School school; // ���� �θ� Ÿ�������ϴ� ������ ����
	Scanner sc = new Scanner(System.in);
	School[] scoreArray = new School[100]; // �迭�� ����ٴ°��� ������ �Է¹޾Ƽ� �迭�� ������ �����͸� �����ϰڴٴ� ����.
	String choice;
	boolean run;
	int i = 0;

	void input() {
//		�������� ���� �ʵ�,�ߵ�,��� ����,����,������ �迭 ���� -> �����ʹ� ��� calculator���� �����ǰ� �迭�� manager���� �����ȴ�.
//		1. �ʵ� -> new Elemantary(); 2. �ߵ� -> new Middle();
		run = true;
		while (run) {
			System.out.println("1. �ʵ��б� | 2. ���б� | 3. ����б� | 4. �����ܰ�");
			System.out.print("����>");
			choice = sc.nextLine();
			switch (choice) {
			case "1":
				school = new Elementary();
				System.out.print("����� : ");
				school.subject = sc.nextLine();
				System.out.print("�߰��������: ");
				school.midExam = sc.nextInt();
				System.out.print("�⸻�������: ");
				school.finalExam = sc.nextInt();
				System.out.print("����������: ");
				school.performTest = sc.nextInt();
				sc.nextLine();
				school.cal();
				System.out.println("���� : " + school.totalScore);
				scoreArray[i++] = school;

				break;
			case "2":
				school = new Middle();
				System.out.print("����� : ");
				school.subject = sc.nextLine();
				System.out.print("��米�� : ");
				school.teacher = sc.nextLine();
				System.out.print("�߰�������� : ");
				school.midExam = sc.nextInt();
				System.out.print("�⸻������� : ");
				school.finalExam = sc.nextInt();
				System.out.print("���������� : ");
				school.performTest = sc.nextInt();
				System.out.print("�⼮���� : ");
				school.attendance = sc.nextInt();
				System.out.print("�������� : ");
				school.volunteer = sc.nextInt();
				sc.nextLine();
				school.cal();
				System.out.println("�� ���� :" + school.totalScore);
				scoreArray[i++] = school;
				break;
			case "3":
				school = new High();
				System.out.println("����� : ");
				school.subject = sc.nextLine();
				System.out.println("��米�� : ");
				school.teacher = sc.nextLine();
				System.out.print("�߰�������� : ");
				school.midExam = sc.nextInt();
				System.out.print("�⸻������� : ");
				school.finalExam = sc.nextInt();
				System.out.print("���������� : ");
				school.performTest = sc.nextInt();
				System.out.print("�⼮���� : ");
				school.attendance = sc.nextInt();
				System.out.print("�������� : ");
				school.volunteer = sc.nextInt();
				sc.nextLine();
				school.cal();
				System.out.println("�� ���� :" + school.totalScore);
				scoreArray[i++] = school;
				break;
			case "4":
				run = false;
				System.out.println("�����ܰ�");
				break;
			default:
				System.out.println("�߸��Է��ϼ̽��ϴ�.");
			}
		}
	}

	void output() {
//		�������� ���� ���. 1. �ʵ� 2. �ߵ� 3. ��� 4. �����ܰ�
		run = true;
		while (run) {
//			���⼭ �ʱ�ȭ ������ҰŰ���..�������..�������ʱ�ȭ��?
			// �̰� �Ǵ°ǰ�
			System.out.println("1. �ʵ��б� | 2. ���б� | 3. ����б� | 4. ��ü | 5. �����ܰ�");
			System.out.println("����>");
			choice = sc.nextLine();
			switch (choice) {
			case "1": {
				school = new Elementary(); // ���⼭ �迭���� �������ִ�. �޼ҵ忡�� �迭���� ���� ������ ��� �ұ�..
				school.print(scoreArray); // ���⼭ scoreArray[0]�� �־���Ѵ�. - �ʵ��б��迭, �� ���������� ������..
				break;
			}
			case "2": {
				school = new Middle();
				school.print(scoreArray);
				break;
			}
			case "3": {
				school = new High();
				school.print(scoreArray);
				break;
			}
			case "4": {
				school = new School();
				school.print(scoreArray);
				break;
			}
			case "5": {
				run = false;
				break;
			}
			default: {
				System.out.println("�߸��Է��ϼ̽��ϴ�.");
			}
			}
		}
	}
}
