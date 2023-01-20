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
		System.out.println("���� �� �ȸ� ��ǰ�� " + bestItem);
		System.out.println("���� �� �ȸ� ��ǰ�� " + worstItem);
	}

	static void Datainput(Sidedish sd) {
		Scanner sc = new Scanner(System.in);

		System.out.println("�������� ���α׷�");
		System.out.println("-------------");
		System.out.println("ǰ��> ");
		sd.proID = sc.nextLine();
		System.out.println("���� ����> ");
		sd.proCnt = sc.nextInt();
		System.out.println("�ȸ� ����> ");
		sd.sale = sc.nextInt();
	}

	static void Dataoutput(Sidedish sd, Sidedish sd1, Sidedish sd2){
		System.out.println("---���� �������� ���� ��Ȳ---");
		System.out.println("����  ���簹��  �ǸŰ���  �Ǹ���");
		System.out.println(sd.proID + " " + sd.proCnt + " " + sd.sale + " " + sd.salePercent);
		System.out.println(sd1.proID + " " + sd1.proCnt + " " + sd1.sale + " " + sd1.salePercent);
		System.out.println(sd2.proID + " " + sd2.proCnt + " " + sd2.sale + " " + sd2.salePercent);
	}

}

class Sidedish {
	String proID; // ǰ��
	int proCnt; // ���� ����
	int sale; // �Ǹ� ����
	double salePercent; // �Ǹ���
	
//	���� ���� ���ϱ�

	double saleMethod(int sale, int proCnt) {
		salePercent = (double) sale / (double) proCnt * 100.0;	
		// 100.0���� �������� ���� = ����Ÿ���� �Ҽ����� �ſ� ��⶧���� 100.0���� �������ָ� ù��° �ڸ��� ��µȴ�.
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
