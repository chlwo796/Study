package student.Management;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ScoreManager extends Data {
	// ���� �˻�, ��ü ����, �ݺ� ����
	// �˻� -> �̸�
	// �̸� -> ���� > ����
	// Map -> <Student,value = ����
	Scanner sc = new Scanner(System.in);
	String choice;
	boolean run = true;
	List<Score> scoreList;
	Map<Student, Score> map;
	StudentManager studentManager = new StudentManager();
	public ScoreManager() {
		input();
		while (run) {
			System.out.println("---------------------------------------");
			System.out.printf("%-8s%-8s%-8s%-8s\n", "1. �����˻�", "2. ��ü����", "3. �ݺ� ����", "4. ����ȭ��");
			System.out.println("---------------------------------------");
			System.out.println("�޴�����>");
			String choice = sc.nextLine();
			switch (choice) {
			case "1": {
				search();
				break;
			}
			case "2": {
				printAll();
				break;
			}
			case "3": {
				print();
				break;
			}
			case "4": {
				System.out.println("���� ȭ������ ���ư��ϴ�.");
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

	private void input() {
		scoreList = new ArrayList<Score>();
		scoreList.add(new Score(30, 60));
		scoreList.add(new Score(40, 80));
		scoreList.add(new Score(70, 90));
		scoreList.add(new Score(30, 40));
		scoreList.add(new Score(40, 50));
		map = new TreeMap<Student, Score>();
		for (int i = 0; i < studentManager.studentArray.size(); i++) {
			map.put(StudentManager.studentArray.get(i), scoreList.get(i));
			System.out.println(StudentManager.studentArray.get(i) + " " + StudentManager.studentArray.get(i).getStudentName());
		}
	}

	private void printAll() {
		System.out.println("��ü���");

	}

	private void search() {
		System.out.println("��� �˻��Ͻðڽ��ϱ�?(y/n)");

	}

	private void print() {
		System.out.println("�ݺ�����");

	}
}