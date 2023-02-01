package javaMid3.ex12;

public class PolyArgumentTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Buyer b = new Buyer();
		
		b.buy(new Tv());	//주소 생성과 동시에 대입 가능
		b.buy(new Computer());
		b.buy(new Audio());
		b.summary();
		
		b.buy(new Cellphone());
		b.buy(new Ipad());
		b.summary();
	}

}
