package team02.project01;

import java.util.Scanner;

public class LibraryManagementProgram {

	static Scanner sc = new Scanner(System.in);
	static int count;
	static String[][] bookList;

	public static void main(String[] args) {
		
		Library lb = new Library();

		boolean flage = true;
		
		while (flage) {
			System.out.println("------------------------------------------------------");
			System.out.println("1.도서입력\t2.도서대출\t3.도서반납\t4.도서검색\t5.도서현황\t6.종료");
			System.out.println("-------------------------------------------------------");
			System.out.print("선택>");
			String menu = sc.nextLine();

			switch (menu) {

			case "1":
				lb.input();
				break;

			case "2":

				break;
			case "3":

				break;
			case "4":

				break;
			case "5":
				lb.bookStatus();
				break;
			case "6":
				System.out.println("도서 관리 프로그램 종료");
				flage = false;
				break;
			default:
				System.out.println("잘못입력하셨습니다.(1~6)");
			}
		}
	}

//	private static void bookStatus() {
//		// TODO Auto-generated method stub
//
//		System.out.println("도서이름\t대출가능");
//		for (int i = 0; i < bookList.length; i++) {
//			System.out.print(bookList[i][0] + "\t" + bookList[i][1]);
//			System.out.println();
//		}
//	}

//	private static void insertBook(boolean x) {
//		if (x) {
//			System.out.println("입력할 개수를 입력하세요. 이곳은 도서관의 책목록을 만드는 곳입니다.(초기값)");
//			count = sc.nextInt();
//			sc.nextLine();
//			bookList = new String[count][2];
//			for (int i = 0; i < bookList.length; i++) {
//				System.out.print((i + 1) + "번째 책>");
//				bookList[i][0] = sc.nextLine();
//			}
//			x = false;
//		}
//		System.out.println("추가입력>");
//		count = sc.nextInt();
//		sc.nextLine();
//		String[][] newArray = new String[count + bookList.length][2];
//		for (int i = bookList.length; i < newArray.length; i++) {
//			System.out.print("추가할 " + (i - bookList.length + 1) + "번째 책>");
//			newArray[i][0] = sc.nextLine(); // 여기서 기존 길이의 배열에 추가할 책 수만큼의 길이의 배열을 만들었다. newArray배열에 값 복사 후
//		}
//		System.arraycopy(bookList, 0, newArray, 0, bookList.length);
//	}
}

class Library {
	int count;
	String[][] bookList;
	String[][] newArray;
	Scanner sc = new Scanner(System.in);

	String[][] firstTime() {
		System.out.println("입력할 개수를 입력하세요. 이곳은 도서관의 책목록을 만드는 곳입니다.(초기값)");
		count = sc.nextInt();
		sc.nextLine();
		bookList = new String[count][2];
		for (int i = 0; i < bookList.length; i++) {
			System.out.print((i + 1) + "번째 책>");
			bookList[i][0] = sc.nextLine();
			bookList[i][1] = "대출가능";
		}
		return bookList;
	}

	String[][] input() {

		System.out.println("최초입력입니까?(y/n)");
		String answer = sc.nextLine();
		if (answer.equals("y")) {
			firstTime();
			}
		System.out.println("추가입력하시겠습니까?(y/n)");
		String yesNo = sc.nextLine();
		if (yesNo.equals("y")) {
			System.out.println("추가입력수>");
			count = sc.nextInt();
			sc.nextLine();
			String[][] newArray = new String[count + bookList.length][2];
			for (int i = bookList.length; i < newArray.length; i++) {
				System.out.print("추가할 " + (i - bookList.length + 1) + "번째 책>");
				newArray[i][0] = sc.nextLine(); // 여기서 기존 길이의 배열에 추가할 책 수만큼의 길이의 배열을 만들었다. newArray배열에 값 복사 후
				newArray[i][1] = "대출가능";
			}
			System.arraycopy(bookList, 0, newArray, 0, bookList.length);

			return bookList = newArray;
		} else
			return bookList;
	}

	void bookStatus() {
		System.out.println("도서이름\t대출가능");
		for (int i = 0; i < bookList.length; i++) {
			System.out.print(bookList[i][0] + "\t" + bookList[i][1]);
			System.out.println();
		}

	}
}