package javaMid3.ex13;

import java.util.Scanner;

public class SaleManager {
	Scanner sc = new Scanner(System.in);
	Data data;
	String company;
	String product;
	int sale;
	Data[] dataArray = new Data[10];

	public SaleManager() {
//		1�̸� ���������ּҸ� �����ؾ��ϰ�, 2�� �������� �ּҸ� �����ؾ��Ѵ�.
//		�װ͵��� �θ��� Data�� ��üȭ �ϰ�, �������̵� �ϸ� ��� ������ �� �ִ�.
	}

	void input(Data data) {
		System.out.println("-----------------");
		System.out.println("�Ǹŷ����� ������Ʈ");
		System.out.println("-----------------");
		while (true) {
			System.out.println("1. �Է�  2. ��� 3. ����");
			String choice = sc.nextLine();
			switch (choice) {
			case "1": {
				while (true) {
					System.out.println("1. ��������, 2. ��������, 3. �������� 4. ��������");
					System.out.println("����?");
					data.company = sc.nextLine();
					System.out.println("��ǰ��?");
					data.product = sc.nextLine();
					System.out.println(company + product + "�Ǹŷ���?");
					data.sale = sc.nextInt();
					sc.nextLine();
					System.out.println("��� �Է��Ͻðڽ��ϱ�?(y/n)");
					String yn = sc.nextLine();
					if (yn.equals("y")) {
						continue;

					} else
						break;
				}
			}
			case "2":
				break;
			case "3":
				break;
			default:
				break;
			}
		}

	}

	void output(Data data) {
//		��갪 �޾ƿͼ� ��¸� �Ѵ�. �迭���?
//		data.sale;

		System.out.println("-----------------");
		System.out.println("�� ���纰 �Ǹ� ��Ȳ");
		System.out.println("-----------------");
		System.out.println("�����   ��ǰ��  ��ǰ����  �Ǹŷ�  ������Ȳ");
		System.out.println("-----------------");
		for (int i = 0; i < dataArray.length; i++) {
			if (dataArray[i] == null) {
				System.out.println(dataArray[i]);
				break;
			}
			System.out.println(dataArray[i].company + " " + dataArray[i].product + " " + dataArray[i].price + " "
					+ dataArray[i].sale);
		}

	}
}
