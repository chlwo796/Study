package student.Management;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		boolean run = true;
		Scanner sc = new Scanner(System.in);
		while (run) {
			System.out.println("---------------------------------------");
			System.out.printf("%-8s%-8s%-8s%-8s%-8s\n", "1. 학생관리", "2. 강의관리", "3. 성적관리", "4. 출결관리", "5. 종료");
			System.out.println("---------------------------------------");
			System.out.println("메뉴선택>");
			String choice = sc.nextLine();
			switch (choice) {
			case "1": {
				System.out.println("학생관리 메뉴를 선택했습니다.");
				StudentManager.main(args);
				break;
			}
			case "2": {
				System.out.println("강의관리 메뉴를 선택했습니다.");
				System.out.println("강의관리");
				break;
			}
			case "3": {
				System.out.println("성적관리 메뉴를 선택했습니다.");
				new Score();
				break;
			}
			case "4": {
				System.out.println("출결관리 메뉴를 선택했습니다.");
				break;
			}
			case "5": {
				System.out.println("프로그램 종료!");
				run = false;
				break;
			}

			default: {
				System.out.println("잘못입력하셨습니다.");
				continue;
			}
			}
		}
	}
}
