package ch04.sec01;

public class for500 {

	public static void main(String[] args) {
//		100~1 ����� ���� 500, 1000, 1500, 2000 ...5000�϶� i��
//		�˰��� ¥��
//		�� ���� ������ 500�� ���� ��, �׼����� i�� ��� �ѹ���
//		�ٽ� for, �׷��� 500 ������ �׶��� i ���� ����Ѵٸ�?
		
		int sum = 0;
		int i = 100;
		int value = 500;

		for (; i >= 1; i--) {
			sum = sum + i;
			for (; sum > value; value += 500) {
				System.out.println(i);
			}

		}

	}

}
