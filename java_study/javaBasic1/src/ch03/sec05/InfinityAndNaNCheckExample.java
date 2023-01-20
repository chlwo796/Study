package ch03.sec05;

public class InfinityAndNaNCheckExample {

	public static void main(String[] args) {
		// Infinity(���Ѵ�), NaN(Not a Number)
		// ������ Ȥ�� %���꿡�� �����ǿ����ڰ� �����̰� ���� �ǿ����ڰ� 0�� ��� ArithmeticException �߻�.
		int x = 5;
		double y = 0.0;
		double z = x / y; // ���� �ǿ����ڰ� �Ǽ���, Ȥ�� ���� �ǿ����ڰ� 0.0, 0.0f�̸� ���ܰ� �ƴ� Infinity, NaN ���.
		// double z = x%y; // �߸��� �ڵ�
		System.out.println(z + 2);

		if (Double.isInfinite(z) || Double.isNaN(z)) {
			System.out.println("�� ���� �Ұ�");
		} else {
			System.out.println(z + 2);
		}

	}

}
