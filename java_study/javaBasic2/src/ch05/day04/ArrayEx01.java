package ch05.day04;

public class ArrayEx01 {

	public static void main(String[] args) {
//		Array

		int[] a1; // �ΰ��� ������� ������ ������ �� �ִµ� ù��° ����� ��������
		int a2[];

//		a2 = 10;	// 10�̶�� ���� �迭�� ��� �ּҷ� ���� ���� ������ ��
		a2 = null; // �������� ����

//		�迭 �ȿ� ���� �ִ� ���
//		1. �ʱⰪ���� �ֱ�, 2. �迭 ����� ���� �ʿ��ϸ� �־��ش�
		int[] a3 = { 1, 2, 3, 4, 5, 6 }; // 0~5������ �����ȴ�.
		System.out.println(a3[3]); // 3��
		System.out.println(a3[5]); // 5��

//		����1. 1.1,3.3,5.4,10.3,8.9,11.23
//		10.3- 3.3 �ϱ�

		double[] a4 = { 1.1, 3.3, 5.4, 10.3, 8.9, 11.23 };
		double a5 = (a4[3] - a4[1]);
		System.out.println(Math.round(a5)); // Math.round(); = �Ҽ����� �ڸ���.

//		����2. true, false, false, true, true, false, false, true
//		���� �������� �ִ� true ���.

		boolean[] a6 = { true, false, false, true, true, false, false, true };
		System.out.println(a6[7]);

//		����3. "������", "���", "������", "����" ����� ���, ������ ���

		String[] a7 = { "���", "���", "������", "����" };
		System.out.println(a7[1] + ", " + a7[2]);

//		�迭�� index�� �����Ͽ� ���� ��� ����ϴ� ���� �ƴ�
//		�ݺ����� �̿��� ���� �ѹ��� ����ϱ�
//		.length = method�� �ƴ� �Ӽ�

		System.out.println("a3 �迭�� ����(ũ��) = " + a3.length);

		for (int i = 0; i < a3.length; i++) { // i < 6 �� �ƴ� �迭�� ũ�⸦ �����ؼ� ����
			System.out.print(a3[i] + " ");
		}
		System.out.println();

		for (int i = 0; i < a4.length; i++) {
			System.out.print(a4[i] + " ");
		}
		System.out.println();

		for (int i = 0; i < a6.length; i++) {
			System.out.print(a6[i] + " ");
		}
		System.out.println();
		for (int i = 0; i < a7.length; i++) {
			System.out.print(a7[i] + " ");
		}
		System.out.println();
		
//		���� for Ȱ��(Datatype variable : arrayname) �迭�� �ִ� ���Ҹ� �Ѱ��� ������ �տ� ������ �ִ´�.
//		���������� ������ ���� �־��ָ� �� �̻� �ݺ����� �ʴ´�.
//		�迭 Ÿ��[]�� �ٽ� ���� �ʴ´�.
		
		for(int a : a3) {
			System.out.print(a + " ");
		}
		System.out.println();
		
		for(double a : a4) {
			System.out.print(a + " ");
		}
		System.out.println();
		
		for(boolean a : a6) {
			System.out.print(a + " ");
		}
		System.out.println();
		
		for(String a : a7) {
			System.out.print(a + " ");
		}
		System.out.println();
	}

}
