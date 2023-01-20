package ch04.sec01;

import java.util.Scanner;

public class WhileEx {

	public static void main(String[] args) {
		// while
		int n = 5;
		while (n == 5) {
			// 위의 조건이 참이면 이곳을 수행, 거짓이면 while을 종료한다.
			System.out.println(n);
			n++; // n = n + 1
		} // end while
		int a = 10;
		while (a >= 5) {
			System.out.print(a + " ");
			// 조건이 끝나야 되니깐 언젠가는 거짓이 되게 만들어야한다.
			a--;
		} // end while

		System.out.println(); // 줄바꿈

		// 문제 1 ~ 10 까지 출력
		int b = 1;
		while (b <= 10) {
			System.out.print(b++ + " ");
		} // end while

		System.out.println();

		// 문제 0 5 10 15 ~ 100
		int c = 0;
		while (c <= 100) {
			System.out.print(c + " ");
			c = c + 5;
		}

		System.out.println();

		// 문제 -100 -50 0 50 100
		int d = -100;
		while (d <= 100) {
			System.out.print(d + " ");
			d = d + 50;
		}
		
		System.out.println();
		
		// 문제 ABCD...Z까지 출력하기(65~90)
		char e = 'A';
//		int f = e;
		while (e <= 'Z') {
		System.out.print(e + " ");
		e++;	// 자동형변환
		}
		
		System.out.println();
		
		// 학생이름을 3번 반복해서 입력받고 출력하세요
		Scanner sc = new Scanner(System.in);
		
//		System.out.print("학생 이름은 ==>");
//		String name1 = sc.nextLine();
//		System.out.println(name1);
//		
//		System.out.print("학생 이름은 ==>");
//		String name2 = sc.nextLine();
//		System.out.println(name2);
//		
//		System.out.print("학생 이름은 ==>");
//		String name3 = sc.nextLine();
//		System.out.println(name3);
		// 이것을 반복문으로 고치면 1회 처리한 것을 세어주는 변수가 필요함.
		// 조건문을 무엇을 할까? count변수가 3이면 끝, 처리할 내용은 무엇인가?
		
		int count = 1;	// 초기값 설정. 갯수세기 변수
		String name = null;
		while(count <= 3) {
			System.out.print("학생 이름은 ==>");
			name = sc.nextLine();
			System.out.println(name);
			count++;
		}
	} // end main()

} // end class
