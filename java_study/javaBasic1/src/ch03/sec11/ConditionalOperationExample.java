package ch03.sec11;

public class ConditionalOperationExample {

	public static void main(String[] args) {
		// ����(����)������
		// (����1) ? x : ((����2)? y : z) ���� 1�ΰ���? true = x, false = ����2 �ΰ���? true = y, false = z
		int score = 93;
		char grade = (score > 90) ? 'A' : ((score > 80) ? 'B' : 'C');
		System.out.println(score + "���� " + grade + "����Դϴ�.");
	}

}
