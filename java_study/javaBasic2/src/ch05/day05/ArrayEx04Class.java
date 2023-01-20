package ch05.day05;

import java.util.Scanner;

public class ArrayEx04Class {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		1줄 입력 - 실구매금액 계산, 2줄 입력 - 실 구매금액 계산/ 3줄 입력 - 실 구매금액 계산 ->반복문활용
//		1줄, 2줄, 3줄 반복 출력한다.
//		Movie[] m = {new Movie(), new Movie(), new Movie()};

		Movie[] m = new Movie[3];
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < m.length; i++) {
			m[i] = new Movie();
			System.out.println((i + 1) + "번째 레코드(줄)");
			System.out.print("영화명>");
			String movieName = sc.next();
			
			System.out.print("금액>");
			int moviePrice = sc.nextInt();
			sc.nextLine();
			
			System.out.print("나이>");
			int age = sc.nextInt();
			sc.nextLine();
			
			System.out.print("구매방법>");
			String type = sc.nextLine();

			m[i].setMovieName(movieName);
			m[i].setMoviePrice(moviePrice);
			m[i].setAge(age);
			m[i].setType(type);

			m[i].priceCalc();

		}
//		System.out.println("영화명\t금액\t나이\t실구매금액");
		System.out.printf("%10s %10s %10s %10s", "영화명", "금액", "나이", "실구매금액");
		System.out.println();
		for (int i = 0; i < m.length; i++) {
			
			System.out.printf("%10s %10d %10d %10d", m[i].getMovieName(), m[i].getMoviePrice(), m[i].getAge(), m[i].getPrice());
			System.out.println();
		}
	}

}

class Movie {
	String movieName; // 영화이름
	int age; // 나이
	int price; // 실제구매액
	int moviePrice; // 티켓가격
	String type; // 구매방법

	double rate; // 할인율

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	// 실제 구매액 계산 메소드
	public int priceCalc() {
		if (age < 20) {
			rate = 0.25;
		} else if (age >= 20 && age < 30) {
			rate = 0.2;
		} else {
			rate = 0.15;
		}

		if (type.equals("인터넷")) {
			rate = rate + 0.05;
		} else if (type.equals("쿠폰")) {
			rate = rate + 0.01;
		}

		price =(int)((1 - rate) * moviePrice);
		return price;
	}

	public int getMoviePrice() {
		return moviePrice;
	}

	public void setMoviePrice(int moviePrice) {
		this.moviePrice = moviePrice;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}