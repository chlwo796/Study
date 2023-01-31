package javaMid3.ex13;

import java.util.Scanner;

public class SaleManager {
	Scanner sc = new Scanner(System.in);
	Data data;
	String company;
	String product;
	int sale;
	Data[] dataArray = new Data[10];

	public SaleManager() {
//		1이면 서울지사주소를 참조해야하고, 2면 경인지사 주소를 참조해야한다.
//		그것들은 부모인 Data를 객체화 하고, 오버라이딩 하면 모두 가져올 수 있다.
	}

	void input(Data data) {
		System.out.println("-----------------");
		System.out.println("판매량관리 프로젝트");
		System.out.println("-----------------");
		while (true) {
			System.out.println("1. 입력  2. 출력 3. 종료");
			String choice = sc.nextLine();
			switch (choice) {
			case "1": {
				while (true) {
					System.out.println("1. 서울지사, 2. 경인지사, 3. 강원지사 4. 제주지사");
					System.out.println("선택?");
					data.company = sc.nextLine();
					System.out.println("제품은?");
					data.product = sc.nextLine();
					System.out.println(company + product + "판매량은?");
					data.sale = sc.nextInt();
					sc.nextLine();
					System.out.println("계속 입력하시겠습니까?(y/n)");
					String yn = sc.nextLine();
					if (yn.equals("y")) {
						continue;

					} else
						break;
				}
			}
			case "2":
				break;
			case "3":
				break;
			default:
				break;
			}
		}

	}

	void output(Data data) {
//		계산값 받아와서 출력만 한다. 배열사용?
//		data.sale;

		System.out.println("-----------------");
		System.out.println("각 지사별 판매 현황");
		System.out.println("-----------------");
		System.out.println("지사명   제품명  제품가격  판매량  매출현황");
		System.out.println("-----------------");
		for (int i = 0; i < dataArray.length; i++) {
			if (dataArray[i] == null) {
				System.out.println(dataArray[i]);
				break;
			}
			System.out.println(dataArray[i].company + " " + dataArray[i].product + " " + dataArray[i].price + " "
					+ dataArray[i].sale);
		}

	}
}
