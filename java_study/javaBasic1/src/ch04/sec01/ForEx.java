package ch04.sec01;

import java.util.Scanner;

public class ForEx {

	public static void main(String[] args) {
//		For
//		형식
//		for (변수초기값 ; 조건식 ; 증감값) {
//			반복할 내용
//		}
		for (int i = 1; i <= 10; i++) { // i는 1부터 시작, i가 10보다 같거나 작을때까지, 반복시 i++
			System.out.print(i + " ");
		}

		System.out.println();

		for (int i = 10; i >= 0; i--) { // i라는 변수는 각 for에서 선언되었기때문에 반복사용 가능
			System.out.print(i + " ");
		}

		System.out.println();

//		문제1 10, 20 30 40 ..100 출력하기

		for (int i = 1; i <= 10; i++) { // 변수초기값은 생략가능, 위에서 선언할 수 있음.
			int i2 = i * 10;
			System.out.print(i2 + " ");
		}

		System.out.println();

//		문제2 1~100까지 합 구하기

		int i = 0;
		int sum = 0;

		for (; i <= 100; i++) {
			sum = sum + i;
		}
		System.out.println(sum + " ");

//		문제3 0~100까지 홀수의 합, 홀수의 개수

		int i1 = 1;
		int sum1 = 0;
		int sum2 = 0;
		int count1 = 0;
		for (; i1 <= 100; i1++) { // 홀수의 개수 count = count + 1;로도 가능하다.
			sum1 = sum1 + i1;
			count1 = (i1 % 2);
			sum2 = sum2 + count1;
			i1 = i1 + 1;

		}
		System.out.println(sum1 + " ");
		System.out.println(sum2 + " ");

//		문제4 1~100까지 출력하되 1줄에 10개씩
//		아래는 내가 하다가 만것
//		int i2 = 1;
//		int i3 = i2+9;
//		for (; i2<=i3; i2++) {
//			System.out.print(i2 +" ");
//		}
//		System.out.println();
//		
//		i2 = i2 + 10;
//		i3 = i3 + 9;
//		for (i2 = i2 +10; i2<=i3; i2++) {
//			System.out.print(i2 +" ");
//	}

//		방법1 개수를 10개씩 세어서 10개 줄바꿈하기

		int cnt = 0;
		for (int i2 = 1; i2 <= 100; i2++) {
			System.out.print(i2 + " ");
			cnt++;
			if (cnt == 10) {
				System.out.println();
				cnt = 0; // 다시 초기화 하는것이 point!!
			}
		}

//		방법2 10의 배수(나머지 = 0)을 활용

		for (int i2 = 1; i2 <= 100; i2++) {
			System.out.print(i2 + " ");

			if (i2 % 10 == 0) {
				System.out.println(); // 변수 한개로도 간단하게 가능!
			}
		}
//		문제5 while 아래와 같이 출력해보세요. (12345)를 입력한 것임.
//		결과화면
//		숫자를 입력하세요. (예.12345) ==> (12345)
//		sum 5 number = 12345
//		sum 9 number = 1234
//		sum 12 number = 123
//		sum 14 number = 12
//		sum 15 number = 1
//		각 자리수의 합 : 15

		Scanner sc = new Scanner(System.in);
		System.out.print("숫자를 입력하세요. (예:12345) ==> ");
		int number = sc.nextInt();
		int number1 = 0;	// 맨뒷자리수 없애기 위한 변수
		int temp = 0;
		int s = 0;
		while(number > 0) {
			number1 = number / 10;
			temp = number1 * 10;
			s = s + number - temp;
			System.out.println("sum = " + s + " number = " + number);
			number = number1;
		}
//		sum변수에 5를 넣어주기 12345 - 12340 = 5, 12340 = 1234 * 10, 1234 = 12345 / 10
//		알고리즘 조금씩 공부하기. 반복적으로 연습해서 숙달시키기.

//		int number1 = number / 10;	// number1 = 1234
//		System.out.println(number1);
//		int temp = number1 * 10;	// temp = 12340
//		System.out.println(temp);
//		int s = number - temp;	// s = 12345 - 12340 = 5
//		System.out.println("sum = " + s + " number = " + number);
//		number = number1; // 1234
//		number1 = number / 10; // 123
//		System.out.println(number1);
//		temp = number1 * 10; // 1230
//		s = s + (number - temp); // 1234 - 1230 = 4
//		System.out.println("sum = " + s + " number = " + number);
		
//		문제6 do~while 숫자를 계속 입력받는다. 0을 입력하면 지금까지 입력한 숫자를 모두 더한 것을 출력한다.
//		합계를 구할 숫자를 입력하세요(끝내려면 0을 입력)
//		100 //(입력수)
//		200 //(입력수)
//		300 //(입력수)
//		400 //(입력수)
//		0 //(입력수)
//		합계 : 100 //(출력)
		int n6;
		int sum6 = 0;
		do {
			System.out.println("문제6번 숫자를 입력하세요");
			n6 = sc.nextInt();
			sum6 = sum6 + n6;
		}while(n6 !=0);
		System.out.println("합계: " + sum6);
}

}
