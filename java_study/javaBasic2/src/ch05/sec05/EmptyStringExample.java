package ch05.sec05;

public class EmptyStringExample {

	public static void main(String[] args) {
//		"" ���ڵ� ������ �� �ִ�.

		String empty = ""; // ���ڵ� String ��ü�� ��������
		if (empty == "") {
			System.out.println("������ ���� ���� true");
		} else {
			System.out.println("������ ���� ���� false");
		}
		if (empty.equals("")) {
			System.out.println("���ڿ����� = ����");
		} else
			System.out.println("���ڿ����� = ���ھƴ�");
	}
}
