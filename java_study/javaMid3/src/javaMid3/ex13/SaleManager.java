package javaMid3.ex13;

import java.util.Scanner;

public class SaleManager {
	Scanner sc = new Scanner(System.in);
	Data data = new Data();
	Data[] dataArray = new Data[100];
	int i = 0;

// 	��������...String choice �� ���� ��ü������ ���� �ؾ��Ѵ�
	void input() {
		while (true) {
			System.out.println("1. ��������, 2. ��������, 3. �������� 4. ��������");
			System.out.println("����?");
			String choice = sc.nextLine();
			switch (choice) {
			case "1": // ������ ��ü���� �� �� ������ ��ǲ�޼ҵ� ����
				data = new Seoul();
				break;
			case "2":
				data = new Gyeongin();
				break;
			case "3":
				data = new Gangwon();
				break;
			case "4":
				data = new Jeju();
				break;
			default:
			}
			System.out.println("��ǰ��?");
			data.product = sc.nextLine();

			System.out.println("�Ǹŷ���?");
			data.count = sc.nextInt();
			sc.nextLine();
			System.out.println("��� �Է��Ͻðڽ��ϱ�?(y/n)");
			String yn = sc.nextLine();

			data.Price(data.product);
			data.Calculator();
			dataArray[i++] = data;

			if (yn.equals("y")) {
				continue;

			} else
				break;
		}

	}

	void output() {
//		��갪 �޾ƿͼ� ��¸� �Ѵ�. �迭���?
//		data.sale;

		System.out.println("-----------------");
		System.out.println("�� ���纰 �Ǹ� ��Ȳ");
		System.out.println("-----------------");
		System.out.println("�����   ��ǰ��  ��ǰ����  �Ǹŷ�  ������Ȳ");
		System.out.println("-----------------");
		for (int i = 0; i < dataArray.length; i++) {
			if (dataArray[i] == null) {
				break;
			}
			System.out.println(dataArray[i].company + " " + dataArray[i].product + " " + dataArray[i].price + " "
					+ dataArray[i].count + " " + +dataArray[i].sale);
		}

	}
}
