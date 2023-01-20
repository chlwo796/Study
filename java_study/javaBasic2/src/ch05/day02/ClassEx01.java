package ch05.day02;

import java.util.Scanner;

public class ClassEx01 {

	public static void main(String[] args) {
//		class 실습
//		1. 클래스 필드의 직접 값을 넣어준다.
		Product product = new Product();
//		Product라는 이름으로 heap memory에 주소를 생성하면 
//		product라는 변수는 생성된 heap memory의 Product 주소를 자료형으로 한다.
//		입력 메소드 호출
		inputMethod(product);

//		새로운 객체를 생성하여 method 반복 실행 가능
		Product product1 = new Product();
		inputMethod(product1);

		Product product2 = new Product();
		inputMethod(product2);

//		판매금액 구하기
		int salePrice = product.salePriceMethod(product.proPrice, product.proCnt);

		String attainMent = product.attainMentMethod(salePrice);

		System.out.println("출력하기");
		System.out.println("상품코드 상품명 가격 갯수 판매금액 달성");
		System.out.println(product.proId + " " + product.proName + " " + product.proPrice + " " + product.proCnt + " "
				+ salePrice + " " + attainMent);
	}

//	입력 담당 메소드 만들기
	static void inputMethod(Product product) {
		System.out.println("-----------");
		System.out.println("선물세트 판매");
		System.out.println("----------");
		System.out.println();

		System.out.println("입력화면");
//		입력 언제까지? 3개 받기

		Scanner sc = new Scanner(System.in);
		System.out.println();
		System.out.print("상품코드> ");
//			입력받은 값을 Product class의 proId변수에 넣고싶다.
		product.proId = sc.next();
		System.out.print("상품명> ");
		product.proName = sc.next();
		System.out.print("가격> ");
		product.proPrice = sc.nextInt();
		System.out.print("개수> ");
		product.proCnt = sc.nextInt();
		sc.nextLine();

	}
}

class Product {
	String proId;
	String proName;
	int proPrice;
	int proCnt;

//	(returnType) (method)
	int salePriceMethod(int proPrice, int proCnt) {
		int salePrice = proPrice * proCnt;
		return salePrice;

//			return proPrice * proCnt; // 임시
	}

//	판매금액 구하기
	String attainMentMethod(int salePrice) {
		if (salePrice >= 100000) {
			return "잘함";
		} else {
			return "노력";
		}
	}
}
