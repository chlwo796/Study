package team02.project01;

import java.util.Scanner;


public class LibraryManagementProgram {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
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
				lb.rentalBook();
				break;
			case "3":
				lb.returnBook();
				break;
			case "4":
				lb.bookSearch();
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
}

class Library {
	int count;
	String[][] bookList;
	String[][] newArray;
	boolean containbookName;
	Scanner sc = new Scanner(System.in);

	String[][] firstTime() {
		System.out.println("입력할 개수를 입력하세요. 이곳은 도서관의 책목록을 만드는 곳입니다.(초기값)");
		count = sc.nextInt();
		sc.nextLine();
		bookList = new String[count][2];
		for (int i = 0; i < bookList.length; i++) {
			System.out.print((i + 1) + "번째 책>");
			bookList[i][0] = sc.nextLine();
			bookList[i][1] = "Y";
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
				newArray[i][0] = sc.nextLine();
				newArray[i][1] = "Y";
			}
			System.arraycopy(bookList, 0, newArray, 0, bookList.length);

			return bookList = newArray;
		} else
			return bookList;
	}

	String[][] rentalBook() {

		System.out.println("대여할 책 이름 > ");
		String bookName = sc.nextLine();

		for (int i = 0; i < bookList.length; i++) {
			if (bookName.equals(bookList[i][0]) && bookList[i][1].equals("Y")) {
				bookList[i][1] = "N";
				System.out.println(bookName + " 대여되었습니다.");
				containbookName = false;
				break;
			} else
				containbookName = true;

		}
		if (containbookName) {
			System.out.println(bookName + "은(는) 대여가 불가능한 책입니다. 대출여부 및 리스트를 확인해주세요.");
			containbookName = false;
		}
		return bookList;
	}

	String[][] returnBook() {

		System.out.println("반납할 책 이름 > ");
		String bookName = sc.nextLine();

		for (int i = 0; i < bookList.length; i++) {
			if (bookName.equals(bookList[i][0]) && bookList[i][1].equals("N")) {
				bookList[i][1] = "Y";
				System.out.println(bookName + " 반납되었습니다.");
				containbookName = false;
				break;
			} else {
				containbookName = true;
			}
		}
		if (containbookName) {
			System.out.println(bookName + "은(는) 반납이 불가능한 책입니다. 대출여부 및 리스트를 확인해주세요.");
			containbookName = false;
		}
		return bookList;
	}

	void bookSearch() {

		System.out.println("책 제목을 입력해주세요");
		String bs = sc.nextLine();

		for (int i = 0; i < bookList.length; i++) {
			if (bookList[i][0].contains(bs)) {

			}
			System.out.println("도서이름\t대출가능여부");
			System.out.println(bookList[i][0] + "\t" + bookList[i][1]);
		}

	}

	void bookStatus() {
		System.out.println("도서이름\t대출가능여부");
		for (int i = 0; i < bookList.length; i++) {
			System.out.print(bookList[i][0] + "\t" + bookList[i][1]);
			System.out.println();
		}

	}

}
