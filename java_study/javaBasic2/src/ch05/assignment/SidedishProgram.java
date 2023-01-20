package ch05.assignment;

import java.util.Scanner;

public class SidedishProgram {

	public static void main(String[] args) {
//		Sidedish Program
		Sidedish sd = new Sidedish();

		Datainput(sd);

		Sidedish sd1 = new Sidedish();

		Datainput(sd1);

		Sidedish sd2 = new Sidedish();

		Datainput(sd2);

		double proSale = sd.saleMethod(sd.sale, sd.proCnt);
		double proSale1 = sd1.saleMethod(sd1.sale, sd1.proCnt);
		double proSale2 = sd2.saleMethod(sd2.sale, sd2.proCnt);
		
		Dataoutput(sd, sd1, sd2);
		
		Calculator cal = new Calculator();

		double maxValue = cal.maxMethod(proSale, proSale1, proSale2);

		String bestItem = null;
		String worstItem = null;

		if (maxValue == proSale) {
			bestItem = sd.proID;
		} else if (maxValue == proSale1) {
			bestItem = sd1.proID;
		} else {
			bestItem = sd2.proID;
		}

		double minValue = cal.minMethod(proSale, proSale1, proSale2);

		if (minValue == proSale) {
			worstItem = sd.proID;
		} else if (minValue == proSale1) {
			worstItem = sd1.proID;
		} else {
			worstItem = sd2.proID;
		}
		System.out.println("가장 잘 팔린 제품은 " + bestItem);
		System.out.println("가장 안 팔린 제품은 " + worstItem);
	}

	static void Datainput(Sidedish sd) {
		Scanner sc = new Scanner(System.in);

		System.out.println("반찬가게 프로그램");
		System.out.println("-------------");
		System.out.println("품목> ");
		sd.proID = sc.nextLine();
		System.out.println("만든 개수> ");
		sd.proCnt = sc.nextInt();
		System.out.println("팔린 개수> ");
		sd.sale = sc.nextInt();
	}

	static void Dataoutput(Sidedish sd, Sidedish sd1, Sidedish sd2){
		System.out.println("---이젠 반찬가게 매출 현황---");
		System.out.println("종류  만든갯수  판매갯수  판매율");
		System.out.println(sd.proID + " " + sd.proCnt + " " + sd.sale + " " + sd.salePercent);
		System.out.println(sd1.proID + " " + sd1.proCnt + " " + sd1.sale + " " + sd1.salePercent);
		System.out.println(sd2.proID + " " + sd2.proCnt + " " + sd2.sale + " " + sd2.salePercent);
	}

}

class Sidedish {
	String proID; // 품목
	int proCnt; // 만든 개수
	int sale; // 판매 개수
	double salePercent; // 판매율
	
//	남은 개수 구하기

	double saleMethod(int sale, int proCnt) {
		salePercent = (double) sale / (double) proCnt * 100.0;	
		// 100.0으로 나누어준 이유 = 더블타입은 소수점이 매우 길기때문에 100.0으로 나누어주면 첫번째 자리만 출력된다.
		return salePercent;
	}

}

class Calculator {
	double maxSale;
	double minSale;

	double maxMethod(double proSale, double proSale1, double proSale2) {
		maxSale = ((proSale >= proSale1) && (proSale >= proSale2)) ? proSale
				: ((proSale1 >= proSale) && (proSale1 >= proSale2)) ? proSale1 : proSale2;
		return maxSale;
	}

	double minMethod(double proSale, double proSale1, double proSale2) {
		minSale = ((proSale <= proSale1) && (proSale <= proSale2)) ? proSale
				: ((proSale1 <= proSale) && (proSale1 <= proSale2)) ? proSale1 : proSale2;
		return minSale;
	}
}
