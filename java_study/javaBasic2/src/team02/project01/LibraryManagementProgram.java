package team02.project01;

import java.util.Scanner;


public class LibraryManagementProgram {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Library lb = new Library();

		boolean flage = true;

		while (flage) {
			System.out.println("------------------------------------------------------");
			System.out.println("1.�����Է�\t2.��������\t3.�����ݳ�\t4.�����˻�\t5.������Ȳ\t6.����");
			System.out.println("-------------------------------------------------------");
			System.out.print("����>");
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
				System.out.println("���� ���� ���α׷� ����");
				flage = false;
				break;
			default:
				System.out.println("�߸��Է��ϼ̽��ϴ�.(1~6)");
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
		System.out.println("�Է��� ������ �Է��ϼ���. �̰��� �������� å����� ����� ���Դϴ�.(�ʱⰪ)");
		count = sc.nextInt();
		sc.nextLine();
		bookList = new String[count][2];
		for (int i = 0; i < bookList.length; i++) {
			System.out.print((i + 1) + "��° å>");
			bookList[i][0] = sc.nextLine();
			bookList[i][1] = "Y";
		}
		return bookList;
	}

	String[][] input() {

		System.out.println("�����Է��Դϱ�?(y/n)");
		String answer = sc.nextLine();
		if (answer.equals("y")) {
			firstTime();
		}
		System.out.println("�߰��Է��Ͻðڽ��ϱ�?(y/n)");
		String yesNo = sc.nextLine();
		if (yesNo.equals("y")) {
			System.out.println("�߰��Է¼�>");
			count = sc.nextInt();
			sc.nextLine();
			String[][] newArray = new String[count + bookList.length][2];
			for (int i = bookList.length; i < newArray.length; i++) {
				System.out.print("�߰��� " + (i - bookList.length + 1) + "��° å>");
				newArray[i][0] = sc.nextLine();
				newArray[i][1] = "Y";
			}
			System.arraycopy(bookList, 0, newArray, 0, bookList.length);

			return bookList = newArray;
		} else
			return bookList;
	}

	String[][] rentalBook() {

		System.out.println("�뿩�� å �̸� > ");
		String bookName = sc.nextLine();

		for (int i = 0; i < bookList.length; i++) {
			if (bookName.equals(bookList[i][0]) && bookList[i][1].equals("Y")) {
				bookList[i][1] = "N";
				System.out.println(bookName + " �뿩�Ǿ����ϴ�.");
				containbookName = false;
				break;
			} else
				containbookName = true;

		}
		if (containbookName) {
			System.out.println(bookName + "��(��) �뿩�� �Ұ����� å�Դϴ�. ���⿩�� �� ����Ʈ�� Ȯ�����ּ���.");
			containbookName = false;
		}
		return bookList;
	}

	String[][] returnBook() {

		System.out.println("�ݳ��� å �̸� > ");
		String bookName = sc.nextLine();

		for (int i = 0; i < bookList.length; i++) {
			if (bookName.equals(bookList[i][0]) && bookList[i][1].equals("N")) {
				bookList[i][1] = "Y";
				System.out.println(bookName + " �ݳ��Ǿ����ϴ�.");
				containbookName = false;
				break;
			} else {
				containbookName = true;
			}
		}
		if (containbookName) {
			System.out.println(bookName + "��(��) �ݳ��� �Ұ����� å�Դϴ�. ���⿩�� �� ����Ʈ�� Ȯ�����ּ���.");
			containbookName = false;
		}
		return bookList;
	}

	void bookSearch() {

		System.out.println("å ������ �Է����ּ���");
		String bs = sc.nextLine();

		for (int i = 0; i < bookList.length; i++) {
			if (bookList[i][0].contains(bs)) {

			}
			System.out.println("�����̸�\t���Ⱑ�ɿ���");
			System.out.println(bookList[i][0] + "\t" + bookList[i][1]);
		}

	}

	void bookStatus() {
		System.out.println("�����̸�\t���Ⱑ�ɿ���");
		for (int i = 0; i < bookList.length; i++) {
			System.out.print(bookList[i][0] + "\t" + bookList[i][1]);
			System.out.println();
		}

	}

}
