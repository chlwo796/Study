package ch04.sec04;

public class SumFron1to100Example {

	public static void main(String[] args) {
//		1���� 100������ ��, forȰ��
		int sum = 0;
		int i;
		for (i = 1; i <= 100; i++) {
			sum = sum + i;
		}
		System.out.println("1���� " + (i-1) + "������ �� = " + sum);
//		sum�̶�� ������ �ʱⰪ�� 0���� �������ְ�, for�� ���� i�� 1���� 100���� �ݺ������ ������,
//		sum�̶�� ������ i���� ��� �����ش�(�����հ�)
//		sum�̶�� ������ for {}�ȿ��� �������ָ� for �ۿ��� �ѹ��� ����� ���� ���� ����� ������ �ʴ´�.
//		��¿� (i-1)�� ���� = i���� ����������(i = 100) sum�� ������ְ� i++�� �� �� (i = 101)�� for���� ����ȴ�. 
	}

}
