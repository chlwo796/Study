package student.Management;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class LectureManagement {

	Scanner sc;

	LectureManagement() {
		sc = new Scanner(System.in);
	}

	// ��ü ���� - �߰��� �κ�
		Data data = new Data();
		List<Lecture> lectureList = data.getLectureList();
		List<Student> studentList = data.getStudentList();

		// ���� �˻�
		void serch() {

			String find; // ���� ���� �޴� ��

			System.out.print("�˻��� ���� ������ �Է��ϼ��� : ");
			find = sc.next(); // ���� ���� �Է�
			String num = null;
			int count = 0;
			for (int i = 0; i < lectureList.size(); i++) { // list ũ�⸸ŭ for�� ����

				// ���� �˻�
				if (find.equals(lectureList.get(i).getLecture())) {
					count++;
					System.out.println("=================================");
					System.out.println("���� : " + lectureList.get(i).getLecture());
					System.out.println("������ : " + lectureList.get(i).getTeacherName());
					System.out.println("���Ƿ� : " + lectureList.get(i).getTuition());
					System.out.print("���� �л� ���� ���ϱ� ���ؼ� 1.(����) 2.(����) 3.(����) 1~3 ���ڸ� �Է��ϼ���. : ");
					
					num = sc.nextLine(); // 1~3 ���� �Է�
					studentsEnrolled(); // ���� �л� �� ���ϴ� �޼ҵ� ȣ��
					System.out.println("=================================");
					break;
				}  

			} if(count==0) {
				System.out.println("�˻��� �����߽��ϴ�.");
			}
		}

		// ��ü ���� ���
		void serchAll() {
			System.out.println("===== ��ü ���� ��� =====");
			System.out.printf("%3s\t%3s\t%3s \n", " ������", "��缱����", "������");
			System.out.println("=======================");
			for (int i = 0; i < lectureList.size(); i++) {
				System.out.printf("%3s\t%3s\t%3s \n", lectureList.get(i).getLecture(), lectureList.get(i).getTeacherName(),
						lectureList.get(i).getTuition());
			}
			System.out.println("=======================");
		}

		// ������ �˻�
		void thserch() {

			String find; // ������ �̸� �޴� ��
			String num = null;
			
			boolean flag = true;
			while (flag) {
			System.out.print("�˻��� �������� �Է��ϼ��� : ");
			find = sc.next();
			int count = 0;

			for (int i = 0; i < lectureList.size(); i++) { // ������ �˻�
				if (find.equals(lectureList.get(i).getTeacherName())) {
					count++;
					System.out.println("��� ���� : " + lectureList.get(i).getLecture());
				//	System.out.print("���� �л� ���� ���ϱ� ���ؼ� 1.(����) 2.(����) 3.(����) 1~3 ���ڸ� �Է��ϼ���. : ");
				}  
			} if(count==0) {
				System.out.println("�˻��� �����߽��ϴ�."); break;
			}
			System.out.print("���� �л� ���� ���ϱ� ���ؼ� 1.(����) 2.(����) 3.(����) 1~3 ���ڸ� �Է��ϼ���. : ");
			num = sc.nextLine(); // 1~3 ���� �Է�
			studentsEnrolled(); // ���� �л� �� ���ϴ� �޼ҵ� ȣ��
			System.out.print("��� �л� �̸��� ���ϱ� ���ؼ� 1.(����) 2.(����) 3.(����) 1~3 ���ڸ� �Է��ϼ���. : ");
			studentsEnrolled2(); // ���� �л� �̸� ���ϴ� �޼ҵ� ȣ��
			break;
		}
		}

		void studentsEnrolled() { // ���� �л� �� ���ϴ� �޼ҵ�
			String num = null;
			num = sc.nextLine();
			switch (num) {
			case "1": {

				int cnt1 = 0;
				for (int i = 0; i < studentList.size(); i++) { // �л� ����Ʈ���� �� �л��� ��� ������ ������ �׶��׶� ī��Ʈ�� �ø�
					if (studentList.get(i).subjectName.equals("����")) {
						cnt1++;
					} else {
						continue;
					}
				}
				System.out.println("���� ���� �л����� : " + cnt1); // ī��Ʈ �ö� ���� �������
				break;
			}
			case "2": {

				int cnt1 = 0;
				for (int i = 0; i < studentList.size(); i++) { // �л� ����Ʈ���� �� �л��� ������ ������ ������ �׶��׶� ī��Ʈ�� �ø�
					if (studentList.get(i).subjectName.equals("����")) {
						cnt1++;
					} else {
						continue;
					}
				}
				System.out.println("���� ���� �л����� : " + cnt1); // ī��Ʈ �ö� ���� �������
				break;
			}
			case "3": {

				int cnt1 = 0;
				for (int i = 0; i < studentList.size(); i++) { // �л� ����Ʈ���� �� �л��� ��� ������ ������ �׶��׶� ī��Ʈ�� �ø�
					if (studentList.get(i).subjectName.equals("����")) {
						cnt1++;
					} else {
						continue;
					}
				}
				System.out.println("���� ���� �л����� : " + cnt1); // ī��Ʈ �ö� ���� �������
				break;
			}
			default:
				System.out.println("�߸� �Է� �ϼ̽��ϴ�. [1 ~ 3] ���ڸ� �Է��ϼ���.");
			}
		}

		void studentsEnrolled2() { // ���� �л� �̸� ���ϴ� �޼ҵ�
			String num = null;
			num = sc.nextLine();
			switch (num) {
			case "1": {

				for (int i = 0; i < studentList.size(); i++) {
					if (studentList.get(i).subjectName.equals("����")) { // �л� ����Ʈ���� �� �л��� ��� ������ ������ �׶��׶� ����� ��
						System.out.print(studentList.get(i).studentName + ",");
					} else {
						continue;
					}
				}
				System.out.println("��/�� ������Դϴ�.");
				break;
			}
			case "2": {

				for (int i = 0; i < studentList.size(); i++) {
					if (studentList.get(i).subjectName.equals("����")) { // �л� ����Ʈ���� �� �л��� ���и� ������ ������ �׶��׶� ����� ��
						System.out.print(studentList.get(i).studentName + ",");
					} else {
						continue;
					}
				}
				System.out.println("��/�� ������Դϴ�.");
				break;
			}
			case "3": {

				for (int i = 0; i < studentList.size(); i++) { // �л� ����Ʈ���� �� �л��� ��� ������ ������ �׶��׶� ����� ��
					if (studentList.get(i).subjectName.equals("����")) {
						System.out.print(studentList.get(i).studentName + ",");
					} else {
						continue;
					}
				}
				System.out.println("��/�� ������Դϴ�.");
				break;
			}
			default:
				System.out.println("�߸� �Է� �ϼ̽��ϴ�. [1 ~ 3] ���ڸ� �Է��ϼ���.");
			}
		}

	}