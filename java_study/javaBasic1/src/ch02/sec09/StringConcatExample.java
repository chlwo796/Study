package ch02.sec09;

public class StringConcatExample {

	public static void main(String[] args) {
		// �������� ����
		int v1 = 10 + 11 + 23;
		System.out.println(v1);

		String v2 = 10 + 20 + "1";
		System.out.println(v2);

		String v3 = 10 + "30" + "22";
		System.out.println(v3);

		String v4 = "10" + 30 + 22;		//���ڿ������� ���� ����Ǹ� �ڿ� ���굵 ���ڿ�����
		System.out.println(v4);

		String v5 = "10" + (30 + 22);	//��ȣ�ȿ� ���� ��������
		System.out.println(v5);

	}

}
