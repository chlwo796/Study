package javaMid3.ex14;

public class School {	//����б������ͱ��� ���� �����Ѵ�.	// �Է½� �θ�Ÿ������ ���� �����Ѵ�.
//	ScoreManager class ���� �����͸� �޾� �� �ڽ�Ŭ������ �޼ҵ带 �������̵��Ѵ�.
//	ǥ�������� �׳� ���� �����ϴ� ������ �Ѵ�.
	
	String subject;	// ���񸶴� ������ ���� �����.
	String teacher; // �����Ը��� ������ ���� �����. -> subject�� teacher�� �ѹ���
	String test;	// �߰� or �⸻
	int totalScore;	// ��� �ջ�
	int midExam;	// �߰����
	int finalExam;	// �⸻���
	int performTest;	// ������
	int attendance;	// �⼮����
	int volunteer;	//��������
	double sd; // ǥ������
	
	void cal() {
		System.out.println("�θ��� �����Դϴ�. �����Ͱ� �����ϴ�.");
	}
}