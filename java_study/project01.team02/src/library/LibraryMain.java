package library;

import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LibraryMain {

	public static void main(String[] args) {

		boolean flage = true;
		boolean run = true;
		Scanner sc = new Scanner(System.in);
		SignIn si = new SignIn();

		System.out.println("도서관프로그램입니다.");
		while (run) {
			System.out.println("1. 회원가입 | 2. 로그인 | 3. 종료");
			System.out.println("선택>");
			String choice = sc.nextLine();

			if (choice.equals("1")) {
				System.out.println("회원가입");
				System.out.println("Id>");
				si.setId(sc.nextLine());
				System.out.println("Password>");
				si.setPw(sc.nextLine());
				System.out.println("회원가입성공");
				continue;
			} else if (choice.equals("2")) {
				if (si.getId() == null) {
					System.out.println("회원정보가 없습니다. 회원가입 해주세요.");
					continue;
				}
				System.out.println("아이디와 패스워드를 입력해주세요.");
				System.out.println("아이디>");
				si.setInputId(sc.nextLine());
				System.out.println("패스워드>");
				si.setInputPw(sc.nextLine());

				if (si.getId().equals(si.getId()) && si.getPw().equals(si.getInputPw())) {
					System.out.println("로그인성공");
					break;
				} else
					System.out.println("다시입력해주세요");
				continue;

			} else if (choice.equals("3")) {
				flage = false;
				System.out.println("종료합니다.");
				break;
			} else
				System.out.println("잘못누르셨습니다.");
			continue;
		}

		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		Date time = new Date();

		String time1 = format1.format(time);

		Library lb = new Library();

		while (flage) {
			System.out.println(time1);
			System.out.println("--------------------------------------------------------");
			System.out.println("1.도서입력 | 2.도서대출 | 3.도서반납 | 4.도서검색 | 5.도서현황 | 6.종료");
			System.out.println("--------------------------------------------------------");
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

	boolean containbookName;
	Scanner sc = new Scanner(System.in);

	String[][] firstTime() {

		System.out.println("도서가 몇권입니까?");
		count = sc.nextInt();
		sc.nextLine();
		bookList = new String[count][5];
		for (int i = 0; i < bookList.length; i++) {
			System.out.print((i + 1) + "번째 도서 제목>");
			bookList[i][0] = sc.nextLine();
			System.out.print((i + 1) + "번째 도서 코드>");
			bookList[i][1] = sc.nextLine();
			System.out.print((i + 1) + "번째 도서 카테고리>");
			bookList[i][2] = sc.nextLine();
			System.out.print((i + 1) + "번째 도서 작가>");
			bookList[i][3] = sc.nextLine();
			bookList[i][4] = "Y";
		}
		return bookList;
	}

	String[][] input() {
		if (bookList == null) {
			firstTime();
		} else {
			System.out.println("도서가 몇권입니까?");
			count = sc.nextInt();
			sc.nextLine();
			String[][] newArray = new String[count + bookList.length][5];
			for (int i = bookList.length; i < newArray.length; i++) {
				System.out.print("추가할 " + (i - bookList.length + 1) + "번째 도서 제목>");
				newArray[i][0] = sc.nextLine();
				System.out.print("추가할 " + (i - bookList.length + 1) + "번째 도서 코드>");
				newArray[i][1] = sc.nextLine();
				System.out.print("추가할 " + (i - bookList.length + 1) + "번째 도서 카테고리>");
				newArray[i][2] = sc.nextLine();
				System.out.print("추가할 " + (i - bookList.length + 1) + "번째 도서 작가>");
				newArray[i][3] = sc.nextLine();
				newArray[i][4] = "Y";

			}
			System.arraycopy(bookList, 0, newArray, 0, bookList.length);

			return bookList = newArray;
		}
		return null;
	}

	String[][] rentalBook() {

		System.out.println("대여할 책 이름 > ");
		String bookName = sc.nextLine();

		for (int i = 0; i < bookList.length; i++) {
			if (bookName.equals(bookList[i][0]) && bookList[i][4].equals("Y")) {
				bookList[i][4] = "N";
				System.out.println(bookName + " 대여되었습니다.");
				containbookName = false;
				break;
			} else
				containbookName = true;

		}
		if (containbookName) {
			System.out.println(bookName + "은(는) 대여가 불가능한 도서입니다. 대출여부 및 리스트를 확인해주세요.");
			containbookName = false;
		}
		return bookList;
	}

	String[][] returnBook() {

		System.out.println("반납할 도서 이름 > ");
		String bookName = sc.nextLine();

		for (int i = 0; i < bookList.length; i++) {
			if (bookName.equals(bookList[i][0]) && bookList[i][4].equals("N")) {
				bookList[i][4] = "Y";
				System.out.println(bookName + " 반납되었습니다.");
				containbookName = false;
				break;
			} else {
				containbookName = true;
			}
		}
		if (containbookName) {
			System.out.println(bookName + "은(는) 반납이 불가능한 도서입니다. 대출여부 및 리스트를 확인해주세요.");
			containbookName = false;
		}
		return bookList;
	}

	void bookSearch() {

		System.out.println("1. 도서제목" + "\t" + "2번 작가/지은이" + "\t" + "3번 카테고리");
		String search = sc.nextLine();

		switch (search) {

		case "1":
			System.out.println("도서 제목을(를) 입력해주세요");
			String bs = sc.nextLine();

			int a = 0;
			System.out.printf("%s\t%s\t%s\t%s \n", "도서이름", "카테고리", "도서작가", "대출가능여부");
			for (int i = 0; i < bookList.length; i++) {

				if (bookList[i][0].contains(bs)) {
					System.out.printf("%s\t%s\t%s\t%s \n", bookList[i][0], bookList[i][2], bookList[i][3],
							bookList[i][4]);
					a++;
				}
			}
			if (a == 0) {
				System.out.println("존재하지 않는 도서입니다.");
			}
			break;

		case "2":
			System.out.println("작가/지은이 를(을) 입력해주세요");
			String bs1 = sc.nextLine();

			int a1 = 0;
			System.out.printf("%s\t%s\t%s\t%s \n", "도서이름", "카테고리", "도서작가", "대출가능여부");
			for (int i = 0; i < bookList.length; i++) {

				if (bookList[i][3].contains(bs1)) {
					System.out.printf("%s\t%s\t%s\t%s \n", bookList[i][0], bookList[i][2], bookList[i][3],
							bookList[i][4]);
					a1++;
				}
			}
			if (a1 == 0) {
				System.out.println("존재하지 않는 작가/지은이 입니다.");
			}
			break;

		case "3":

			System.out.println("카테고리를 입력해주세요");
			String bs2 = sc.nextLine();

			int a2 = 0;
			System.out.printf("%s\t%s\t%s\t%s \n", "도서이름", "카테고리", "도서작가", "대출가능여부");
			for (int i = 0; i < bookList.length; i++) {
				if (bookList[i][2].contains(bs2)) {
					System.out.printf("%s\t%s\t%s\t%s \n", bookList[i][0], bookList[i][2], bookList[i][3],
							bookList[i][4]);
					a2++;
				}
			}
			if (a2 == 0) {
				System.out.println("존재하지않은 카테고리 입니다.");
			}
			break;

		default:
			System.out.println("잘못입력하셨습니다.(1~3)");
		}
	}

	void bookStatus() {
		if (bookList != null) {
			System.out.printf("%s\t%-10s\t%s\t%s\t%s \n", "도서이름", "도서코드", "카테고리", "도서작가", "대출가능여부");
			for (int i = 0; i < bookList.length; i++) {
				System.out.printf("%s\t%-10s\t%s\t%s\t%s \n", bookList[i][0], bookList[i][1], bookList[i][2],
						bookList[i][3], bookList[i][4]);
			}
			System.out.println("현재 총 " + bookList.length + "권 관리중입니다.");

		} else
			System.out.println("목록이 없습니다.");
	}

}
