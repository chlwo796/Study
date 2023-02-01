package javaMid3.ex13.again;

import java.util.Scanner;

public class SaleMain {

	public static void main(String[] args) {
//		ex13.수업 때 풀어본것
		Scanner sc = new Scanner(System.in);
		int menuSelect = 0;
		SaleBusiness sa = new SaleBusiness();
		while (menuSelect != 3) { // 입력받는 정수가 3일때만 while 종료하겠다.
			System.out.println("-------------------------");
			System.out.println("1. 입력 | 2. 출력 | 3. 종료");
			System.out.println("-------------------------");
			System.out.println("선택>");
			menuSelect = sc.nextInt();

			switch (menuSelect) {
			case 1:
				sa.input(); // 미리 이름만 작성 후 마우스 올려서 자동으로 만들기 가능하다.
				break;
			case 2:
				sa.output();
				break;
			case 3:
				break;
			}
		}
	}
}
