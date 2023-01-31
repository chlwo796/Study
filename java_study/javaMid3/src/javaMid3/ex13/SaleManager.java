package javaMid3.ex13;

import java.util.Scanner;

public class SaleManager {
	Scanner sc = new Scanner(System.in);
	Data data = new Data();
	Data[] dataArray = new Data[100];
	int i = 0;

// 	차근차근...String choice 에 따라 객체생성을 따로 해야한다
	void input() {
		while (true) {
			System.out.println("1. 서울지사, 2. 경인지사, 3. 강원지사 4. 제주지사");
			System.out.println("선택?");
			String choice = sc.nextLine();
			switch (choice) {
			case "1": // 강원도 객체생성 한 후 별도의 인풋메소드 실행
				data = new Seoul();
				break;
			case "2":
				data = new Gyeongin();
				break;
			case "3":
				data = new Gangwon();
				break;
			case "4":
				data = new Jeju();
				break;
			default:
			}
			System.out.println("제품은?");
			data.product = sc.nextLine();

			System.out.println("판매량은?");
			data.count = sc.nextInt();
			sc.nextLine();
			System.out.println("계속 입력하시겠습니까?(y/n)");
			String yn = sc.nextLine();

			data.Price(data.product);
			data.Calculator();
			dataArray[i++] = data;

			if (yn.equals("y")) {
				continue;

			} else
				break;
		}

	}

	void output() {
//		계산값 받아와서 출력만 한다. 배열사용?
//		data.sale;

		System.out.println("-----------------");
		System.out.println("각 지사별 판매 현황");
		System.out.println("-----------------");
		System.out.println("지사명   제품명  제품가격  판매량  매출현황");
		System.out.println("-----------------");
		for (int i = 0; i < dataArray.length; i++) {
			if (dataArray[i] == null) {
				break;
			}
			System.out.println(dataArray[i].company + " " + dataArray[i].product + " " + dataArray[i].price + " "
					+ dataArray[i].count + " " + +dataArray[i].sale);
		}

	}
}
