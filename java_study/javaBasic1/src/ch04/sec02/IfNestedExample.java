package ch04.sec02;

public class IfNestedExample {

	public static void main(String[] args) {
		// ������ ä�� ���α׷�
		// 81<=, <=100 �������� 0<=, <=19
		int score = (int) ((Math.random() * 19 + 81));

		String grade = null;	// method ��ü���� ���� �ʱⰪ(0) ����. �׷��� if �ۿ� �������� ����� ���� �����ϸ� ����ȴ�.

		if (score >= 90) {
			if (score >= 95) {
				grade = "A+";
			} else {
				grade = "A";
			}
		}
		if (score >= 80) {
			if (score >= 85) {
				grade = "B+";
			} else {
				grade = "B";
			}
		}
		System.out.println("���� : " + score + ", ���� : " + grade);
	}

}
