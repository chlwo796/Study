package ch02.sec01;

public class VariableInitializationExample {

	public static void main(String[] args) {

		// int value;// ���� value�� ����
		
		// int result = value + 10; // ���� result�� ���� value + 10 �� ���� �־���
		
		// System.out.println(result);	// ���� result ���

		// Exception in thread "main" java.lang.Error: Unresolved compilation problem: 
		// The local variable value may not have been initialized
		
		// �� ������ ������ value��� ������ ���� �ʱ�ȭ���� �ʾƼ� ����� �����̴�.
		
		int value = 5; // ��ó�� value��� ������ 5��� ���� �ʱ�ȭ�Ͽ�
		
		int result = value + 6; // ���� result�� �־��ش�.
		
		System.out.println(result); //�����۵�
		

	}

}
