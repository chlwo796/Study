package b1331p1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Company[] companies = new Company[4];
		companies[0] = new Seoul();
		companies[1] = new Kyoungin();
		companies[2] = new Kangwon();
		companies[3] = new Jeju();

		Scanner sc = new Scanner(System.in);
		boolean isClosed = false;
		while (!isClosed) {
			System.out.println("----------");
			System.out.println("판매량관리 프로젝트");
			System.out.println("----------");
			System.out.println("1.입력 2.출력 3.종료");
			System.out.print("메뉴선택>");
			String menu = sc.nextLine();
			switch (menu) {
			case "1":
				do {
					System.out.println("----------");
					System.out.println("1.서울 2.경인 3.강원 4.제주");
					System.out.println("----------");
					System.out.print("지사선택>");
					int menuNumber = Integer.parseInt(sc.nextLine());
					companies[menuNumber-1].addlist();
					System.out.println("추가입력하시겠습니까?");
					menu = sc.nextLine();
					if (menu.equals("n"))
						break;
				} while (menu.equals("y"));

				break;
			case "2":
				System.out.println("----------");
				System.out.println("각 지사별 판매 현황");
				System.out.println("----------");
				System.out.println("지사명  제품명  제품가격  판매량  매출현황");
				for(Company company : companies)
					company.printAll();
				break;
			case "3":
				System.out.println("시스템을 종료합니다.");
				isClosed = true;
				break;
			default:
				System.out.println("잘못입력하셨습니다. 다시입력하세요.");
			}
		}

	}

}
