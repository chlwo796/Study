package ch04.sec03;

public class SwitchNoBreakCaseExample {

	public static void main(String[] args) {
//		Break ���� switch-case ���α׷� ����
//		8~11 number random
		int a = (int) ((Math.random() * 3) + 8);
		System.out.println("����ð���" + a + "�� �Դϴ�.");

		switch (a) {
		case 8:
			System.out.println("�ܱ��� �մϴ�.");
		case 9:
			System.out.println("�߱��� �մϴ�.");
		case 10:
			System.out.println("������ ���ϴ�.");
		default:
			System.out.println("����� �մϴ�.");
		}
//		�� case���� break;�� ������ a������ ������� case, default�� ��� ����ȴ�.
//		ó���� 9�� ���Դٸ� 8 ���� x -> 9, 10, default ��� ���� -> �׷��� break;�� �ʿ��ϴ�.

	}

}
