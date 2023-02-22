package javaHigh06.example05;

import java.util.Random;

public class MathExample {
	public static void main(String[] args) {
		double d1 = Math.ceil(5.3);
		// MathŬ������ static final ����� ��� ��� Ŭ������.�����
		System.out.println(Math.PI);
		// �޼ҵ带 �������̵� �� �� ����. static Ŭ������ ������� �ʴ´�.
		System.out.println(Math.max(1.1, 2.3));
		System.out.println(Math.random());
		System.out.println(Math.round(25.77));
		// ���� ��� ��� �ſ� �߿�
		// Util�� Random Ŭ������ static �� �ƴϱ⶧���� ��ü�������ش�.
		Random rd1 = new Random();
		System.out.println(rd1.nextBoolean());
		System.out.println(rd1.nextDouble());
		System.out.println(rd1.nextInt());
		// rd1.nextInt(int n) = intŸ���� ����(0<=x<n)�� ����
		// ����Ʈ���� ��ǰ��ȣ ����, ��й�ȣ ��ȣȭ/��ȣȭ �� ���
		System.out.println(rd1.nextInt(100));
	}
}
