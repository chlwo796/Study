package javaMid3.ex12;

public class Buyer {
	int money = 1000;
	int bonusPoint = 0;
	int i = 0;
	Product[] item = new Product[10];

	void buy(Product p) {
		if (money < p.price) {
			System.out.println("�ܾ׺���");
			return;
		}
//		return ��(if�� ������ �ƴҰ��) �Ʒ� ����.(else�� ���� ����)
		money -= p.price;
		bonusPoint += p.bonusPoint;
		item[i++] = p; // �ּҸ� �����Ѵ�!! ���� i ���� �ϳ� �ø���.
//		�ܺο��� ���� �޾ƿ��� ���� �ƴϱ� ������ this.i = i;�� �ʿ䰡 ����. 
		System.out.println("���ԿϷ�");

	}

	void summary() {
		int sum = 0;
	
		String itemList = "";

		for (int i = 0; i < item.length; i++) {
			if (item[i] == null) {
				System.out.println(item[i]);
				break;
			}
			sum = sum + item[i].price;
			itemList = itemList + item[i] + ", ";
		}
		System.out.println("�����Ͻ� �� �ݾ��� " + sum + "�����Դϴ�.");
		System.out.println("��ǰ�� " + itemList + "�Դϴ�.");
	}
}
