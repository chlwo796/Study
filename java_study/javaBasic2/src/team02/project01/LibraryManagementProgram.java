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
			System.out.println("1.�����Է�\t2.��������\t3.�����ݳ�\t4.�����˻�\t5.������Ȳ\t6.����");
			System.out.println("-------------------------------------------------------");
			System.out.print("����>");
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
				System.out.println("���� ���� ���α׷� ����");
				flage = false;
				break;
			default:
				System.out.println("�߸��Է��ϼ̽��ϴ�.(1~6)");
			}
		}
	}

//	private static void bookStatus() {
//		// TODO Auto-generated method stub
//
//		System.out.println("�����̸�\t���Ⱑ��");
//		for (int i = 0; i < bookList.length; i++) {
//			System.out.print(bookList[i][0] + "\t" + bookList[i][1]);
//			System.out.println();
//		}
//	}

//	private static void insertBook(boolean x) {
//		if (x) {
//			System.out.println("�Է��� ������ �Է��ϼ���. �̰��� �������� å����� ����� ���Դϴ�.(�ʱⰪ)");
//			count = sc.nextInt();
//			sc.nextLine();
//			bookList = new String[count][2];
//			for (int i = 0; i < bookList.length; i++) {
//				System.out.print((i + 1) + "��° å>");
//				bookList[i][0] = sc.nextLine();
//			}
//			x = false;
//		}
//		System.out.println("�߰��Է�>");
//		count = sc.nextInt();
//		sc.nextLine();
//		String[][] newArray = new String[count + bookList.length][2];
//		for (int i = bookList.length; i < newArray.length; i++) {
//			System.out.print("�߰��� " + (i - bookList.length + 1) + "��° å>");
//			newArray[i][0] = sc.nextLine(); // ���⼭ ���� ������ �迭�� �߰��� å ����ŭ�� ������ �迭�� �������. newArray�迭�� �� ���� ��
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
		System.out.println("�Է��� ������ �Է��ϼ���. �̰��� �������� å����� ����� ���Դϴ�.(�ʱⰪ)");
		count = sc.nextInt();
		sc.nextLine();
		bookList = new String[count][2];
		for (int i = 0; i < bookList.length; i++) {
			System.out.print((i + 1) + "��° å>");
			bookList[i][0] = sc.nextLine();
			bookList[i][1] = "���Ⱑ��";
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
				newArray[i][0] = sc.nextLine(); // ���⼭ ���� ������ �迭�� �߰��� å ����ŭ�� ������ �迭�� �������. newArray�迭�� �� ���� ��
				newArray[i][1] = "���Ⱑ��";
			}
			System.arraycopy(bookList, 0, newArray, 0, bookList.length);

			return bookList = newArray;
		} else
			return bookList;
	}

	void bookStatus() {
		System.out.println("�����̸�\t���Ⱑ��");
		for (int i = 0; i < bookList.length; i++) {
			System.out.print(bookList[i][0] + "\t" + bookList[i][1]);
			System.out.println();
		}

	}
}