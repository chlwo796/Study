package javaMid3.ex13;

public class Data {
// ������Ŭ���� �θ�Ŭ����. ����,����,����,���� -> Data Ŭ������ �θ�� �Ѵ�.
	String product;
	String company;
	int price;
	int priceC = 2000000; // ��ǻ�� ������ 2000000, ������ ������ 500000 ����
	int priceP = 500000;
	int count;
	int sale; // �ǸŰ���
//	String company�� �޴� �޼ҵ带 �����ϴµ� �ڽİ� ���ा����?�ƴ��� �����ڷ� �غ���.
	
//	���� ��Ȳ�� ������ִ� �޼ҵ带 �����. ���� �ڽ�Ŭ�������� �������̵�
	public Data() {
		// TODO Auto-generated constructor stub
	}

	public Data(String company) {
		System.out.println("�߸���ȸ���ȣ");
	}

	void calculator() {
		if (product.equals("��ǻ��")) {
			this.sale = priceC * count;
		} else
			this.sale = priceP * count;
	}

}
