package student.Management;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Score extends StudentManager {
	// ���� �˻�, ��ü ����, �ݺ� ����
	// �˻� -> �̸�
	// �̸� -> ���� > ����
	// Map -> <Student,value = ����
	private Integer scoreA;
	private Integer scoreB;

	int[] scoreArray = { 80, 70, 100 };
	Scanner sc = new Scanner(System.in);
	String choice;
	boolean run = true;
	Map<StudentManager, Integer> scoreMap = new HashMap<StudentManager, Integer>();

	public Score() {

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

	private List<Student> input() {
		return null;
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