package javaMid3.ex13;

public class Data {
// ������Ŭ���� �θ�Ŭ����. ����,����,����,���� -> Data Ŭ������ �θ�� �Ѵ�.
	private final static int PRICE_COMPUTER = 2000000; // ��ǻ�� ������ 2000000, ������ ������ 500000 ����
	private final static int PRICE_PRINTER = 500000; // ����� ���߿� ������. ������ �Ժη� ���� ����

	String product; // ��ǻ��,������...����
	String company; // 1,2,3,4 ���� ����
	int price;
	int count;
	int sale; // �ǸŽ���

	// String company�� �޴� �޼ҵ带 �����ϴµ� �ڽİ� ���ा����?�ƴ��� �����ڷ� �غ���.

//	���� ��Ȳ�� ������ִ� �޼ҵ带 �����. ���� �ڽ�Ŭ�������� �������̵�
	public Data() {
		// TODO Auto-generated constructor stub
	}

//	�����ڷ� �ڽ��� �����ڸ� ���� �����Ѵ�.
//	�޼ҵ����� �ڽĸ޼ҵ带 ȣ���ؼ� �θ��� �޼ҵ带 ����ϴ� ����̴�. �ڽ�Ŭ�������� ������ �ٸ����� �����Ƿ� �����ڷ� �����ϰ� �غ��Ҵ�.
	public Data(String company) {
		this.company = company;
	}

	void Price(String product) {
		if (product.equals("��ǻ��")) {
			this.price = PRICE_COMPUTER;
		} else
			this.price = PRICE_PRINTER;

	}

	void Calculator() {
		this.sale = price * count;
	}

}
