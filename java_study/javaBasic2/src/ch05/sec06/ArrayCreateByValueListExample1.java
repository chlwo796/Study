package ch05.sec06;

public class ArrayCreateByValueListExample1 {

	public static void main(String[] args) {
//		�迭�� ����
		String[] array1 = { "ȣ����", "����", "��", "�����" };

		System.out.println(array1[0]);
		System.out.println(array1[1]);
		System.out.println(array1[2]);
		System.out.println(array1[3]);

		array1[1] = "�䳢"; // ���ο� value�� �迭�� ��ġ�� �����ؼ� ����

		System.out.println(array1[1]);

		int[] array2 = { 40, 50, 60 };
		int sum = 0;
		for (int i = 0; i < array2.length; i++) {
			sum = sum + array2[i];
		}
		int ave = sum / array2.length;

		System.out.println(sum + "\t" + ave);
	}

}
