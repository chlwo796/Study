package team02.project01;

import java.util.Scanner;

public class LoginProgramm {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String id1 = null, id2 = null;
		String passwd1 = null, passwd2 = null;
		int num = 0;
		boolean run = true;

		while (run) {
			System.out.println("1.로그인");
			System.out.println("2.회원가입");
			System.out.println("3.나가기");
			System.out.println("---------------");
			num = sc.nextInt();
			if (num == 1) {
				if (id1 == null && passwd1 == null) {
					System.out.println("회원가입부터 해주세요.");
					continue;
				}
				System.out.print("아이디: ");
				id2 = sc.next();
				System.out.print("비밀번호: ");
				passwd2 = sc.next();
				if (id1.equals(id2) && passwd1.equals(passwd2)) {
					System.out.println("로그인성공!");
				} else {
					System.out.println("다시입력해주세요.");
				}
			} else if (num == 2) {
				System.out.print("아이디: ");
				id1 = sc.next();
				System.out.print("비밀번호: ");
				passwd1 = sc.next();
				System.out.println("회원가입 성공!");
			} else if (num == 3) {
				run = false;
				System.out.println("프로그램 종료!!");
			}
		}

	}

}