package javaMid3.ex12;

public class Buyer {
	int money = 1000;
	int bonusPoint = 0;
	int i = 0;
	Product[] item = new Product[10];

	void buy(Product p) {
		if (money < p.price) {
			System.out.println("잔액부족");
			return;
		}
//		return 후(if문 실행이 아닐경우) 아래 실행.(else와 같은 느낌)
		money -= p.price;
		bonusPoint += p.bonusPoint;
		item[i++] = p; // 주소를 대입한다!! 이후 i 값을 하나 올린다.
//		외부에서 값을 받아오는 것이 아니기 때문에 this.i = i;가 필요가 없다. 
		System.out.println("구입완료");

	}

	void summary() {
		int sum = 0;
	
		String itemList = "";

		for (int i = 0; i < item.length; i++) {
			if (item[i] == null) {
				System.out.println(item[i]);
				break;
			}
			sum = sum + item[i].price;
			itemList = itemList + item[i] + ", ";
		}
		System.out.println("구입하신 총 금액은 " + sum + "만원입니다.");
		System.out.println("제품은 " + itemList + "입니다.");
	}
}
