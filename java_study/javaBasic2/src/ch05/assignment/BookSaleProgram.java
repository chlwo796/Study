package ch05.assignment;

import java.util.Scanner;

public class BookSaleProgram {

	public static void main(String[] args) {
//		도서판매 프로젝트
//		input = 도서명, 정가, 주문수량, 판매처, 구입방법
//		할인율 = 서점 10%, 인터넷 15%, 현금 10%, 카드 5% 중첩가능

//		배열로 해볼까? 3번이니까 String strArray = new String[3]?
		Scanner sc = new Scanner(System.in);
		Bookstore[] bs = new Bookstore[3];
//		Bookstore[] bs = { new Bookstore(), new Bookstore(), new Bookstore() };

		for (int i = 0; i < bs.length; i++) {
			bs[i] = new Bookstore();
			System.out.print("도서명>");
			bs[i].setBookName(sc.nextLine());
			System.out.print("정가>");
			bs[i].setOriginPrice(sc.nextInt());
			System.out.print("주문수량>");
			bs[i].setOrderNumber(sc.nextInt());
			sc.nextLine();
			System.out.print("판매처>");
			bs[i].setWhere(sc.nextLine());
			System.out.print("구입방법>");
			bs[i].setWay(sc.nextLine());

			bs[i].calculator();
		}

		System.out.println("도서명\t정가\t할인율\t주문수량\t판매금액\t판매처\t구입방법");
		for (int i = 0; i < bs.length; i++) {
			System.out.println(bs[i].getBookName() + "\t" + bs[i].getOriginPrice() + "\t" + bs[i].getRate() + "\t"
					+ bs[i].getOrderNumber() + "\t" + bs[i].getSalePrice() + "\t" + bs[i].getWhere() + "\t"
					+ bs[i].getWay());
		}

//		for(int i = 0; i<bsArray.length;i++) {
//		System.out.print("도서명>");
//		
//		System.out.print("정가>");
//		System.out.print("주문수량>");
//		System.out.print("판매처>");
//		System.out.print("구입방법>");
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

		if (way.equals("서점")) {
			rate = 0.1;
		} else
			rate = 0.15;

		if (where.equals("현금")) {
			rate = rate + 0.1;
		} else
			rate = rate + 0.05;
//		switch (way) {
//		case "서점": {
//			rate = 0.1;
//			break;
//		}
//
//		case "인터넷": {
//			rate = 0.15;
//			break;
//		}
//		default:
//		}
//
//		switch (where) {
//		case "현금": {
//			rate = rate + 0.1;
//			break;
//		}
//		case "카드": {
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
