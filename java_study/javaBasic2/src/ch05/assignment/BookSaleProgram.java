package ch05.assignment;

import java.util.Scanner;

public class BookSaleProgram {

	public static void main(String[] args) {
//		�����Ǹ� ������Ʈ
//		input = ������, ����, �ֹ�����, �Ǹ�ó, ���Թ��
//		������ = ���� 10%, ���ͳ� 15%, ���� 10%, ī�� 5% ��ø����

//		�迭�� �غ���? 3���̴ϱ� String strArray = new String[3]?
		Scanner sc = new Scanner(System.in);
		Bookstore[] bs = new Bookstore[3];
//		Bookstore[] bs = { new Bookstore(), new Bookstore(), new Bookstore() };

		for (int i = 0; i < bs.length; i++) {
			bs[i] = new Bookstore();
			System.out.print("������>");
			bs[i].setBookName(sc.nextLine());
			System.out.print("����>");
			bs[i].setOriginPrice(sc.nextInt());
			System.out.print("�ֹ�����>");
			bs[i].setOrderNumber(sc.nextInt());
			sc.nextLine();
			System.out.print("�Ǹ�ó>");
			bs[i].setWhere(sc.nextLine());
			System.out.print("���Թ��>");
			bs[i].setWay(sc.nextLine());

			bs[i].calculator();
		}

		System.out.println("������\t����\t������\t�ֹ�����\t�Ǹűݾ�\t�Ǹ�ó\t���Թ��");
		for (int i = 0; i < bs.length; i++) {
			System.out.println(bs[i].getBookName() + "\t" + bs[i].getOriginPrice() + "\t" + bs[i].getRate() + "\t"
					+ bs[i].getOrderNumber() + "\t" + bs[i].getSalePrice() + "\t" + bs[i].getWhere() + "\t"
					+ bs[i].getWay());
		}

//		for(int i = 0; i<bsArray.length;i++) {
//		System.out.print("������>");
//		
//		System.out.print("����>");
//		System.out.print("�ֹ�����>");
//		System.out.print("�Ǹ�ó>");
//		System.out.print("���Թ��>");
//		
//	}
	}
}

class Bookstore {

	String bookName;
	int originPrice;
	int orderNumber;
	String where;
	String way;
	double rate;
	int salePrice;

	public void calculator() {

		if (way.equals("����")) {
			rate = 0.1;
		} else
			rate = 0.15;

		if (where.equals("����")) {
			rate = rate + 0.1;
		} else
			rate = rate + 0.05;
//		switch (way) {
//		case "����": {
//			rate = 0.1;
//			break;
//		}
//
//		case "���ͳ�": {
//			rate = 0.15;
//			break;
//		}
//		default:
//		}
//
//		switch (where) {
//		case "����": {
//			rate = rate + 0.1;
//			break;
//		}
//		case "ī��": {
//			rate = rate + 0.05;
//			break;
//		}
//		default:
//		}
		salePrice = (int) ((1 - rate) * (originPrice));
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public int getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(int salePrice) {
		this.salePrice = salePrice;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public int getOriginPrice() {
		return originPrice;
	}

	public void setOriginPrice(int originPrice) {
		this.originPrice = originPrice;
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getWhere() {
		return where;
	}

	public void setWhere(String where) {
		this.where = where;
	}

	public String getWay() {
		return way;
	}

	public void setWay(String way) {
		this.way = way;
	}
}
