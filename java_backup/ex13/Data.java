package javaMid3.ex13;

public class Data {
// 데이터클래스 부모클래스. 강원,경인,제주,서울 -> Data 클래스를 부모로 한다.
	private final static int PRICE_COMPUTER = 2000000; // 컴퓨터 가격은 2000000, 프린터 가격은 500000 고정
	private final static int PRICE_PRINTER = 500000; // 상수로 나중에 빼보자. 가격은 함부로 수정 ㄴㄴ

	String product; // 컴퓨터,프린터...들어옴
	String company; // 1,2,3,4 값이 들어옴
	int price;
	int count;
	int sale; // 판매실적

	// String company를 받는 메소드를 실행하는데 자식걸 실행ㅎㄴ다?아니지 생성자로 해보자.

//	매출 현황을 계산해주는 메소드를 만든다. 이후 자식클래스들이 오버라이딩
	public Data() {
		// TODO Auto-generated constructor stub
	}

//	생성자로 자식의 생성자를 먼저 실행한다.
//	메소드방식은 자식메소드를 호출해서 부모의 메소드를 사용하는 방식이다. 자식클래스마다 계산법이 다르지는 않으므로 생성자로 간단하게 해보았다.
	public Data(String company) {
		this.company = company;
	}

	void Price(String product) {
		if (product.equals("컴퓨터")) {
			this.price = PRICE_COMPUTER;
		} else
			this.price = PRICE_PRINTER;

	}

	void Calculator() {
		this.sale = price * count;
	}

}
