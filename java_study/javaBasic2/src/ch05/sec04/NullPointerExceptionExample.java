package ch05.sec04;

public class NullPointerExceptionExample {

	public static void main(String[] args) {
//		Null

		String str1 = "�ڹ�";
		String str2 = null;

		System.out.println(str1 == str2);
		System.out.println(str1 != str2);
		
		int[] array1 = null;	// null�̶�� ���� �ʱⰪ���� ����� �����ϴ�. ���� heap memory�� �ּҸ� �������� �ʰ� �ٷ� stack�� �����ȴ�.
//		array1[0] = 10;			// �׷��� array1 �迭�� 0�ڸ��� 10�� �����ϸ� ������ �߻��Ѵ�. 
								// int[] array1 �迭�� ������ heap memory �ּ�(�迭��ü)�� ����.
//		System.out.println(array1);	// NullPointerExceptionExample
		
		String str3 = null;		// null���� str2�� ����
//		System.out.println(str3.length());	// ���ڿ��� ���̸� ȣ���ϴ� method .length();�� ���������� �����߻�
		
	}

}
