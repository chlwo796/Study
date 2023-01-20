package ch04.sec01;

import java.util.Scanner;

public class ContinueEx2 {

	public static void main(String[] args) {
//		1~100까지 for문으로 출력해보기

//		 for (int i = 1; i <= 100; i++) { System.out.print(i + " "); }
//		 
//		 1~100을 열번 출력하기
//		 
//		 for (int i = 1; i <= 10; i++) { System.out.println(); for (int j = 1; j <=
//		 100; j++) System.out.print(j + " "); }
//		 
//		 System.out.println();
//		 
//		 홍길동 20번
//		 
//		 for (int i = 1; i <= 20; i++) { System.out.print("홍길동 "); }
//		 
//		 System.out.println();
//		 
//		 홍길동 20번 출력한 줄을 5번 반복
//		 
//		 for (int i = 1; i <= 5; i++) { System.out.println(); for (int j = 1; j <= 20;
//		 j++) { System.out.print("홍길동 "); } }

//		1~50 합

//		System.out.println();
//		
//		int sum = 0;
//		for(int i = 1; i<=50; i++) {
//			sum = sum + i;
//		}
//		System.out.println(sum);

//		1~50까지의 합을 구하다가 500 이상이 되는 순간 i값은 얼마인가요?

		int i = 1;
		int sum = 0;
		for (; i <= 50; i++) {
			sum = sum + i;
			if (sum >= 500)
				break; // 500 이상이 되는 순간 {}에서 탈출
		}
		System.out.println("\nsum = " + sum + ", i = " + i); // for 밖에서 i를 호출하고 싶으면 main method에서 i를 먼저 선언한다.

//		1~100까지 출력하고 55일 때 break 반복 탈출하기

		System.out.println();

		for (int j = 1; j <= 100; j++) {
			System.out.print(j + " ");
			if (j == 55)
				break;
		}

//		10,20,30~1000 20번째일 때 탈출하여 해당항목 출력
		
		System.out.println();
		
		int k = 1;
		int a=0;
		for(; k<=100; k++) {
			a = k*10;
			System.out.print(a + " ");
			if(k == 20) break;
		}
		System.out.println("a = " + a);
		
//		int cnt=0;
//		int k = 10;
//		for(; k<=100; k+=10) {
//			System.out.print(k + " ");
//			cnt++;
//			if(cnt == 20) break;
//		}
//		System.out.println("k = " + k);		// cnt 횟수를 정의해서 코딩한 것.
		
//		정수로 입력을 계속 받다가 0이 되면 반복문 끝나기
		
		System.out.println();
		
		Scanner sc = new Scanner(System.in);
		
//		int number = 0;
//		while(number!=0) {
//			System.out.print("숫자를 입력해주세요.");
//			number = sc.nextInt();
//			System.out.print("/n입력하신 숫자는 " + number + "입니다.");
//			if(number == 0) break;
//				}
//		System.out.println("종료");		// 오류발생
		
		while(true) {		// while(true), (false) => true면 계속 실행, false면 실행x
			int number = sc.nextInt();
			if(number == 0) break;
		}
		
//		do-while, 문자로 단어를 계속 입력받다가 no또는 NO가 입력되면 반복문 종료
//		
		
		System.out.println();
		
		do{
			String str = sc.nextLine();
			if(str.toLowerCase().equals("no")) break;	// no,NO,No,oN 도 모두 적용하고 싶다면 모두 소문자, 대문자로 바꿔 준 후 적용
		}while(true);
		
	}

}
