package ch05.day05;

import java.util.Scanner;

public class ArrayEx04Class {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		1�� �Է� - �Ǳ��űݾ� ���, 2�� �Է� - �� ���űݾ� ���/ 3�� �Է� - �� ���űݾ� ��� ->�ݺ���Ȱ��
//		1��, 2��, 3�� �ݺ� ����Ѵ�.
//		Movie[] m = {new Movie(), new Movie(), new Movie()};

		Movie[] m = new Movie[3];
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < m.length; i++) {
			m[i] = new Movie();
			System.out.println((i + 1) + "��° ���ڵ�(��)");
			System.out.print("��ȭ��>");
			String movieName = sc.next();
			
			System.out.print("�ݾ�>");
			int moviePrice = sc.nextInt();
			sc.nextLine();
			
			System.out.print("����>");
			int age = sc.nextInt();
			sc.nextLine();
			
			System.out.print("���Ź��>");
			String type = sc.nextLine();

			m[i].setMovieName(movieName);
			m[i].setMoviePrice(moviePrice);
			m[i].setAge(age);
			m[i].setType(type);

			m[i].priceCalc();

		}
//		System.out.println("��ȭ��\t�ݾ�\t����\t�Ǳ��űݾ�");
		System.out.printf("%10s %10s %10s %10s", "��ȭ��", "�ݾ�", "����", "�Ǳ��űݾ�");
		System.out.println();
		for (int i = 0; i < m.length; i++) {
			
			System.out.printf("%10s %10d %10d %10d", m[i].getMovieName(), m[i].getMoviePrice(), m[i].getAge(), m[i].getPrice());
			System.out.println();
		}
	}

}

class Movie {
	String movieName; // ��ȭ�̸�
	int age; // ����
	int price; // �������ž�
	int moviePrice; // Ƽ�ϰ���
	String type; // ���Ź��

	double rate; // ������

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

	// ���� ���ž� ��� �޼ҵ�
	public int priceCalc() {
		if (age < 20) {
			rate = 0.25;
		} else if (age >= 20 && age < 30) {
			rate = 0.2;
		} else {
			rate = 0.15;
		}

		if (type.equals("���ͳ�")) {
			rate = rate + 0.05;
		} else if (type.equals("����")) {
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