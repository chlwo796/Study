package ch04.sec03;

public class SwitchCharExample {

	public static void main(String[] args) {
//		switch-case variable ����
//		switch-case�� ������ ����Ÿ��(byte, short, char, int, long) ���ڿ�Ÿ��(String) ������ ����� �� �ִ�.
		
		char grade = 'A';

		switch (grade) {
		case 'a':
		case 'A':
			System.out.println("���ȸ���Դϴ�");
			break;
		case 'b':	// ��ҹ��� ������� �ϴ� ��� ���๮�� �ϳ��θ� �ϸ� ����
		case 'B':
			System.out.println("�Ϲ�ȸ���Դϴ�");
			break;
		default:
			System.out.println("�ƹ��͵��ƴմϴ�");
		}
//		char������ Ȱ���Ͽ� ����� ����ϱ�(��ҹ��� �������)
	}

}
