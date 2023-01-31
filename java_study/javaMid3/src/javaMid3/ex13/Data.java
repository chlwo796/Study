package javaMid3.ex13;

public class Data {
// 데이터클래스 부모클래스. 강원,경인,제주,서울 -> Data 클래스를 부모로 한다.
	String product;
	String company;
	int price;
	int priceC = 2000000; // 컴퓨터 가격은 2000000, 프린터 가격은 500000 고정
	int priceP = 500000;
	int count;
	int sale; // 판매가격
//	String company를 받는 메소드를 실행하는데 자식걸 실행ㅎㄴ다?아니지 생성자로 해보자.
	
//	매출 현황을 계산해주는 메소드를 만든다. 이후 자식클래스들이 오버라이딩
	public Data() {
		// TODO Auto-generated constructor stub
	}

	public Data(String company) {
		System.out.println("잘못된회사번호");
	}

	void calculator() {
		if (product.equals("컴퓨터")) {
			this.sale = priceC * count;
		} else
			this.sale = priceP * count;
	}

}
