package ch04.jhc;

public class Example4 {

	public static void main(String[] args) {
//		while, Math.random(), �ΰ��� �ֻ����� ������ �� ������ ���� (a, b)���·� ����ϰ� ���� 5�� ��������

//		System.out.println(Math.random());	// 0~0.9999999���� ���
//		System.out.println((Math.random()*6));	// 0~5.9999
//		System.out.println((int)(Math.random()*6));	// 0~5
//		System.out.println((int)((Math.random()*6))+1);	// �ֻ��� ���� �Ϸ�

		int a = 0;
		int b = 0;
		while (a+b !=5) {
			a = (int) ((Math.random() * 6)) + 1;
			b = (int) ((Math.random() * 6)) + 1;
			System.out.println("(" + a + ", " + b + ")");
		}

	}

}
