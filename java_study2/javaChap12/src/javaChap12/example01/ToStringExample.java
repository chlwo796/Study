package javaChap12.example01;

public class ToStringExample {
	public static void main(String[] args) {
		SmartPhone smartPhone = new SmartPhone("�Ｚ����", "�ȵ���̵�");
		
		String str = smartPhone.toString();
		
		System.out.println(str);
		System.out.println("��ü�� �ּҸ� ���� ������ �־��൵ �ڵ����� toString �޼ҵ� ȣ��");
		System.out.println(smartPhone);
	}
}
