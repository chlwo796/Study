package library;

import java.util.Scanner;

public class Book {
	public static void main(String[] args) {
		boolean run = true;
		String[] bTitle = null;
		String[] bAuthor = null;
		int[] bNumber = null;
		String[] newbTitle = null;
		String[] newbAuthor = null;
		int[] newbNumber = null;
		int bCnt = 0;
		Scanner sc = new Scanner(System.in);

		while (run) {
			System.out.println("================================================================");
			System.out.println("------------------------���� ���� ���� ���α׷�-----------------------");
			System.out.println("================================================================");
			System.out.println("1. ���� ��� | 2. ���� ��� | 3. ���� ���� | 4. ���� ���� | 5. ���α׷� ����");

			System.out.print("����> ");
			int selecNo = sc.nextInt();
			switch (selecNo) {
			case 1: {
				System.out.println();
				System.out.println("1. ���� ���> ");
				System.out.print("����� ���� �� ��> ");
				System.out.println();
				bCnt = sc.nextInt();
				bTitle = new String[bCnt];
				bAuthor = new String[bCnt];
				bNumber = new int[bCnt];
				for (int i = 0; i < bCnt; i++) {
					System.out.print("���� ����> ");
					bTitle[i] = sc.next();
					System.out.print("������> ");
					bAuthor[i] = sc.next();
					System.out.print("���� ��ȣ> ");
					bNumber[i] = sc.nextInt();
					System.out.println();

				}
				System.out.println("��� �Ϸ�");
			}
				break;
			case 2: {
				System.out.println("2. ���� ���> ");
				for (int i = 0; i < bCnt; i++) {
					System.out.println("���� ����: " + bTitle[i] + "\n������: " + bAuthor[i] + "\n���� ��ȣ: " + bNumber[i]);
					System.out.println();
				}
			}
				break;
			case 3: {
				System.out.println("3. ���� ����> ");
				System.out.print("�����Ͻðڽ��ϱ�? ������ ���ϸ� y, ������ ������ n�� �Է��ϼ���. ");
				String yn = sc.next();
				if (yn.equals("n")) {
					System.out.println("���� �޴��� ���ư��ϴ�.");
					break;
				} else if (yn.equals("y")) {
					System.out.print("������ ���� ��ȣ�� �Է��ϼ���> ");
					int num = sc.nextInt();
					newbTitle = new String[bCnt];
					newbAuthor = new String[bCnt];
					newbNumber = new int[bCnt];
					System.out.println("���� ����: " + bTitle[num - 1] + "\n������: " + bAuthor[num - 1]);
					for (int i = 0; i < bCnt; i++) {
						System.out.print("���� ������ �����Ͻðڽ��ϱ�? ������ ���� ������ �Է��ϼ���. ������ ������ ������ n�� �Է��ϼ���. ");
						newbTitle[i] = sc.next();
						if (newbTitle[i].equals("n")) {
							System.out.println("���� �޴��� ���ư��ϴ�. ");
							break;
						} else
							bTitle[i] = newbTitle[i];
						System.out.print("�����̸� �����Ͻðڽ��ϱ�? ������ �����̸� �Է��ϼ���. ������ ������ ������ n�� �Է��ϼ���. ");
						newbAuthor[i] = sc.next();
						System.out.println();
						System.out.println("���� �Ϸ�");
						if (newbAuthor[i].equals("n")) {
							System.out.println("���� �޴��� ���ư��ϴ�.");
							break;
						} else
							bAuthor[i] = newbAuthor[i];
						break;
					}
				}
			}
				break;
			case 4: {
				System.out.println("4. ���� ����> ");
				System.out.print("�����Ͻðڽ��ϱ�? ������ ���ϸ� y, ������ ������ n�� �Է��ϼ���. ");
				String yn = sc.next();
				if (yn.equals("n")) {
					System.out.println("���� �޴��� ���ư��ϴ�.");
					break;
				} else if (yn.equals("y")) {
					System.out.print("������ ���� ��ȣ�� �Է��ϼ���> ");
					int num = sc.nextInt();
					System.out.println("���� ����: " + bTitle[num - 1] + "\n������: " + bAuthor[num - 1]);
					for (int i = 0; i < bCnt; i++) {
						System.out.print("������ �����Ͻðڽ��ϱ�? ������ ���ϸ� ������ ���� ��ȣ�� �ٽ� �Է��ϼ���. ������ ������ ������ 0�� �Է��ϼ���. ");
						int input = sc.nextInt();
						if (input == 0) {
							System.out.println("���� �޴��� ���ư��ϴ�.");
							break;
						} else {
							if (bNumber[i] == input) {
								bTitle[i] = null;
								bAuthor[i] = null;
								bNumber[i] = 0;
								System.out.println();
								System.out.println("���� �Ϸ�");
								break;
							} else
								System.out.println("�ش� ������ ã�� �� �����ϴ�.");
							break;
						}
					}
				}
			}
				break;
			case 5: {
				run = false;
				break;
			}
			default: {
				System.out.println("�߸� �Է��ϼ̽��ϴ�. 1~5�� ���� �߿��� �ٽ� �������ּ���.");
			}
			}
		}
		System.out.println("���� ���� ���α׷� ����");
	}
}