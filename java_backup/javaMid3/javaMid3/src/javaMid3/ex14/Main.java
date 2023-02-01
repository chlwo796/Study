package javaMid3.ex14;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String choice;
		boolean run = true;
		Scanner sc = new Scanner(System.in);
		ScoreManager sm = new ScoreManager();
		System.out.println("-------------");
		System.out.println("성적관리프로그램");
		System.out.println("-------------");
		while (run) {
			System.out.println("1. 입력 | 2. 출력 | 3. 종료");
			System.out.println("선택>");
			choice = sc.nextLine();
			switch (choice) {
			case "1": sm.input();
				break;
			case "2": sm.output();
				break;
			case "3": run = false;
				break;
			default:
				continue;
			}if(run == false) {
				break;
			}else continue;

		}
	}
}
