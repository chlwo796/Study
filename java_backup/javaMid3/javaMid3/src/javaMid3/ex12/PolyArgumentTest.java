package javaMid3.ex12;

public class PolyArgumentTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Buyer b = new Buyer();
		
		b.buy(new Tv());	//�ּ� ������ ���ÿ� ���� ����
		b.buy(new Computer());
		b.buy(new Audio());
		b.summary();
		
		b.buy(new Cellphone());
		b.buy(new Ipad());
		b.summary();
	}

}
