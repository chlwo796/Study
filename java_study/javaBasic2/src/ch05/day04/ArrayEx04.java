package ch05.day04;

import java.util.Scanner;

public class ArrayEx04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Movie[] mv = { new Movie(), new Movie(), new Movie() };
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < mv.length; i++) {

			System.out.println((i + 1) + "��° ��ȭ�� �Է��ϼ���. ��ȭ>");
			mv[i].setMovie(sc.nextLine());
			System.out.println(mv[i].getMovie() + "��Ƽ�ϰ����� �Է��ϼ���>");
			mv[i].setPrice(sc.nextInt());
			System.out.println((i + 1) + "��°���� ���̸� �Է��ϼ���.>");
			mv[i].setAge(sc.nextInt());
			sc.nextLine();
			System.out.println((i + 1) + "��°���� ���Ź���� �Է��ϼ���.>");
			mv[i].setBuy(sc.nextLine());

			mv[i].calculator(mv[i].getBuy(), mv[i].getAge(), mv[i].getPrice());

		}

		System.out.println("��ȭ��\t�ݾ�\t����\t�Ǳ��űݾ�");

		for (int i = 0; i < mv.length; i++) {
			System.out.println(mv[i].getMovie() + "\t" + mv[i].getPrice() + "\t" + mv[i].getAge() + "\t" + mv[i].getSalePrice());
//			Calculator���� ������� salePrice ���� �ٷ� mv[i].salePrice�� ȣ���Ͽ��� ������,
//			salePrice��� ������ class Movie �Ҽ� �ʵ��̱� ������(��������) mv[i].getSalePrice()�� ȣ���Ͽ��� ���� ������� ���´�.
//			�������� �帧�� �����ϰ� �� �׷� �帧�� ���̴��� �� �ľ��ؾ��Ѵ�.
		}
	}
}

class Movie {
	int price;
	String movie;
	int age;
	String buy;
	int salePrice;
	double salePercent;
//	double salePercent1;	// ������ �ϳ��� �����ϸ� ���� �� ����.

	public void calculator(String buyKind, int age, int price) {
		if (age < 20) {
			salePercent = 0.25;
		} else if (20 <= age && age < 30) {
			salePercent = 0.2;
		} else {
			salePercent = 0.15;
		}
		switch (buyKind) {
		case "����": {
//			salePercent1 = 0.1;	// ������ �ϳ��� �����ϱ� ���Ͽ� ������.
			salePercent = salePercent + 0.1;	// �����Ͽ� �����ش�.(��������)
			break;
		}
		case "���ͳ�": {
//			salePercent1 = 0.05;
			salePercent = salePercent + 0.05;
			break;
		}
		default: {
//			salePercent1 = 0;
			break;
		}
		}
//		salePrice = (int) ((1 - (salePercent + salePercent1)) * price);	// ���� ���ʿ��� ������ �ϳ� �� �ִ� �� �ϴ�.
		salePrice = (int)((1-salePercent) * price);
	}

	public int getPrice() {
		return price;
	}

	public int getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(int salePrice) {
		this.salePrice = salePrice;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getMovie() {
		return movie;
	}

	public void setMovie(String movie) {
		this.movie = movie;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getBuy() {
		return buy;
	}

	public void setBuy(String buy) {
		this.buy = buy;
	}
}
