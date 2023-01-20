package ch05.day02;

import java.util.Scanner;

public class ClassEx01 {

	public static void main(String[] args) {
//		class �ǽ�
//		1. Ŭ���� �ʵ��� ���� ���� �־��ش�.
		Product product = new Product();
//		Product��� �̸����� heap memory�� �ּҸ� �����ϸ� 
//		product��� ������ ������ heap memory�� Product �ּҸ� �ڷ������� �Ѵ�.
//		�Է� �޼ҵ� ȣ��
		inputMethod(product);

//		���ο� ��ü�� �����Ͽ� method �ݺ� ���� ����
		Product product1 = new Product();
		inputMethod(product1);

		Product product2 = new Product();
		inputMethod(product2);

//		�Ǹűݾ� ���ϱ�
		int salePrice = product.salePriceMethod(product.proPrice, product.proCnt);

		String attainMent = product.attainMentMethod(salePrice);

		System.out.println("����ϱ�");
		System.out.println("��ǰ�ڵ� ��ǰ�� ���� ���� �Ǹűݾ� �޼�");
		System.out.println(product.proId + " " + product.proName + " " + product.proPrice + " " + product.proCnt + " "
				+ salePrice + " " + attainMent);
	}

//	�Է� ��� �޼ҵ� �����
	static void inputMethod(Product product) {
		System.out.println("-----------");
		System.out.println("������Ʈ �Ǹ�");
		System.out.println("----------");
		System.out.println();

		System.out.println("�Է�ȭ��");
//		�Է� ��������? 3�� �ޱ�

		Scanner sc = new Scanner(System.in);
		System.out.println();
		System.out.print("��ǰ�ڵ�> ");
//			�Է¹��� ���� Product class�� proId������ �ְ�ʹ�.
		product.proId = sc.next();
		System.out.print("��ǰ��> ");
		product.proName = sc.next();
		System.out.print("����> ");
		product.proPrice = sc.nextInt();
		System.out.print("����> ");
		product.proCnt = sc.nextInt();
		sc.nextLine();

	}
}

class Product {
	String proId;
	String proName;
	int proPrice;
	int proCnt;

//	(returnType) (method)
	int salePriceMethod(int proPrice, int proCnt) {
		int salePrice = proPrice * proCnt;
		return salePrice;

//			return proPrice * proCnt; // �ӽ�
	}

//	�Ǹűݾ� ���ϱ�
	String attainMentMethod(int salePrice) {
		if (salePrice >= 100000) {
			return "����";
		} else {
			return "���";
		}
	}
}
