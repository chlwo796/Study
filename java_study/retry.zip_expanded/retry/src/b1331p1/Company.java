package b1331p1;

import java.util.Scanner;

public class Company {
	static final int computerPrice = 2000000;
	static final int printerPrice = 500000;
	String area;
	String productName;
	int productCnt;
	int productPrice;
	int total;
	Scanner sc = new Scanner(System.in);
	
	public Company(String area) {
		this.area=area;
	}
	public void addlist() {
		System.out.print("제품입력>");
		productName = sc.nextLine();
		
		System.out.print("판매량>");
		productCnt = Integer.parseInt(sc.nextLine());
		
		if(productName.equals("컴퓨터")) {
			productPrice = computerPrice;
		} 
		if(productName.equals("프린터")) {
			productPrice = printerPrice; 
		}
		total = productPrice * productCnt;
		 
	}
	
	public void printAll() {
		System.out.println(area+"지사 "+productName+" "+productPrice+" "+productCnt+" "+total);
	}
}
