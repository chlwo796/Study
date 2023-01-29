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

		System.out.println("���������α׷��Դϴ�.");
		while (run) {
			System.out.println("1. ȸ������ | 2. �α��� | 3. ����");
			System.out.println("����>");
			String choice = sc.nextLine();

			if (choice.equals("1")) {
				System.out.println("ȸ������");
				System.out.println("Id>");
				si.setId(sc.nextLine());
				System.out.println("Password>");
				si.setPw(sc.nextLine());
				System.out.println("ȸ�����Լ���");
				continue;
			} else if (choice.equals("2")) {
				if (si.getId() == null) {
					System.out.println("ȸ�������� �����ϴ�. ȸ������ ���ּ���.");
					continue;
				}
				System.out.println("���̵�� �н����带 �Է����ּ���.");
				System.out.println("���̵�>");
				si.setInputId(sc.nextLine());
				System.out.println("�н�����>");
				si.setInputPw(sc.nextLine());

				if (si.getId().equals(si.getId()) && si.getPw().equals(si.getInputPw())) {
					System.out.println("�α��μ���");
					break;
				} else
					System.out.println("�ٽ��Է����ּ���");
				continue;

			} else if (choice.equals("3")) {
				flage = false;
				System.out.println("�����մϴ�.");
				break;
			} else
				System.out.println("�߸������̽��ϴ�.");
			continue;
		}

		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		Date time = new Date();

		String time1 = format1.format(time);

		Library lb = new Library();

		while (flage) {
			System.out.println(time1);
			System.out.println("--------------------------------------------------------");
			System.out.println("1.�����Է� | 2.�������� | 3.�����ݳ� | 4.�����˻� | 5.������Ȳ | 6.����");
			System.out.println("--------------------------------------------------------");
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
	protected static final int MIN_COUNT = 0; // bookList�� ó���� �Է¹��� ���������� �迭�� �̸� �����α⶧����
	protected static final int MAX_COUNT = 10; // ��Ÿ, 0�� �������� �����ϰ��� ������ ������ �ɾ�ξ���.

	int count;
	int codeCheck; // �ʱⰪ 0�� �ƴ� �� �ڵ��ߺ� ����, �ݺ��Է� ����
	String tempCode; // �ʱ� �迭���� �Է¹��� �ڵ带 �ٷ� ���� �ʰ� �ӽõ����ͷ� ���ǹ� ����, ���� �迭�� ���� �ִ´�.
	String check; // �ʱ� �Է½� ���� ���� �迭�����͸� ������ �� �Է��ϱ⶧����, �Է��ѳ����� �´��� Ȯ���ϴ� �뵵

	String[][] bookList;
	boolean containbookName;
	Scanner sc = new Scanner(System.in);

	String[][] firstTime() {

		System.out.println("������ ����Դϱ�?(1~10)");
		count = sc.nextInt();
		sc.nextLine();
		if (count <= MIN_COUNT || count > MAX_COUNT) {
			System.out.println("������ �߸� �ԷµǾ����ϴ�. �ٽ��Է����ּ���(1~10)");
			firstTime();
		}
		bookList = new String[count][5];

		for (int i = 0; i < bookList.length; i++) {
			while (true) {
				System.out.print((i + 1) + "��° ���� �ڵ�>");
				tempCode = sc.nextLine();
				for (int j = 0; j < bookList.length; j++) {
					if (bookList[j][0] != null && bookList[j][0].equals(tempCode)) {
						codeCheck++;
						break;
					}
				}
				if (codeCheck == 0) {
					bookList[i][0] = tempCode;
				} else {
					System.out.println("�ߺ��� �ڵ��Դϴ�. �ٽ��Է����ּ���.");
					codeCheck = 0;
					continue;
				}
				break;
			}

			System.out.print((i + 1) + "��° ���� ����>");
			bookList[i][1] = sc.nextLine();
			System.out.print((i + 1) + "��° ���� ī�װ�>");
			bookList[i][2] = sc.nextLine();
			System.out.print((i + 1) + "��° ���� �۰�>");
			bookList[i][3] = sc.nextLine();
			bookList[i][4] = "Y";

		}

		System.out.printf("%-8s\t%s\t%s\t%s\t%s \n", "�����ڵ�", "��������", "ī�װ�", "�����۰�", "���Ⱑ�ɿ���");
		for (

				int i = 0; i < bookList.length; i++) {
			System.out.printf("%-8s\t%s\t%s\t%s\t%s\n", bookList[i][0], bookList[i][1], bookList[i][2], bookList[i][3],
					bookList[i][4]);
		}
		while (true) {
			System.out.println("�Է��Ͻ������� �½��ϱ�?(y/n)");
			check = (sc.nextLine()).toLowerCase(); // �Է°��� �� �ҹ��ڷ� ġȯ
			if (check.equals("n")) {
				System.out.println("�ʱ�ȭ������ �̵��մϴ�.");
				firstTime();
			} else if (check.equals("y")) {
				break;
			} else {
				System.out.println("�߸��Է��ϼ̽��ϴ�.");
				continue;
			}
			break;

		}

		System.out.println("������ �Է� �Ϸ�");
		return bookList;
	}

	String[][] input() {
		if (bookList == null) {
			firstTime();
		} else {
			System.out.println("������ ����Դϱ�?(1~10)");
			count = sc.nextInt();
			sc.nextLine();
			if (count <= MIN_COUNT || count > MAX_COUNT) {
				System.out.println("������ �߸� �ԷµǾ����ϴ�. �ٽ��Է����ּ���(1~10)");
				input();
			}
			String[][] newArray = new String[count + bookList.length][5];
			for (int i = bookList.length; i < newArray.length; i++) {
				while (true) {
					System.out.print("�߰��� " + (i - bookList.length + 1) + "��° ���� �ڵ�>");
					tempCode = sc.nextLine();
					for (int j = 0; j < bookList.length; j++) {
						if (bookList[j][0] != null && bookList[j][0].equals(tempCode)) {
							codeCheck++;
							break;
						}
						if (newArray[j + bookList.length - 1][0] != null
								&& newArray[j + bookList.length - 1][0].equals(tempCode)) {
							codeCheck++;
							break;
						}
					}
					if (codeCheck == 0) {
						newArray[i][0] = tempCode;
					} else {
						System.out.println("�ߺ��� �ڵ��Դϴ�. �ٽ��Է����ּ���.");
						codeCheck = 0;
						continue;
					}
					break;
				}

				System.out.print("�߰��� " + (i - bookList.length + 1) + "��° ���� ����>");
				newArray[i][1] = sc.nextLine();
				System.out.print("�߰��� " + (i - bookList.length + 1) + "��° ���� ī�װ�>");
				newArray[i][2] = sc.nextLine();
				System.out.print("�߰��� " + (i - bookList.length + 1) + "��° ���� �۰�>");
				newArray[i][3] = sc.nextLine();
				newArray[i][4] = "Y";

			}

			System.out.printf("%-8s\t%s\t%s\t%s\t%s \n", "�����ڵ�", "��������", "ī�װ�", "�����۰�", "���Ⱑ�ɿ���");
			for (int i = bookList.length; i < newArray.length; i++) {
				System.out.printf("%-8s\t%s\t%s\t%s\t%s\n", newArray[i][0], newArray[i][1], newArray[i][2],
						newArray[i][3], newArray[i][4]);
			}
			while (true) {
				System.out.println("�Է��Ͻ������� �½��ϱ�?(y/n)");
				check = (sc.nextLine()).toLowerCase(); // �Է°��� �� �ҹ��ڷ� ġȯ
				if (check.equals("n")) {
					System.out.println("�ʱ�ȭ������ �̵��մϴ�.");
					input();
				} else if (check.equals("y")) {
					break;
				} else {
					System.out.println("�߸��Է��ϼ̽��ϴ�.");
					continue;
				}
				break;

			}

			System.arraycopy(bookList, 0, newArray, 0, bookList.length);
//			ArrayList -> ����غ���

			bookList = newArray;
			System.out.println("������ �Է� �Ϸ�");
		}

		return bookList;
	}

	String[][] rentalBook() {
		if (bookList != null) {
			System.out.println("�뿩�� å �̸� > ");
			String bookName = sc.nextLine();
			for (int i = 0; i < bookList.length; i++) {
				if (bookName.equals(bookList[i][1]) && bookList[i][4].equals("Y")) {
					bookList[i][4] = "N";
					System.out.println(bookName + " �뿩�Ǿ����ϴ�.");
					containbookName = false;
					break;
				} else
					containbookName = true;

			}
			if (containbookName) {
				System.out.println(bookName + "��(��) �뿩�� �Ұ����� �����Դϴ�. ���⿩�� �� ����Ʈ�� Ȯ�����ּ���.");
				containbookName = false;
			}
			return bookList;
		} else {
			System.out.println("��������� �����ϴ�. ����� �Է����ּ���.");
			return null;
		}
	}

	String[][] returnBook() {
		if (bookList != null) {

			System.out.println("�ݳ��� ���� �̸� > ");
			String bookName = sc.nextLine();

			for (int i = 0; i < bookList.length; i++) {
				if (bookName.equals(bookList[i][1]) && bookList[i][4].equals("N")) {
					bookList[i][4] = "Y";
					System.out.println(bookName + " �ݳ��Ǿ����ϴ�.");
					containbookName = false;
					break;
				} else {
					containbookName = true;
				}
			}
			if (containbookName) {
				System.out.println(bookName + "��(��) �ݳ��� �Ұ����� �����Դϴ�. ���⿩�� �� ����Ʈ�� Ȯ�����ּ���.");
				containbookName = false;
			}
			return bookList;
		} else {
			System.out.println("��������� �����ϴ�. ����� �Է����ּ���");
			return null;
		}
	}

	void bookSearch() {
		if (bookList != null) {
			System.out.println("1. ��������" + "\t" + "2. �۰�/������" + "\t" + "3. ī�װ�" + "\t" + "4. ����ȭ��");
			String search = sc.nextLine();

			switch (search) {

			case "1":
				System.out.println("���� ������(��) �Է����ּ���");
				String bs = sc.nextLine();

				int a = 0;
				System.out.printf("%s\t%s\t%s\t%s \n", "�����̸�", "ī�װ�", "�����۰�", "���Ⱑ�ɿ���");
				for (int i = 0; i < bookList.length; i++) {

					if (bookList[i][1].contains(bs)) {
						System.out.printf("%s\t%s\t%s\t%s \n", bookList[i][1], bookList[i][2], bookList[i][3],
								bookList[i][4]);
						a++;
					}
				}
				if (a == 0) {
					System.out.println("�������� �ʴ� �����Դϴ�.");
				}
				break;

			case "2":
				System.out.println("�۰�/������ ��(��) �Է����ּ���");
				String bs1 = sc.nextLine();

				int a1 = 0;
				System.out.printf("%s\t%s\t%s\t%s \n", "�����̸�", "ī�װ�", "�����۰�", "���Ⱑ�ɿ���");
				for (int i = 0; i < bookList.length; i++) {

					if (bookList[i][3].contains(bs1)) {
						System.out.printf("%s\t%s\t%s\t%s \n", bookList[i][1], bookList[i][2], bookList[i][3],
								bookList[i][4]);
						a1++;
					}
				}
				if (a1 == 0) {
					System.out.println("�������� �ʴ� �۰�/������ �Դϴ�.");
				}
				break;

			case "3":

				System.out.println("ī�װ��� �Է����ּ���");
				String bs2 = sc.nextLine();

				int a2 = 0;
				System.out.printf("%s\t%s\t%s\t%s \n", "�����̸�", "ī�װ�", "�����۰�", "���Ⱑ�ɿ���");
				for (int i = 0; i < bookList.length; i++) {
					if (bookList[i][2].contains(bs2)) {
						System.out.printf("%s\t%s\t%s\t%s \n", bookList[i][1], bookList[i][2], bookList[i][3],
								bookList[i][4]);
						a2++;
					}
				}
				if (a2 == 0) {
					System.out.println("������������ ī�װ� �Դϴ�.");
				}
				break;
			case "4": {
				System.out.println("����ȭ������ �̵��մϴ�.");
				break;
			}
			default: {
				System.out.println("�߸��Է��ϼ̽��ϴ�.(1~4)");
				bookSearch();
			}
			}

		} else {
			System.out.println("�˻��� ����� �����ϴ�. ������ �Է����ּ���.");
		}
	}

	void bookStatus() {
		if (bookList != null) {
			System.out.printf("%-8s\t%s\t%s\t%s\t%s \n", "�����ڵ�", "��������", "ī�װ�", "�����۰�", "���Ⱑ�ɿ���");
			for (int i = 0; i < bookList.length; i++) {
				System.out.printf("%-8s\t%s\t%s\t%s\t%s \n", bookList[i][0], bookList[i][1], bookList[i][2],
						bookList[i][3], bookList[i][4]);
			}
			System.out.println("���� �� " + bookList.length + "�� �������Դϴ�.");

		} else
			System.out.println("����� �����ϴ�.");
	}

}
