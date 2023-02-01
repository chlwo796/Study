package b1331p2;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Grade[] grades = new Grade[3];
		grades[0]=new Element();
		grades[1]=new Middle();
		grades[2]=new High(); 

		Scanner sc = new Scanner(System.in);
		boolean isClosed = false;
		while (!isClosed) {
			System.out.println("---------------");
			System.out.println("성적 관리 프로그램");
			System.out.println("---------------");
			System.out.println("1.입력 2.출력 3.종료");
			System.out.println("---------------");
			System.out.print("메뉴선택>");
			String menu = sc.nextLine();
			String input;
			switch (menu) {
			case "1":
				do {
					System.out.println("---------------");
					System.out.println("1.초등학생 2.중학생 3.고등학생");
					System.out.println("---------------");
					System.out.print("메뉴선택>");
					int menuNumber = Integer.parseInt(sc.nextLine());
					grades[menuNumber-1].addGrade();
					System.out.println("추가 입력하시겠습니까?(y/n)");
					input = sc.nextLine();
					if (input.equals("n"))
						break;
				} while (input.equals("y"));
				
				break;
			case "2":
				for(Grade list : grades) {
					list.printAll();
				}
				break;
			case "3":
				System.out.println("프로그램 종료");
				isClosed = true;
				break;
			default:
				System.out.println("잘못입력하셨습니다. 다시 입력하세요.");
			}

		}
		System.out.println("과목명");
		String input1 = sc.nextLine();

	}

}
