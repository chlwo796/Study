package javaMid7.ex06;

import java.util.Scanner;

public class Calculator {

	private Data data = new Data();

	public Calculator() {
		Scanner sc = new Scanner(System.in);
		System.out.print("가로 : ");
		data.setA(sc.nextInt());
		System.out.print("세로 : ");
		data.setB(sc.nextInt());
		System.out.print("높이 : ");
		data.setC(sc.nextInt());
	}

	void input() {

	}

	private Data data1 = new Data() {
		@Override
		public void cal() {

			System.out.println("가로 : " + data.getA() + ", 세로 : " + data.getB());
		}
	};

	private Data data2 = new Data() {
		@Override
		public void cal() {

			System.out.println("넓이 : " + (data.getA() * data.getB()));
		}
	};

	private Data data3 = new Data() {
		@Override
		public void cal() {

			System.out.println("부피 : " + (data.getA() * data.getB() * data.getC()));
		}
	};

	private Data data4 = new Data() {
		@Override
		public void cal() {
			System.out.println("겉넓이 : "
					+ (2 * ((data.getA() * data.getB()) + (data.getB() * data.getC()) + (data.getC() * data.getA()))));
		}
	};

	public void run() {
		data1.cal();
		data2.cal();
		data3.cal();
		data4.cal();
	}
}