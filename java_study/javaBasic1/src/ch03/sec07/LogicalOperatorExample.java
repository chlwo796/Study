package ch03.sec07;

public class LogicalOperatorExample {

	public static void main(String[] args) {
		// ��������

		int charCode = 'A';
		// int charCode = 'a';
		// int charCode = '5'; // char Ÿ���� ������ intŸ������ ����. �ƽ�Ű�ڵ� ���ڷ� �Ǻ� ����.

		if ((65 <= charCode) & (charCode <= 90)) {
			System.out.println("�빮���Դϴ�.");
		}
		if ((97 <= charCode) && (charCode <= 122)) {
			System.out.println("�ҹ����Դϴ�.");
		}
		if ((48 <= charCode) && (charCode <= 57)) { // &, && �Ѵ� ����
			System.out.println("0~9 �����Դϴ�.");
		}

		// int value = 6;
		int value = 7;

		if ((value % 2 == 0) | (value % 3 == 0)) {
			System.out.println("2 Ȥ�� 3�� ����Դϴ�.");
		}

		boolean result = (value % 2 == 0) || (value % 3 == 0); // |, || �Ѵ� ����
		if (!result) {
			System.out.println("2 Ȥ�� 3�� ����� �ƴմϴ�."); // !result = value�� 2 Ȥ�� 3���� ���������� ���� �ѹ��̶� �������� 0�� �ƴϸ�
		}

	}

}
