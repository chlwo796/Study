package ch05.sec05;

public class EqualsExample {

	public static void main(String[] args) {
//		String ��

		String strA = "����ȯ";
		String strB = "����ȯ";

		if (strA == strB) {
			System.out.println("A�� B�� ������ ����");
		} else {
			System.out.println("A�� B�� ������ �ٸ���");
		}
		if (strA.equals(strB)) {
			System.out.println("A�� B�� ���ڿ��� ����");
		} else {
			System.out.println("A�� B�� ���ڿ��� �ٸ���");
		}
		String strC = new String("����ȯ");
		String strD = new String("����ȯ");
		
		if (strC == strD) {
			System.out.println("C�� D�� ������ ����");
		} else {
			System.out.println("C�� D�� ������ �ٸ���");
		}
		if (strC.equals(strD)) {
			System.out.println("C�� D�� ���ڿ��� ����");
		} else {
			System.out.println("C�� D�� ���ڿ��� �ٸ���");
		}
		
//		strC�� srtD�� ��ü�� ���� ���� �� ���� ���ڿ��� �����ϸ� ���� �����ּҴ� �ٸ���.
	}

}
