package ch04.sec03;

public class SwitchExample {

	public static void main(String[] args) {
//		Switch-case�� �ֻ��� ��ȣ ���

		int a = (int) ((Math.random() * 6) + 1);
		System.out.println(a);
		switch (a) {
		case 1:
			System.out.println(a + "���Դϴ�");
			break;
		case 2:
			System.out.println(a + "���Դϴ�");
			break;
		case 3:
			System.out.println(a + "���Դϴ�");
			break;
		case 4:
			System.out.println(a + "���Դϴ�");
			break;
		case 5:
			System.out.println(a + "���Դϴ�");
			break;
		default:
			System.out.println(a + "���Դϴ�");
		}

	}

}
