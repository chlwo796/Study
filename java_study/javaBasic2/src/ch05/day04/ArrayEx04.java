package ch05.day04;

import java.util.Scanner;

public class ArrayEx04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Movie[] mv = { new Movie(), new Movie(), new Movie() };
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < mv.length; i++) {

			System.out.println((i + 1) + "번째 영화를 입력하세요. 영화>");
			mv[i].setMovie(sc.nextLine());
			System.out.println(mv[i].getMovie() + "의티켓가격을 입력하세요>");
			mv[i].setPrice(sc.nextInt());
			System.out.println((i + 1) + "번째고객의 나이를 입력하세요.>");
			mv[i].setAge(sc.nextInt());
			sc.nextLine();
			System.out.println((i + 1) + "번째고객의 구매방법을 입력하세요.>");
			mv[i].setBuy(sc.nextLine());

			mv[i].calculator(mv[i].getBuy(), mv[i].getAge(), mv[i].getPrice());

		}

		System.out.println("영화명\t금액\t나이\t실구매금액");

		for (int i = 0; i < mv.length; i++) {
			System.out.println(mv[i].getMovie() + "\t" + mv[i].getPrice() + "\t" + mv[i].getAge() + "\t" + mv[i].getSalePrice());
//			Calculator에서 계산해준 salePrice 값을 바로 mv[i].salePrice로 호출하여도 되지만,
//			salePrice라는 변수는 class Movie 소속 필드이기 때문에(전역변수) mv[i].getSalePrice()로 호출하여도 같은 결과값이 나온다.
//			변수들의 흐름을 이해하고 왜 그런 흐름을 보이는지 꼭 파악해야한다.
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
//	double salePercent1;	// 변수를 하나로 통일하면 좋을 것 같다.

	public void calculator(String buyKind, int age, int price) {
		if (age < 20) {
			salePercent = 0.25;
		} else if (20 <= age && age < 30) {
			salePercent = 0.2;
		} else {
			salePercent = 0.15;
		}
		switch (buyKind) {
		case "쿠폰": {
//			salePercent1 = 0.1;	// 변수를 하나로 통일하기 위하여 수정함.
			salePercent = salePercent + 0.1;	// 누적하여 더해준다.(수정내용)
			break;
		}
		case "인터넷": {
//			salePercent1 = 0.05;
			salePercent = salePercent + 0.05;
			break;
		}
		default: {
//			salePercent1 = 0;
			break;
		}
		}
//		salePrice = (int) ((1 - (salePercent + salePercent1)) * price);	// 뭔가 불필요한 변수가 하나 더 있는 듯 하다.
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
