package javaMid3.ex14;

import java.util.Scanner;

public class School { // ����б������ͱ��� ���� �����Ѵ�. // �Է½� �θ�Ÿ������ ���� �����Ѵ�.
//	ScoreManager class ���� �����͸� �޾� �� �ڽ�Ŭ������ �޼ҵ带 �������̵��Ѵ�.
//	ǥ�������� �׳� ���� �����ϴ� ������ �Ѵ�.
	Scanner sc;
	String schoolName; // �������Ҷ����� school�̶�� ������ �� �ʵ��б�,���б�,����б��� �޾Ƽ� �����ڷ� ����Ѵ�. ScoreManager�� �����ϰ��Ϸ���
	String subject; // ���񸶴� ������ ���� �����.
	String teacher; // �����Ը��� ������ ���� �����. -> subject�� teacher�� �ѹ���
	String test; // �߰� or �⸻
	int totalScore; // ��� �ջ�
	int midExam; // �߰����
	int finalExam; // �⸻���
	int performTest; // ������
	int attendance; // �⼮����
	int volunteer; // ��������
	double sd; // ǥ������

//	public School[] getSchoolArray() {
//		return schoolArray;
//	}
//
//	public void setSchoolArray(School[] schoolArray) {
//		this.schoolArray = schoolArray;
//	}

	public School(String schoolName) {
//		�θ��� �⺻������.
		this.schoolName = schoolName;
		System.out.println("--------------");
		System.out.println(schoolName + " �����Դϴ�.");
		System.out.println("--------------");
	}

	void cal() {
		System.out.println("�θ��� �����Դϴ�. �����Ͱ� �����ϴ�.");
	}

	void print(School[] scoreArray) {
		System.out.println("�θ� �޼ҵ��Դϴ�. ����� ������ �����ϴ�.");

	}

	final void printAll(School[] scoreArray) {
		System.out.println("�����\t��米��\t�߰�\t�⸻\t������\t�⼮����\t��������\tǥ������\t����");
		for (int i = 0; i < scoreArray.length; i++) {
			if (scoreArray[i] == null) {
				return;
			}
			System.out.println(scoreArray[i].subject + "\t" + scoreArray[i].teacher + "\t" + scoreArray[i].midExam
					+ "\t" + scoreArray[i].finalExam + "\t" + scoreArray[i].performTest + "\t"
					+ scoreArray[i].attendance + "\t" + scoreArray[i].volunteer + "\t" + scoreArray[i].sd + "\t"
					+ scoreArray[i].totalScore);

		}
	}
}
