package ch03.sec03;

public class OverflowUnderflowExample {

	public static void main(String[] args) {
		// �����÷ο�� ����÷ο�

		byte var1 = 125;
		for (int i = 0; i < 5; i++) {
			var1++;
			System.out.println(var1);		// Overflow. byte Ÿ���� �ִ������� 127���� 1�� ���ϸ� �ּҰ��� -128 �� ��µȴ�.
		}
		System.out.println("------------");

		byte var2 = -125;
		for (int i = 0; i < 5; i++) {
			var2--;
			System.out.println(var2);		// Underflow. byte Ÿ���� �ּ������� -128���� 1�� ���� �ִ밪�� 127�� ��µȴ�.
		}
	}

}
