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
			System.out.println("------------------------도서 정보 관리 프로그램-----------------------");
			System.out.println("================================================================");
			System.out.println("1. 도서 등록 | 2. 도서 목록 | 3. 도서 수정 | 4. 도서 삭제 | 5. 프로그램 종료");

			System.out.print("선택> ");
			int selecNo = sc.nextInt();
			switch (selecNo) {
			case 1: {
				System.out.println();
				System.out.println("1. 도서 등록> ");
				System.out.print("등록할 도서 권 수> ");
				System.out.println();
				bCnt = sc.nextInt();
				bTitle = new String[bCnt];
				bAuthor = new String[bCnt];
				bNumber = new int[bCnt];
				for (int i = 0; i < bCnt; i++) {
					System.out.print("도서 제목> ");
					bTitle[i] = sc.next();
					System.out.print("지은이> ");
					bAuthor[i] = sc.next();
					System.out.print("도서 번호> ");
					bNumber[i] = sc.nextInt();
					System.out.println();

				}
				System.out.println("등록 완료");
			}
				break;
			case 2: {
				System.out.println("2. 도서 목록> ");
				for (int i = 0; i < bCnt; i++) {
					System.out.println("도서 제목: " + bTitle[i] + "\n지은이: " + bAuthor[i] + "\n도서 번호: " + bNumber[i]);
					System.out.println();
				}
			}
				break;
			case 3: {
				System.out.println("3. 도서 수정> ");
				System.out.print("수정하시겠습니까? 수정을 원하면 y, 원하지 않으면 n을 입력하세요. ");
				String yn = sc.next();
				if (yn.equals("n")) {
					System.out.println("메인 메뉴로 돌아갑니다.");
					break;
				} else if (yn.equals("y")) {
					System.out.print("수정할 도서 번호를 입력하세요> ");
					int num = sc.nextInt();
					newbTitle = new String[bCnt];
					newbAuthor = new String[bCnt];
					newbNumber = new int[bCnt];
					System.out.println("도서 제목: " + bTitle[num - 1] + "\n지은이: " + bAuthor[num - 1]);
					for (int i = 0; i < bCnt; i++) {
						System.out.print("도서 제목을 수정하시겠습니까? 수정할 도서 제목을 입력하세요. 수정을 원하지 않으면 n을 입력하세요. ");
						newbTitle[i] = sc.next();
						if (newbTitle[i].equals("n")) {
							System.out.println("메인 메뉴로 돌아갑니다. ");
							break;
						} else
							bTitle[i] = newbTitle[i];
						System.out.print("지은이를 수정하시겠습니까? 수정할 지은이를 입력하세요. 수정을 원하지 않으면 n을 입력하세요. ");
						newbAuthor[i] = sc.next();
						System.out.println();
						System.out.println("수정 완료");
						if (newbAuthor[i].equals("n")) {
							System.out.println("메인 메뉴로 돌아갑니다.");
							break;
						} else
							bAuthor[i] = newbAuthor[i];
						break;
					}
				}
			}
				break;
			case 4: {
				System.out.println("4. 도서 삭제> ");
				System.out.print("삭제하시겠습니까? 삭제를 원하면 y, 원하지 않으면 n을 입력하세요. ");
				String yn = sc.next();
				if (yn.equals("n")) {
					System.out.println("메인 메뉴로 돌아갑니다.");
					break;
				} else if (yn.equals("y")) {
					System.out.print("삭제할 도서 번호를 입력하세요> ");
					int num = sc.nextInt();
					System.out.println("도서 제목: " + bTitle[num - 1] + "\n지은이: " + bAuthor[num - 1]);
					for (int i = 0; i < bCnt; i++) {
						System.out.print("정말로 삭제하시겠습니까? 삭제를 원하면 삭제할 도서 번호를 다시 입력하세요. 삭제를 원하지 않으면 0을 입력하세요. ");
						int input = sc.nextInt();
						if (input == 0) {
							System.out.println("메인 메뉴로 돌아갑니다.");
							break;
						} else {
							if (bNumber[i] == input) {
								bTitle[i] = null;
								bAuthor[i] = null;
								bNumber[i] = 0;
								System.out.println();
								System.out.println("삭제 완료");
								break;
							} else
								System.out.println("해당 도서를 찾을 수 없습니다.");
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
				System.out.println("잘못 입력하셨습니다. 1~5번 숫자 중에서 다시 선택해주세요.");
			}
			}
		}
		System.out.println("도서 관리 프로그램 종료");
	}
}