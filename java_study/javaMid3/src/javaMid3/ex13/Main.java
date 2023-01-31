package javaMid3.ex13;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
//		Scanner로 입력받기, input 클래스로 setter.
		Scanner sc = new Scanner(System.in);
		SaleManager sm = new SaleManager();
		System.out.println("-----------------");
		System.out.println("판매량관리 프로젝트");
		System.out.println("-----------------");
		boolean run = true;
		while (run) {
			System.out.println("1. 입력  2. 출력 3. 종료");
			String choice = sc.nextLine();
			switch (choice) {
			case "1":
				sm.input();
				break;
			case "2":
				sm.output();
				break;
			case "3":
				run = false;
				break;
			default:
				continue;
			}
			if (run) {
				continue;
			} else
				break;
		}
	}

}
